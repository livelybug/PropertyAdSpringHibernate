package com.spring.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DigitValidator implements ConstraintValidator<DigitsAnn, String> {

	@Override
	public void initialize(DigitsAnn arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext arg1) {
		if(value == null || value.isEmpty())
			return false;
		else if(value.matches("\\d{8}"))
			return true;
		else
			return false;
	}
	

}
