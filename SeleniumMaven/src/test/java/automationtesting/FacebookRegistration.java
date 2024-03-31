package automationtesting;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import SeleniumDayChallenge.Utils;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookRegistration {
	@Test
	// accessmodifier returntype methodname
	public void facebookReg() throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();

		// Comment - Classname obj = new ClassName();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		// Comment - Tag[@attribute='value']
		// a[text()='Create new account']
		Thread.sleep(3000);
		Utils.captureScreenshot(driver, "Login.jpg");
		
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		// Comment - driver.findElement(By.name("locator")).sendKeys("data") ;
		Thread.sleep(3000);
		driver.findElement(By.name("firstname")).sendKeys("TestFNAME");
		driver.findElement(By.name("lastname")).sendKeys("TestLNAME");
		driver.findElement(By.name("reg_email__")).sendKeys("323-323-2343");
		driver.findElement(By.name("reg_passwd__")).sendKeys("fgdgd4r2342532532");

		// WebElement
		// Selecting month with selectByIndex
		WebElement weMonthdropdown = driver.findElement(By.xpath("//select[@id='month']"));
		Select seMonthdropdown = new Select(weMonthdropdown);
		seMonthdropdown.selectByIndex(7); // Aug month
		Thread.sleep(1000);
		

		// Selecting Day with selectByValue
		WebElement weDaydropdown = driver.findElement(By.xpath("//select[@id='day']"));
		Select selDaydropdown = new Select(weDaydropdown);
		System.out.println("Size of the Select "+ selDaydropdown.getOptions().size());
		selDaydropdown.selectByValue("25");// 25th
		Thread.sleep(1000);

		// Selecting year with SelectbyVisibleText
		WebElement weYeardropdown = driver.findElement(By.xpath("//select[@id='year']"));
		Select selYeardropdown = new Select(weYeardropdown);

		selYeardropdown.selectByVisibleText("1995"); // 1995
		Thread.sleep(1000);

		driver.findElement(By.xpath("//label[text()='Custom']")).click();
		// driver.findElement(By.xpath(null))

		// Selecting Pronoun drop down with SelectbyIndex
		WebElement wePronoundrop = driver.findElement(By.xpath("//select[@name='preferred_pronoun']"));
		Select sePronoundrop = new Select(wePronoundrop);
		sePronoundrop.selectByIndex(3);  //Index is starting from 1 in place of 0
		
		driver.findElement(By.name("custom_gender")).sendKeys("testGenderdata");
		Utils.captureScreenshot(driver, "Register.jpg");
		Thread.sleep(3000);
		driver.close();
	}

}
