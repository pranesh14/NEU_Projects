package com.fifa.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.fifa.entity.TeamsTable;

public class TeamValidator implements Validator {

	@Override
	public boolean supports(Class aClass) {
		return aClass.equals(TeamsTable.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		TeamsTable team = (TeamsTable) obj;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.invalid.name", "Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "error.invalid.country", "Country Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.accountNumber",
				"error.invalid.account.accountNumber", "Account Number Required");

		Pattern p = Pattern.compile("[^a-zA-Z\\s]");
		Matcher match = p.matcher(team.getName());
		if (match.find()) {
			errors.rejectValue("name", "error.invalid.name", "Enter alphabetic characters only");
		}
		
		p = Pattern.compile("[^\\w\\s]");
		match = p.matcher(team.getAccount().getAccountNumber());
		if (match.find()) {
			errors.rejectValue("account.accountNumber", "error.invalid.account.accountNumber", 
					"Enter alphanumeric characters only");
		}
		
	}

}
