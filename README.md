# DemoProject
Minor Technical Assignment


you will need to provide a solution to the stories below:
- The code has to be ready to run in an IDE.
- Please include a set of unit tests.

User Story 1: Validate User Information
As a product specialist, I want to validate user data so that invalid entries can be fixed.
Done means
1. User data is provided via a terminal

2. The system will request a series of data points for each possible user
	1. first name
	2. last name
	3. company name
	4. address
	5. city
	6. province
	7. postal code
	8. email address
	9. web site

3. Each field type is a string.

4. Each field should be able to accept a maximum number of 256 characters.

5. The first name, last name and email address are mandatory.
	1. All other fields may be blank.

6. The first and last name fields must
	1. be at least one character long.
	2. consist of letters only, no spaces or punctuation.
	3. not contain non-ASCII values.
		1. Example of valid names: Sahar, Lee, Myron, Rodriguez
		2. Example of invalid names: Müller, van Gogh, Harper7, Sarah-Jane

7. Email must be in standard email format.
8. Email must be unique.
	1. The system prompts user again if a duplicate is found.
9. Postal code is in Canadian format (A1A 1A1).
10. The system will prompt for reentry of the field if a validity test fails.
11. Data entry terminates on any field if the user enters -1.

Out of Scope
- Displaying the data
- Storing the data to file

-------------------------------------------------------------------------------------
User Story 2: Validate a File of User Information

As a product specialist, I want to parse a file of potential user data so that data entry can be simplified.

Done means
1. User data is provided in a .csv file.
2. The validation rules from User Story 1 are applied to each row of data.
	1. Data entry does not terminate if any field is -1.
	2. Data entry terminates at the end of file.
3. A count of valid rows should be provided.
