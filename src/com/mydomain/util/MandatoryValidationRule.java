package com.mydomain.util;

public class MandatoryValidationRule implements ValidationRule {
	@Override
	public boolean validate(String value) {
		boolean isValid = value != null && value.length() > 0;
		if(!isValid) {
			HandyLogger.print("Invalid input. Mandatory field");
		}
		return isValid;
	}
}
