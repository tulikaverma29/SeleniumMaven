package automationtesting;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebAlertPractice {
@Test
public void AlertMethodExample() throws InterruptedException
{
	WebDriverManager.chromedriver().setup();
	
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://demo.automationtesting.in/Alerts.html"); 
	driver.manage().window().maximize(); 
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	//Simple Alert Ok
	System.out.println("Simple Alert - Triggered");
	driver.findElement(By.xpath("(//a[contains(text(),'Alert with OK')])[1]")).click();
	driver.findElement(By.xpath("//button[contains(text(),'alert box')]") ).click();
	Alert simpleAlert = driver.switchTo().alert();
	System.out.println(simpleAlert.getText());
	simpleAlert.accept();
	System.out.println("Simple Alert - Complete");
	System.out.println("");

	//Confirmation  Alert Accepted/Ok
	
	System.out.println("Confirmation Alert with Ok - Triggered");
	driver.findElement(By.xpath("//a[contains(text(),'Alert with OK & Cancel')]") ).click();
	driver.findElement(By.xpath("//button[contains(text(),'confirm box')]") ).click();
	Alert confAlertAccept =driver.switchTo().alert(); 
	System.out.println(confAlertAccept.getText());
	confAlertAccept.accept();
	//Thread.sleep(3000);
	String strConfPressOk =driver.findElement(By.xpath("//p[text()='You pressed Ok']")).getText();
	System.out.println(strConfPressOk);
	//Thread.sleep(3000);
	System.out.println("Confirmation Alert with Ok - Complete");
	System.out.println("");
	
	//Confirmation  Alert Dismiss/Cancel
	System.out.println("Confirmation Alert with Cancel - Triggered");
	driver.findElement(By.xpath("//button[contains(text(),'confirm box')]")).click();
	Alert confAlertCancel = driver.switchTo().alert();
	System.out.println(confAlertCancel.getText());
	confAlertCancel.dismiss();
	//Thread.sleep(3000);
	String strConfPressCancel = driver.findElement(By.xpath("//p[text()='You Pressed Cancel']")).getText();
	System.out.println(strConfPressCancel);
	//Thread.sleep(3000);
	System.out.println("Confirmation Alert with Cancel - Complete");
	System.out.println("");

	//Prompt Alert Accepted/Ok
	System.out.println("Prompt Alert with Ok - Triggered");
	driver.findElement(By.xpath("//a[contains(text(),'Alert with Textbox')]") ).click();
	driver.findElement(By.xpath("//button[contains(text(),'prompt box')]")).click();
	Alert promptAlertOk = driver.switchTo().alert();
	promptAlertOk.sendKeys("Tulika Verma");
	promptAlertOk.accept();
	//Thread.sleep(3000);
	String strPromptOk = driver.findElement(By.xpath("//p[contains(text(),'How are you')]")).getText();
	System.out.println(strPromptOk) ;
	System.out.println("Prompt Alert with Ok - Complete");
	System.out.println("");
	
	//Prompt Alert Dismiss/Cancel
	System.out.println("Prompt Alert with Cancel - Triggered");
	driver.findElement(By.xpath("//button[contains(text(),'prompt box')]")).click();
	Alert promptAlertCancel = driver.switchTo().alert(); 
	promptAlertCancel.sendKeys("Verma");
	promptAlertCancel.dismiss(); 
	Thread.sleep(3000);
	System.out.println("Prompt Alert with Cencel - Complete");
	System.out.println("");
	
	//driver.close();
	driver.quit();
	}
}
