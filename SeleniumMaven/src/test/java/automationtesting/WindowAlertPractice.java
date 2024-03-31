package automationtesting;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowAlertPractice {
@Test
	public void WindowAlert() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver Driver = new ChromeDriver();
		Driver.get("https://demo.automationtesting.in/Windows.html"); 
		Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String parentWindow = Driver.getWindowHandle() ;
		
		//Open new Tabbed Windows----------------------
		Driver.findElement(By.xpath( "//a[contains(text(),'Tabbed Windows')]")).click();
		System.out.println("Clicked -Open new Tabbed windows" ); 
		Driver.findElement(By.xpath("(//button[contains(text(),'click')])[1]") ).click(); 
		System.out.println("Clicked button -Click " ); 
		Set<String> allWindow =Driver.getWindowHandles(); 
		for (String window:allWindow )
		{		
			String title = Driver.switchTo().window(window).getTitle(); 
			if(title.equals("Selenium") ) {
				
				System.out.println("Clicked tabed window button :" + title); 	
				WebElement element = Driver.findElement(By.xpath("(//a[contains(text(),'Read more')])[1]"));
				Driver.executeScript("arguments[0].scrollIntoView(false);", element);		
		        Thread.sleep(3000); 
				Driver.findElement(By.xpath("(//a[contains(text(),'Read more')])[1]")).click();	
				Driver.close(); 
			}	
		}
		 
		Driver.switchTo().window(parentWindow); 
		System.out.println("****************************************************");
		
		//Open new Seperate Windows----------------------
		Driver.findElement(By.xpath("//a[contains(text(),'Seperate Windows')]")).click();
		Driver.findElement(By.xpath( "//button[@class='btn btn-primary']")).click();
		Set <String> allWindow2 = Driver.getWindowHandles(); 
		for (String window:allWindow2  ) {
			String title =Driver.switchTo().window(window).getTitle(); 
			
			if (title.equals("Selenium") ) {
				System.out.println("Open new Seperate Windows " + title); 
				Driver.manage().window().maximize();
				WebElement element = Driver.findElement(By.xpath("//a[contains(@class , 'selenium-webdriver')]"));
				Driver.executeScript("arguments[0].scrollIntoView(false);", element);
				Thread.sleep(3000) ;
				Driver.findElement(By.xpath("//a[contains(@class , 'selenium-webdriver')]")).click(); 
				System.out.println("Open new Seperate Windows Read more clicked" ); 
				Driver.close(); 
			}
		}
		Driver.switchTo().window(parentWindow);
		System.out.println("****************************************************");
		
		/////////////////////////////////////
		
		//Open Seperate Multiple Windows----------------------
				Driver.findElement(By.xpath("//a[contains(text(),'Multiple Windows')]")).click(); 
				Driver.findElement(By.xpath( "//*[@id=\"Multiple\"]/button")).click();
				Set <String> allWindow3 = Driver.getWindowHandles(); 
				for (String window:allWindow3  ) {
					String title =Driver.switchTo().window(window).getTitle(); 
					System.out.println("Open Multiple Windows : " + title); 
				}
				Driver.close();
				Driver.switchTo().window(parentWindow);
				System.out.println("****************************************************");
		
		Driver.quit();
	}
}
