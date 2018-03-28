package com.mydomain.util;

public class PhoneValidationRule implements ValidationRule {
	private String PHONE_PATTERN = "[0-9]{3}-[0-9]{3}-[0-9]{4}";
	@Override
	public boolean validate(String value) {
		boolean isValid = true;
		if (value != null && value.length() > 0) {
			isValid = value.matches(PHONE_PATTERN);
		}
		return isValid;
	}
}
