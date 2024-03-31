//package (default package);


import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MRSSiteRegistrationManualAutoMain {
WebDriver Driver;
@Test (priority = 2)
	public void callingRegistration() throws InterruptedException {
	
	// parameter for manual run or automatic run.
	// Set blnManual = false for automatic run
	// Set blnManual = true for manual run
	Boolean blnManual = false;
	HashMap <String,String> expectedHMap;

	// Login
	Boolean blnLoginSuccess = loginSite("Admin", "Admin123");

	// If Login is successful then Register Patient Manual or Automate
	System.out.println("Login Success = " + blnLoginSuccess);
	if (blnLoginSuccess) {
		if (blnManual == false) {
			// Register Patient Automatically
			expectedHMap =RegisterAutomate( blnLoginSuccess);
		} else {
			// Register Patient Manually
			expectedHMap= RegisterManual( blnLoginSuccess);
		}
		System.out.println("test1"+ expectedHMap.get("Identifier"));
	
		logout(blnLoginSuccess);
	}
	// Log out
	DriverQuit();
	}
@Test (priority =1)
public void callingRegistrationManual() throws InterruptedException {
	
// parameter for manual run or automatic run.
// Set blnManual = false for automatic run
// Set blnManual = true for manual run
Boolean blnManual = true;
HashMap <String,String> expectedHMap;

// Login
Boolean blnLoginSuccess = loginSite("Admin", "Admin123");

// If Login is successful then Register Patient Manual or Automate
System.out.println("Login Success = " + blnLoginSuccess);
if (blnLoginSuccess) {
	if (blnManual == false) {
		// Register Patient Automatically
		expectedHMap =RegisterAutomate( blnLoginSuccess);
	} else {
		// Register Patient Manually
		expectedHMap= RegisterManual( blnLoginSuccess);
	}
	System.out.println("test2" + expectedHMap.get("Identifier"));
	logout(blnLoginSuccess);
}
// Log out
//System.out.println("test2-1");
DriverQuit();
//System.out.println("test2-3");
}

	public HashMap<String, String> RegisterManual( Boolean blnLoginSuccess)
			throws InterruptedException {
		HashMap<String, String> expectedMap = new HashMap<String, String>();
		String strFname = "Fname3";
		String strMname = "Mname3";
		String strLname = "Lname3";
		String strGender = "Female";
		String strDate = "22";
		int intMonth = 4;
		String strYear = "2005";
		String strAge = "";

		enterName(strFname, strMname, strLname);
		expectedMap.put("Name", strFname + " " + strMname + " " + strLname);
		
		enterGender(strGender);
		expectedMap.put("Gender", strGender.substring(0, 1));
		
		enterBirthDate(strDate, intMonth, strYear);
		LocalDate dtbirthDate = LocalDate.of(Integer.parseInt(strYear), intMonth, Integer.parseInt(strDate));

		strAge = calculateAge(dtbirthDate);
		expectedMap.put("Age", strAge);
		
		SimpleDateFormat dtFormat = new SimpleDateFormat("dd MMM yyyy");
		expectedMap.put("Birthdate", dtFormat.format(java.sql.Date.valueOf(dtbirthDate)));
		
		enterAddress("Address1", "Address2", "Novi", "Michigan", "USA", "42342");
		enterPhone("345-366-3474");
		enterRelation("Doctor", "XYZ");

		Thread.sleep(2000);
		enterConfirm();
		String strPatientID = PatientID();
		expectedMap.put("Identifier", strPatientID);
		System.out.println("******************************************************************************************* ");
		System.out.println("New Patient ID Created : " + strPatientID);
		System.out.println("******************************************************************************************* ");
		System.out.println("Searching and validating newly created PatientID :" + strPatientID);
		System.out.println("");
		Boolean blnSearched = SearchPatient(strPatientID, expectedMap);
		// Boolean blnSearched= obj.SearchPatient("JUNK");
		if (blnSearched) {
			System.out.println("Patient Details Searched and Validated");
			expectedMap.put("PatientSearched", "True");
		} else {
			System.out.println("Patient not found");
			expectedMap.put("PatientSearched", "False");
		}
		return expectedMap;
	}

	public HashMap<String, String> RegisterAutomate( Boolean blnLoginSuccess)
			throws InterruptedException {
		Random rand = new Random();
		HashMap<String, String> expectedMap = new HashMap<String, String>();
		// Random data prep
		String strFname = createRandomWord(10);
		String strMname = createRandomWord(1);
		String strLname = createRandomWord(10);
		String strDate = String.valueOf((1 + rand.nextInt(28 - 1)));
		int intMonth = (1 + rand.nextInt(12 - 1));
		String strYear = String.valueOf(1905 + rand.nextInt(2024 - 1905));
		Boolean blnGender = rand.nextBoolean();
		String strGender = "";
		String strAge = "";
		String strAddress1 = createRandomWord(15);
		String strAddress2 = createRandomWord(10);
		String strCity = createRandomWord(10);
		String strState = createRandomWord(2);
		String strCountry = createRandomWord(10);
		String strZipcode = String.valueOf(String.valueOf(44444 + rand.nextInt(55555 - 44444)));
		String strPhone = (100 + rand.nextInt(999 - 100)) + "-" + (100 + rand.nextInt(999 - 100)) + "-"
				+ (1000 + rand.nextInt(9999 - 1000));
		String strRelation = "";

		// Register Patient
		enterName(strFname, strMname, strLname);
		expectedMap.put("Name", strFname + " " + strMname + " " + strLname);

		if (blnGender) {
			strGender = "Female";
		} else {
			strGender = "Male";
		}
		enterGender(strGender);
		expectedMap.put("Gender", strGender.substring(0, 1));

		enterBirthDate(strDate, intMonth, strYear);
		LocalDate dtbirthDate = LocalDate.of(Integer.parseInt(strYear), intMonth, Integer.parseInt(strDate));

		strAge = calculateAge(dtbirthDate);
		expectedMap.put("Age", strAge);

		SimpleDateFormat dtFormat = new SimpleDateFormat("dd MMM yyyy");
		expectedMap.put("Birthdate", dtFormat.format(java.sql.Date.valueOf(dtbirthDate)));

		enterAddress(strAddress1, strAddress2, strCity, strState, strCountry, strZipcode);
		enterPhone(strPhone);

		switch (rand.nextInt(9)) {
		case 0:
			strRelation = "Doctor";
			break;
		case 1:
			strRelation = "Sibling";
			break;
		case 2:
			strRelation = "Parent";
			break;
		case 3:
			strRelation = "Aunt/Uncle";
			break;
		case 4:
			strRelation = "Supervisor";
			break;
		case 5:
			strRelation = "Patient";
			break;
		case 6:
			strRelation = "Child";
			break;
		case 7:
			strRelation = "Niece/Nephew";
			break;
		case 8:
			strRelation = "Supervisee";
			break;
		}
		enterRelation(strRelation, createRandomWord(15));
		enterConfirm();
		String strPatientID = PatientID();
		expectedMap.put("Identifier", strPatientID);

		System.out.println("******************************************************************************************* ");
		System.out.println("New Patient ID Created : " + strPatientID);
		System.out.println("******************************************************************************************* ");
		System.out.println("Searching and validating newly created PatientID :" + strPatientID);
		System.out.println("");
		Boolean blnSearched = SearchPatient(strPatientID, expectedMap);
		if (blnSearched) {
			System.out.println("Patient Details Searched and Validated");
			expectedMap.put("PatientSearched", "True");
		} else {
			System.out.println("Patient not found");
			expectedMap.put("PatientSearched", "False");
		}
		return expectedMap;
	}

	public Boolean loginSite(String strUserID, String strPass) throws InterruptedException {
		// Instantiate driver
		WebDriverManager.chromedriver().setup();
		Driver = new ChromeDriver();
		Driver.get("https://demo.openmrs.org/openmrs/index.htm");
		Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Login
		Driver.findElement(By.xpath("//input[@id='username']")).sendKeys(strUserID);
		Driver.findElement(By.xpath("//input[@id='password']")).sendKeys(strPass);
		Driver.findElement(By.xpath("//li[@id='Inpatient Ward']")).click();
		Driver.findElement(By.xpath("//input[@id='loginButton']")).click();

		if (Driver.getTitle().equals("Home")) {
			System.out.println("Login Successful to Home Page");
			return true;
		} else {
			System.out.println("Login Unsuccessful !");
			return false;
		}
	}

	public void logout(Boolean blnLoginSuccess) {
		if (blnLoginSuccess) {
			System.out.println("******************************************************************************************* ");
			Driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
			System.out.println("Logout Successful!");
		}
	}

	public void DriverQuit() {
		Driver.quit();
	}

	public void enterName(String strGivenName, String strMiddleName, String strFamilyName) {
		Driver.findElement(By.xpath("//a[contains(@id,'registerPatient')]")).click();
		if (Driver.getTitle().equals("OpenMRS Electronic Medical Record")) {
			Driver.findElement(By.xpath("//input[contains(@name,'givenName')]")).sendKeys(strGivenName);
			Driver.findElement(By.xpath("//input[contains(@name,'middleName')]")).sendKeys(strMiddleName);
			Driver.findElement(By.xpath("//input[contains(@name,'familyName')]")).sendKeys(strFamilyName);
			Driver.findElement(By.xpath("//button[contains(@id,'next-button')]")).click();
		}
	}

	public void enterGender(String strGender) {

		WebElement weGender = Driver.findElement(By.xpath("//select[@name='gender']"));
		Select seGender = new Select(weGender);
		if (strGender.equals("Male")) {
			seGender.selectByIndex(0); // Male
		} else {
			seGender.selectByIndex(1); // Female
		}
		Driver.findElement(By.xpath("//button[contains(@id,'next-button')]")).click();
	}

	public void enterBirthDate(String strDay, int intMonth, String strYear) {
		Driver.findElement(By.xpath("//input[contains(@name,'birthdateDay')]")).sendKeys(strDay);
		// System.out.println("Day :" + strDay);
		// System.out.println("Month :" + intMonth);
		// System.out.println("Year :" + strYear);
		WebElement weMonth = Driver.findElement(By.xpath("//select[@name='birthdateMonth']"));
		Select seMonth = new Select(weMonth);

		if (intMonth >= 1 && intMonth <= 12) {
			seMonth.selectByIndex(intMonth);
		} else {
			System.out.println("No Month data");
		}
		Driver.findElement(By.xpath("//input[contains(@name,'birthdateYear')]")).sendKeys(strYear);
		Driver.findElement(By.xpath("//button[contains(@id,'next-button')]")).click();
	}

	public void enterAddress(String strAddress1, String strAddress2, String strCity, String strState, String strCountry,
			String strPostal) {

		Driver.findElement(By.xpath("//input[contains(@id,'address1')]")).sendKeys(strAddress1);
		Driver.findElement(By.xpath("//input[contains(@id,'address2')]")).sendKeys(strAddress2);
		Driver.findElement(By.xpath("//input[contains(@id,'cityVillage')]")).sendKeys(strCity);
		Driver.findElement(By.xpath("//input[contains(@id,'stateProvince')]")).sendKeys(strState);
		Driver.findElement(By.xpath("//input[contains(@id,'country')]")).sendKeys(strCountry);
		Driver.findElement(By.xpath("//input[contains(@id,'postalCode')]")).sendKeys(strPostal);
		Driver.findElement(By.xpath("//button[contains(@id,'next-button')]")).click();
	}

	public void enterPhone(String strPhone) {
		Driver.findElement(By.xpath("//input[contains(@name,'phoneNumber')]")).sendKeys(strPhone);
		Driver.findElement(By.xpath("//button[contains(@id,'next-button')]")).click();
	}

	public void enterRelation(String strRelation, String strPersonName) {
		WebElement weRelation = Driver.findElement(By.xpath("//select[contains(@name,'relationship_type')]"));
		Select seRelation = new Select(weRelation);
		// System.out.println("Relation " + strRelation);
		switch (strRelation) {
		case "Doctor":
			seRelation.selectByIndex(1);
			break;
		case "Sibling":
			seRelation.selectByIndex(2);
			break;
		case "Parent":
			seRelation.selectByIndex(3);
			break;
		case "Aunt/Uncle":
			seRelation.selectByIndex(4);
			break;
		case "Supervisor":
			seRelation.selectByIndex(5);
			break;
		case "Patient":
			seRelation.selectByIndex(6);
			break;
		case "Child":
			seRelation.selectByIndex(7);
			break;
		case "Niece/Nephew":
			seRelation.selectByIndex(8);
			break;
		case "Supervisee":
			seRelation.selectByIndex(9);
		default:
			seRelation.selectByIndex(0);
			break;
		}

		Driver.findElement(By.xpath("//input[contains(@placeholder,'Person Name')]")).sendKeys(strPersonName);
		Driver.findElement(By.xpath("//button[contains(@id,'next-button')]")).click();
	}

	public void enterConfirm() {
		Driver.findElement(By.xpath("//input[contains(@id,'submit')]")).click();

	}

	public void enterCancel() {
		Driver.findElement(By.xpath("//input[contains(@id,'cancelSubmission')]")).click();

	}

	public String PatientID() {
		String PatientID = "";
		PatientID = Driver.findElement(By.xpath("//em[text()='Patient ID']/parent::div/child::span")).getText();
		return PatientID;
	}

	public static String createRandomWord(int len) {
		String name = "";
		for (int i = 0; i < len; i++) {
			int v = 1 + (int) (Math.random() * 26);
			char c = (char) (v + (i == 0 ? 'A' : 'a') - 1);
			name += c;
		}
		return name;
	}

	public String calculateAge(LocalDate dtbirthDate) {
		String Age = "";
		LocalDate currDate = LocalDate.now();
		Age = String.valueOf(Period.between(dtbirthDate, currDate).getYears());
		return Age;
	}

	public Boolean SearchPatient(String strPatientID, HashMap<String, String> expectedMap) throws InterruptedException {

		Driver.findElement(By.xpath(
				"//img[contains(@src,'/openmrs/ms/uiframework/resource/uicommons/images/logo/openmrs-with-title-small.png')]"))
				.click();

		Driver.findElement(
				By.xpath("//a[contains(@class,'btn btn-default btn-lg button app big align-self-center')][1]")).click();

		Driver.findElement(By.xpath("//input[contains(@id,'patient-search')]")).sendKeys(strPatientID);
		Thread.sleep(1000);
		Driver.findElement(By.xpath("//input[contains(@id,'patient-search')]")).sendKeys(Keys.TAB);

		List<WebElement> PatientFound = Driver.findElements(By.xpath("//td[contains(text(),'" + strPatientID + "')]"));
		// System.out.println("PatientFound.size() :" + PatientFound.size());
		if (PatientFound.size() > 0) {

			String strIdentifier = strPatientID;
			String strName = Driver
					.findElement(By.xpath("//td[contains(text(),'" + strPatientID + "')]/parent::tr/child::td[2]"))
					.getText();
			String strGender = Driver
					.findElement(By.xpath("//td[contains(text(),'" + strPatientID + "')]/parent::tr/child::td[3]"))
					.getText();
			String strAge = Driver
					.findElement(By.xpath("//td[contains(text(),'" + strPatientID + "')]/parent::tr/child::td[4]"))
					.getText();
			String strBirthdate = Driver
					.findElement(By.xpath("//td[contains(text(),'" + strPatientID + "')]/parent::tr/child::td[5]"))
					.getText();
			System.out.println(printSpace("", 15) + "EXPECTED" + printSpace("EXPECTED", 30) + "ACTUAL"
					+ printSpace("ACTUAL", 30) + "PASS/FAIL" + printSpace("PASS/FAIL", 15));
			System.out.println("------------------------------------------------------------------------------------------- ");
			
			System.out.println("Identifier:"+ printSpace("Identifier:", 15) 
					+ expectedMap.get("Identifier") + printSpace(expectedMap.get("Identifier"), 30) 
					+ strIdentifier +printSpace(strIdentifier, 30)
					+ (strIdentifier.equals(expectedMap.get("Identifier")) ? "MATCHED" : "NOT MATCHED"));
			
			System.out.println("Name:"+ printSpace("Name:", 15) 
					+ expectedMap.get("Name") + printSpace(expectedMap.get("Name"), 30) 
					+ strName +printSpace(strName, 30)
					+ (strName.equals(expectedMap.get("Name")) ? "MATCHED" : "NOT MATCHED"));
			
			System.out.println("Gender:"+ printSpace("Gender:", 15) 
					+ expectedMap.get("Gender") + printSpace(expectedMap.get("Gender"), 30) 
					+ strGender +printSpace(strGender, 30)
					+ (strGender.equals(expectedMap.get("Gender")) ? "MATCHED" : "NOT MATCHED"));
			
			System.out.println("Age:"+ printSpace("Age:", 15) 
					+ expectedMap.get("Age") + printSpace(expectedMap.get("Age"), 30) 
					+ strAge +printSpace(strAge, 30)
					+ (strAge.equals(expectedMap.get("Age")) ? "MATCHED" : "NOT MATCHED"));
			
			System.out.println("Birthdate:"+ printSpace("Birthdate:", 15) 
				+ expectedMap.get("Birthdate") + printSpace(expectedMap.get("Birthdate"), 30) 
				+ strBirthdate.trim() +printSpace(strBirthdate.trim(), 30)
				+ (strBirthdate.trim().equals(expectedMap.get("Birthdate")) ? "MATCHED" : "NOT MATCHED"));
			
			System.out.println("");
			Thread.sleep(1000);
			Driver.findElement(By.xpath(
					"//img[contains(@src,'/openmrs/ms/uiframework/resource/uicommons/images/logo/openmrs-with-title-small.png')]"))
					.click();

			return true;
		} else {
			return false;

		}
	}

	public StringBuffer printSpace(String name, int numOfSpacesBetweenLetters) {
		StringBuffer sbSpace = new StringBuffer();
		for (int i = 0; i <= numOfSpacesBetweenLetters- name.length(); i++) {
			sbSpace.append(" ");
		}
		return sbSpace;
	}

}
