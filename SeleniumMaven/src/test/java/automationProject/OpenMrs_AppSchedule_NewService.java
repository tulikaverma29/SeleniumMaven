package automationProject;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenMrs_AppSchedule_NewService {
	WebDriver Driver;

	@Test
	public void Login() throws InterruptedException {
		// Login
		Boolean blnLoginSuccess = loginSite("Admin", "Admin123");

		if (blnLoginSuccess) {

			// Created new Service Type
			HashMap<String, String> expHashmap = appointScheduling();

			// Output Created Service
			System.out.println("Name        - " + expHashmap.get("Name"));
			System.out.println("Duration    - " + expHashmap.get("Duration"));
			System.out.println("Description - " + expHashmap.get("Description"));
			System.out.println("***************************************************************************");

			// Searching new Service Type and Format Output
			getServiceDetails(expHashmap);

			// Log out
			logout(blnLoginSuccess);
		}
		DriverQuit();
	}


	private void getServiceDetails(HashMap<String, String> expectedMap) throws InterruptedException {
		List<WebElement> wePagination;
		List<WebElement> weService;
		Boolean blnFnd = false;

		// Pagination WebElements
		wePagination = Driver.findElements(By.xpath("//div[@id='appointmentTypesTable_paginate']/child::span/a"));

		if (wePagination.size() > 0) {
			// Pagination was found
			System.out.println("pagination available " + wePagination.size());

			for (int i = 1; i <= wePagination.size(); i++) {
				JavascriptExecutor js = (JavascriptExecutor) Driver;
				js.executeScript("arguments[0].scrollIntoView();",
						Driver.findElement(By.xpath("//div[@id='appointmentTypesTable_paginate']/child::span")));
				js.executeScript("arguments[0].click();", Driver
						.findElement(By.xpath("//div[@id='appointmentTypesTable_paginate']/child::span/a[" + i + "]")));

				// Search the Service in each page
				weService = Driver.findElements(By.xpath("//td[normalize-space()='" + expectedMap.get("Name") + "']"));
				if (weService.size() > 0) {
					// If Service is found Format Output in tabular form
					System.out.println("Service was found in Page " + i);

					// Output Formatting
					System.out.println(printSpace("", 15) + "EXPECTED" + printSpace("EXPECTED", 30) + "ACTUAL"
							+ printSpace("ACTUAL", 30) + "PASS/FAIL" + printSpace("PASS/FAIL", 15));
					System.out.println(
							"------------------------------------------------------------------------------------------- ");

					String strName = Driver
							.findElement(By.xpath(
									"//td[contains(text(),'" + expectedMap.get("Name") + "')]/parent::tr/child::td[1]"))
							.getText();
					String strDuration = Driver
							.findElement(By.xpath(
									"//td[contains(text(),'" + expectedMap.get("Name") + "')]/parent::tr/child::td[2]"))
							.getText();
					String strDescription = Driver
							.findElement(By.xpath(
									"//td[contains(text(),'" + expectedMap.get("Name") + "')]/parent::tr/child::td[3]"))
							.getText();

					System.out.println("Name:" + printSpace("Name:", 15) + expectedMap.get("Name")
							+ printSpace(expectedMap.get("Name"), 30) + strName + printSpace(strName, 30)
							+ (strName.equals(expectedMap.get("Name")) ? "MATCHED" : "NOT MATCHED"));

					System.out.println("Duration:" + printSpace("Duration:", 15) + expectedMap.get("Duration")
							+ printSpace(expectedMap.get("Duration"), 30) + strDuration + printSpace(strDuration, 30)
							+ (strDuration.equals(expectedMap.get("Duration")) ? "MATCHED" : "NOT MATCHED"));

					System.out.println("Description:" + printSpace("Description:", 15) + expectedMap.get("Description")
							+ printSpace(expectedMap.get("Description"), 30) + strDescription
							+ printSpace(strDescription, 30)
							+ (strDescription.equals(expectedMap.get("Description")) ? "MATCHED" : "NOT MATCHED"));

					blnFnd = true;
					break;
				}
				
			}

		}
		if (blnFnd ==false)
		{
			System.out.println("Service was not found");
		}


	}

	private HashMap<String, String> appointScheduling() {
		Random rand = new Random();
		HashMap<String, String> expectedMap = new HashMap<String, String>();

		// Click Appointment Scheduling Button
		Driver.findElement(By.xpath("//a[contains(@id,'appointmentscheduling')]")).click();
		// Click Manage Service Type Button
		Driver.findElement(By.xpath("//a[contains(@id,'manageAppointmentTypes')]")).click();
		// Click New Service Type Button
		Driver.findElement(By.xpath("//button[@class='confirm appointment-type-label right']")).click();

		// Enter Service Details

		// Enter Service Name
		Driver.findElement(By.xpath("//input[@id='name-field']")).clear();
		Driver.findElement(By.xpath("//input[@id='name-field']")).sendKeys(createRandomWord(10));
		expectedMap.put("Name", Driver.findElement(By.xpath("//input[@id='name-field']")).getAttribute("value"));

		// Enter Duration
		Driver.findElement(By.xpath("//input[@id='duration-field']"))
				.sendKeys(String.valueOf(String.valueOf(10 + rand.nextInt(90 - 10))));
		expectedMap.put("Duration",
				Driver.findElement(By.xpath("//input[@id='duration-field']")).getAttribute("value"));

		// Enter Description
		Driver.findElement(By.xpath("//textarea[@id='description-field']")).sendKeys(createRandomWord(30));
		expectedMap.put("Description",
				Driver.findElement(By.xpath("//textarea[@id='description-field']")).getAttribute("value"));

		// Click Save Button
		Driver.findElement(By.xpath("//input[@class='confirm right']")).click();

		// Return Hashmap object
		return expectedMap;

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

	private Boolean loginSite(String strUserID, String strPass) throws InterruptedException {
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

	private void logout(Boolean blnLoginSuccess) {
		if (blnLoginSuccess) {
			System.out.println(
					"******************************************************************************************* ");
			Driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
			System.out.println("Logout Successful!");
		}
	}

	private void DriverQuit() {
		Driver.quit();
	}

	public StringBuffer printSpace(String name, int numOfSpacesBetweenLetters) {
		StringBuffer sbSpace = new StringBuffer();
		for (int i = 0; i <= numOfSpacesBetweenLetters - name.length(); i++) {
			sbSpace.append(" ");
		}
		return sbSpace;
	}

}
