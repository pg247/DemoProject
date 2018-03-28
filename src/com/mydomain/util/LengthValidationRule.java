package com.mydomain.util;

public class LengthValidationRule implements ValidationRule {
	@Override
	public boolean validate(String value) {
		boolean isValid = value == null ||  value.length() <= 256;
		if(!isValid) {
			HandyLogger.print("Invalid input. Input length between 1 to 256");
		}
		return isValid;
	}
}
