package automationtesting;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookLogin {
@Test
	public void facebookLoginMethod() throws InterruptedException, Exception
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver1 = new ChromeDriver();
		driver1.get("https://www.facebook.com/"); 
		driver1.manage().window().fullscreen();
		WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("pass")));
		
		driver1.findElement(By.name("email")).sendKeys("323-323-2343",Keys.ENTER);
		Thread.sleep(3000);
		driver1.findElement(By.name("pass")).sendKeys("fgdgd4r2342532532");
		
		//Taking screenshot
		File srcFile = ((TakesScreenshot)driver1).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("C:\\Users\\tulik\\OneDrive\\Documents\\screenshot.png")) ;
		driver1.quit();
		
		
	}
}
