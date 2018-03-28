package com.mydomain.test;

import org.junit.Test;

import com.mydomain.util.AlphaValidationRule;
import com.mydomain.util.EmailValidationRule;
import com.mydomain.util.LengthValidationRule;
import com.mydomain.util.MandatoryValidationRule;
import com.mydomain.util.PhoneValidationRule;
import com.mydomain.util.ZipCodeValidationRule;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestValidator {

//	@Test
	public void testEMailValidator()
	{
		EmailValidationRule objEmail = new EmailValidationRule();
		// Positive Test Case
		Boolean isValid = objEmail.validate("validEmail@validDomain.com");
		assertEquals(true, isValid);
		
		// Negative Test Case
		isValid = objEmail.validate("InvalidEmail");
		assertEquals(false, isValid);
	}

//	@Test
	public void testLengthValidator()
	{
		LengthValidationRule objLength = new LengthValidationRule();
		// Positive Test Case
		Boolean isValid = objLength.validate("ValidLength");
		assertEquals(true, isValid);
		
		// Negative Test Case
		isValid = objLength.validate("Serdtfyguhijokplegyhjkdlghujiklwqe89iokl,qewghjkml,.hbejnkmlwq,eqweghjnkemlqw,eqweqwedfhdsjkfdshfdshfdksfkjdsfdshfjdsfsdfdsfdsfsdfdsffdssdfewrewjrhewrhejkwhrkjewhrjehwkrjhekwjrhejwrhkjwerhjewrhkjewhrjkewhrkjewrhkjewrhkewrewrewrewrwerwewqkjehwqkjewqjkehjwqehwqewqewqewqewqewq");
		assertEquals(false, isValid);
	}
	
//	@Test
	public void testStringTypeValidator()
	{
		AlphaValidationRule objString = new AlphaValidationRule();
		// Positive Test Case
		Boolean isValid = objString.validate("FristName");
		assertEquals(true, isValid);
		
		// Negative Test Case
		isValid = objString.validate("124563");
		assertEquals(false, isValid);

		isValid = objString.validate("Müller");
		assertEquals(false, isValid);
	}

//	@Test
	public void testMandatoryFieldValidator()
	{
		MandatoryValidationRule objMandatory = new MandatoryValidationRule();
		// Positive Test Case
		Boolean isValid = objMandatory.validate("LastName");
		assertEquals(true, isValid);
		
		// Negative Test Case
		isValid = objMandatory.validate("");
		assertEquals(false, isValid);
	}
	
//	@Test
	public void testPhoneValidator()
	{
		PhoneValidationRule objPhone = new PhoneValidationRule();
		// Positive Test Case
		Boolean isValid = objPhone.validate("416-575-3400");
		assertEquals(true, isValid);
		
		// Negative Test Case
		isValid = objPhone.validate("444888444");
		assertEquals(false, isValid);
	}
	
	@Test
	public void testZipCodeValidator()
	{
		ZipCodeValidationRule objZipCode = new ZipCodeValidationRule();
		// Positive Test Case
		Boolean isValid = objZipCode.validate("A1A 1A1");
		assertEquals(true, isValid);
		
		// Negative Test Case
		isValid = objZipCode.validate("2QQ 3WW");
		assertEquals(false, isValid);
	}
	
}