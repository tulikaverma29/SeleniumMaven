package automationtesting;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearch {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://google.com/");
	driver.manage().window().maximize();
	
	driver.findElement(By.id("APjFqb")).sendKeys("Hello Tulika",Keys.ENTER);
	Thread.sleep(3000);
	driver.close();
	
	}

}
