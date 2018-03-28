package com.mydomain.program;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.mydomain.data.CSVInput;
import com.mydomain.util.RuleFactory;
import com.mydomain.util.RuleFactory.Rule;
import com.mydomain.util.ValidationRule;

public class Assignment2 {
	public static Map<String, List<ValidationRule>> fieldValidationMap = new LinkedHashMap<String, List<ValidationRule>>();
	static {
		fieldValidationMap.put("FirstName", RuleFactory.getRuleSet(Rule.MANDATORY, Rule.LENGTH, Rule.ALPHA));
		fieldValidationMap.put("LastName", RuleFactory.getRuleSet(Rule.MANDATORY, Rule.LENGTH, Rule.ALPHA));
		fieldValidationMap.put("CompanyName", RuleFactory.getRuleSet(Rule.LENGTH));
		fieldValidationMap.put("Address", RuleFactory.getRuleSet(Rule.LENGTH));
		fieldValidationMap.put("City", RuleFactory.getRuleSet(Rule.LENGTH));
		fieldValidationMap.put("Province", RuleFactory.getRuleSet(Rule.LENGTH));
		fieldValidationMap.put("PostalCode", RuleFactory.getRuleSet(Rule.LENGTH, Rule.ZIPCODE));
		fieldValidationMap.put("Email", RuleFactory.getRuleSet(Rule.LENGTH, Rule.EMAIL));
		fieldValidationMap.put("WebSite", RuleFactory.getRuleSet(Rule.LENGTH));
	}

	public static Map<Integer, String> fieldIndexMap = new LinkedHashMap<Integer, String>();

	public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException, IOException {
		CSVInput csvInput = new CSVInput(
				"Global Relay - SDET Technical Assignment - users - Copy.csv");
		List<String[]> dataList = csvInput.readFile();
		System.out.println(dataList.size());

	}

}
