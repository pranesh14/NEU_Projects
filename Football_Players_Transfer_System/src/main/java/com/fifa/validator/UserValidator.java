package com.fifa.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.fifa.entity.UsersTable;

public class UserValidator implements Validator {
	
	@Override
	public boolean supports(Class aClass) {
		return UsersTable.class.equals(aClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {

		UsersTable user = (UsersTable) obj;
		Pattern p = Pattern.compile("[^\\w\\s]");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.invalid.name", "Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.invalid.user", "User Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");

		Matcher match = p.matcher(user.getName());
		if(match.find()){
			errors.rejectValue("name", "error.invalid.name", "Enter alphanumeric characters only");
		}
		
		match = p.matcher(user.getUsername());
		if(match.find()){
			errors.rejectValue("username", "error.invalid.user", "Enter alphanumeric characters only");
		}
		
		match = p.matcher(user.getPassword());
		if(match.find()){
			errors.rejectValue("password", "error.invalid.password", "Enter alphanumeric characters only");
		}

	}

}
