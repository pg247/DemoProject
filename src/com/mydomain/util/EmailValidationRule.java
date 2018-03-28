package com.mydomain.util;

import java.util.HashSet;
import java.util.Set;

public class EmailValidationRule implements ValidationRule {
	private String EMAIL_PATTERN = "[-#A-Za-z0-9_]+([-+.'][-#A-Za-z0-9_]+)*@[A-Za-z0-9_]+([-.][A-Za-z0-9_]+)*\\.[A-Za-z0-9_]+([-.][A-Za-z0-9_]+)*";

	private static Set<String> emailList = new HashSet<String>();

	@Override
	public boolean validate(String value) {
		boolean isValid = true;
		if (value != null && value.length() > 0) {
			isValid = value.matches(EMAIL_PATTERN);
			if (isValid) {
				isValid = emailList.add(value);
			}
		}
		if(!isValid) {
			HandyLogger.print("Invalid  emailId.");
		}
		return isValid;
	}
}
