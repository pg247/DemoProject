package com.mydomain.util;

public class AlphaValidationRule implements ValidationRule {

	@Override
	public boolean validate(String value) {
		boolean isValid = true;
		if (value != null && value.length() > 0) {
			isValid = value.matches("[a-zA-Z]+");
		}
		return isValid;
	}
}