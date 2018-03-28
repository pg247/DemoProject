package com.mydomain.data;

import java.util.List;
import java.util.Scanner;

import com.mydomain.util.HandyLogger;
import com.mydomain.util.ValidationRule;

public class TerminalInput {
	private static Scanner _scan = new Scanner(System.in);
	private static TerminalInput _instance = new TerminalInput();
	private static String messageFormat = "Please enter %s :";

	private TerminalInput() {
	}

	public static TerminalInput getInstance() {
		return _instance;
	}

	public String readInput(String fieldName, List<ValidationRule> ruleSet) {
		boolean isValid = false;
		String input = "";
		while (!isValid) {
			HandyLogger.print(String.format(messageFormat, fieldName));
			input = _scan.nextLine();
			if ("-1".equals(input)) {
				System.exit(0);
			}
			for (ValidationRule rule : ruleSet) {
				isValid = rule.validate(input);
				if (!isValid) {
					break;
				}
			}
			if (isValid) {
				break;
			}
		}
		return input;
	}
}
