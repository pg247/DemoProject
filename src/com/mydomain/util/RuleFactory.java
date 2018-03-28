package com.mydomain.util;

import java.util.ArrayList;
import java.util.List;

public class RuleFactory {
	public static ValidationRule getRule(Rule rule) {
		switch (rule) {
		case MANDATORY:
			return new MandatoryValidationRule();
		case LENGTH:
			return new LengthValidationRule();
		case EMAIL:
			return new EmailValidationRule();
		case ZIPCODE:
			return new ZipCodeValidationRule();
		case ALPHA:
			return new AlphaValidationRule();
		case PHONE:
			return new PhoneValidationRule();
		default:
			return null;
		}
	}

	public static List<ValidationRule> getRuleSet(Rule... rules) {
		List<ValidationRule> ruleSet = new ArrayList<ValidationRule>();
		for (Rule rule : rules) {
			ruleSet.add(getRule(rule));
		}
		return ruleSet;
	}

	public static enum Rule {
		MANDATORY, LENGTH, EMAIL, ZIPCODE, ALPHA, PHONE
	}
}
