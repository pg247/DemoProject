package com.mydomain.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.skife.csv.CSVReader;
import org.skife.csv.SimpleReader;

import com.mydomain.util.HandyLogger;
import com.mydomain.util.RuleFactory;
import com.mydomain.util.RuleFactory.Rule;
import com.mydomain.util.ValidationRule;

public class CSVInput {

	private String fileName;

	public static Map<String, List<ValidationRule>> fieldValidationMap = new LinkedHashMap<String, List<ValidationRule>>();
	static {
		fieldValidationMap.put("FirstName", RuleFactory.getRuleSet(Rule.MANDATORY, Rule.LENGTH, Rule.ALPHA));
		fieldValidationMap.put("LastName", RuleFactory.getRuleSet(Rule.MANDATORY, Rule.LENGTH, Rule.ALPHA));
		fieldValidationMap.put("CompanyName", RuleFactory.getRuleSet(Rule.LENGTH));
		fieldValidationMap.put("Address", RuleFactory.getRuleSet(Rule.LENGTH));
		fieldValidationMap.put("City", RuleFactory.getRuleSet(Rule.LENGTH));
		fieldValidationMap.put("Province", RuleFactory.getRuleSet(Rule.LENGTH));
		fieldValidationMap.put("PostalCode", RuleFactory.getRuleSet(Rule.LENGTH, Rule.ZIPCODE));
		fieldValidationMap.put("Phone1", RuleFactory.getRuleSet(Rule.LENGTH, Rule.PHONE));
		fieldValidationMap.put("Phone2", RuleFactory.getRuleSet(Rule.LENGTH, Rule.PHONE));
		fieldValidationMap.put("Email", RuleFactory.getRuleSet(Rule.LENGTH, Rule.EMAIL));
		fieldValidationMap.put("WebSite", RuleFactory.getRuleSet(Rule.LENGTH));
	}

	public static Map<Integer, String> fieldIndexMap = new LinkedHashMap<Integer, String>();
	static {

		fieldIndexMap.put(0, "FirstName");
		fieldIndexMap.put(1, "LastName");
		fieldIndexMap.put(2, "CompanyName");
		fieldIndexMap.put(3, "Address");
		fieldIndexMap.put(4, "City");
		fieldIndexMap.put(5, "Province");
		fieldIndexMap.put(6, "PostalCode");

		fieldIndexMap.put(7, "Phone1");
		fieldIndexMap.put(8, "Phone2");
		fieldIndexMap.put(9, "Email");
		fieldIndexMap.put(10, "WebSite");

	}

	public CSVInput(String _fieldName) {
		if (!new File(_fieldName).exists()) {
			throw new IllegalArgumentException("Invalid file Name");
		}
		this.fileName = _fieldName;
	}

	public List<String[]> readFile() throws UnsupportedEncodingException, FileNotFoundException, IOException {

		CSVReader reader = new SimpleReader();
		reader.setEnsureLastBlankCell(true);
		List<String[]> lines = reader.parse(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));

		List<String[]> data = new ArrayList<String[]>();

		for (int rowCount = 1; rowCount < lines.size(); rowCount++) {
			String[] row = lines.get(rowCount);
			if (isValidRow(row)) {
				data.add(row);
			}
		}

		return data;
	}

	private boolean isValidRow(String[] dataArr) {
		boolean isValid = true;
		for (Integer fldCount = 0; fldCount < dataArr.length; fldCount++) {
			String value = dataArr[fldCount];
			for (ValidationRule rule : fieldValidationMap.get(fieldIndexMap.get(fldCount))) {
				isValid = rule.validate(value);
				HandyLogger.print(value + " " + isValid);
				if (!isValid) {
					break;
				}
			}
			if (!isValid) {
				break;
			}
		}
		return isValid;
	}
}
