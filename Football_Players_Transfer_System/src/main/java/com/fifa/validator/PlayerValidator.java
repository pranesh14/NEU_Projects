package com.fifa.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.fifa.entity.PlayersTable;

public class PlayerValidator implements Validator {

	public boolean supports(Class aClass) {
		return aClass.equals(PlayersTable.class);
	}

	public void validate(Object obj, Errors errors) {
		PlayersTable player = (PlayersTable) obj;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.invalid.name", "Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "error.invalid.country", "Country Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "playerTypeCnfg.type", "error.invalid.playerTypeCnfg.type",
				"Player Type Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "playerPositionCnfg.position",
				"error.invalid.playerPositionCnfg.position", "Position Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "playerAttributes.pace", "error.invalid.playerAttributes.pace",
				"Pace Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "playerAttributes.shooting", "error.invalid.playerAttributes.shooting",
				"Shooting Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "playerAttributes.passing", "error.invalid.playerAttributes.passing",
				"Passing Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "playerAttributes.dribbling", "error.invalid.playerAttributes.dribbling",
				"Dribbling Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "playerAttributes.defending", "error.invalid.playerAttributes.defending",
				"Defending Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "playerAttributes.physical", "error.invalid.playerAttributes.physical",
				"Physical Required");
		
		if(errors.hasErrors())
            return;
		
		Pattern p = Pattern.compile("[^a-zA-Z\\s]+");
		Matcher match = p.matcher(player.getName());
		if (match.find()) {
			errors.rejectValue("name", "error.invalid.name", "Enter alphabetic characters only");
		}
		
		if(player.getPlayerAttributes().getDefending()<10 || player.getPlayerAttributes().getDefending() > 100)
			errors.rejectValue("playerAttributes.defending", "invalid.playerAttributes.defending", "Enter a value between 10 and 100");
		
		if(player.getPlayerAttributes().getDribbling()<10 || player.getPlayerAttributes().getDribbling() > 100)
			errors.rejectValue("playerAttributes.dribbling", "invalid.playerAttributes.dribbling", "Enter a value between 10 and 100");
		
		if(player.getPlayerAttributes().getPace()<10 || player.getPlayerAttributes().getPace() > 100)
			errors.rejectValue("playerAttributes.pace", "invalid.playerAttributes.pace", "Enter a value between 10 and 100");
		
		if(player.getPlayerAttributes().getPassing()<10 || player.getPlayerAttributes().getPassing() > 100)
			errors.rejectValue("playerAttributes.passing", "invalid.playerAttributes.passing", "Enter a value between 10 and 100");
		
		if(player.getPlayerAttributes().getPhysical()<10 || player.getPlayerAttributes().getPhysical() > 100)
			errors.rejectValue("playerAttributes.physical", "invalid.playerAttributes.physical", "Enter a value between 10 and 100");
		
		if(player.getPlayerAttributes().getShooting()<10 || player.getPlayerAttributes().getShooting() > 100)
			errors.rejectValue("playerAttributes.shooting", "invalid.playerAttributes.shooting", "Enter a value between 10 and 100");
		
	}

}
