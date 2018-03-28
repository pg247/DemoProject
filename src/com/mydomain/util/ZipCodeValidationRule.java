package com.mydomain.util;

public class ZipCodeValidationRule implements ValidationRule {
	private String ZIPCODE_PATTERN = "[a-zA-Z][0-9][a-zA-Z]\\s[0-9][a-zA-Z][0-9]";
	@Override
	public boolean validate(String value) {
		boolean isValid = true;
		if (value != null && value.length() > 0) {
			isValid = value.matches(ZIPCODE_PATTERN);
		}
		return isValid;
	}
}
