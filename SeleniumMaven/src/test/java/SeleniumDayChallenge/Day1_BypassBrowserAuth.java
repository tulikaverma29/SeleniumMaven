package SeleniumDayChallenge;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

/*𝐃𝐚𝐲 1 -𝐂𝐨𝐝𝐢𝐧𝐠 𝐂𝐡𝐚𝐥𝐥𝐞𝐧𝐠𝐞:
𝐓𝐞𝐬𝐭 𝐒𝐜𝐞𝐧𝐚𝐫𝐢𝐨: Develop an automation script that bypasses the Basic Browser Authentication Popup.
Link: https://lnkd.in/dB3ZAGi7

𝐔𝐬𝐞𝐫𝐧𝐚𝐦𝐞: admin
𝐏𝐚𝐬𝐬𝐰𝐨𝐫𝐝: admin*/

public class Day1_BypassBrowserAuth {
	public WebDriver driver;
	
	@Parameters({"browserName","url","username","password","sleeptime"})
	@BeforeClass
	public void Setup(@Optional("Chrome") String browserName,String url,String username,String password,Long sleeptime) throws  InterruptedException  {

		System.out.println("@BeforeClass");

		System.out.println(browserName);
		System.out.println(url);
		
		switch (browserName) {
		case "Chrome":
			System.out.println("setting Chrome");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "Edge":
			System.out.println("setting Edge");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(4));
		driver.manage().window().maximize();
		System.out.println("Sleep time "+ sleeptime);
		//Thread.sleep(Long.valueOf(sleeptime));
		Thread.sleep(sleeptime);
		System.out.println("http://"+username+":"+password+"@"+url);
		
		// driver.get("https://the-internet.herokuapp.com/basic_auth");
		
		// http://username:password@test.com
//		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
//		driver.get("http://"+username+":"+password+"@the-internet.herokuapp.com/basic_auth");
		driver.get("http://"+username+":"+password+"@"+url);

		Thread.sleep(sleeptime);
		
	}

	@AfterClass
	public void teardown() {
		System.out.println("@@AfterClass");
		driver.quit();
	}

	@Test
	public void process() throws InterruptedException {
		System.out.println("@@Test");
		String strActualText= driver.findElement(By.cssSelector("p")).getText();
		String strExpectedText= "Congratulations! You must have the proper credentials.";
		System.out.println();
		Assert.assertEquals(strActualText, strExpectedText);
	}


}
