package automationProject;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Stock_Single1 {
	public ChromeDriver Driver;

	@Test

	public void ReiffGainerFetch()  {
		WebDriverManager.chromedriver().setup();
		Driver = new ChromeDriver();
		Driver.get("https://money.rediff.com/gainers");
		Driver.manage().window().maximize();
		// Explicit Wait
		WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(20));
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[contains(@class,'dataTable')]//tr")));

		// getStockDetails("Parnax Lab L");
		//getStockDetails("Mihika Industries");
		// getStockDetails("Tulika");
		
		String[] objects = { "Parnax Lab L","Mihika Industries","Tulika"};
		for (int j = 0 ;j<objects.length;j++  )
		{
			getStockDetails(objects[j] );
		}

		Driver.quit();
	}

	public void getStockDetails(String strStockName)    {
		

			List<WebElement> StockFound = Driver.findElements(By.xpath("//a[normalize-space()='"+ strStockName +"']"));

			if (StockFound.size()>0 ){

			String strStock = Driver.findElement(By.xpath("//a[normalize-space()='"+ strStockName +"']")).getText(); 
			String strGroup = Driver.findElement(By.xpath("//a[normalize-space()='"+ strStockName+"']/parent::td/following-sibling::td[1]")).getText(); 
			String strPrevClose = Driver.findElement(By.xpath("//a[normalize-space()='"+ strStockName +"']/parent::td/following-sibling::td[2]")).getText(); 
			String strCurrentPrice = Driver.findElement(By.xpath("//a[normalize-space()='"+ strStockName +"']/parent::td/following-sibling::td[3]")).getText(); 
			String strPerChange = Driver.findElement(By.xpath("//a[normalize-space()='"+ strStockName+"']/parent::td/following-sibling::td[4]")).getText();
			 System.out.println("Stock Name			:" +strStock);
			 System.out.println("Group				:" +strGroup);
			 System.out.println("Prev Close (Rs)			:" +strPrevClose);
			 System.out.println("Current Price (Rs)		:" +strCurrentPrice);
			 System.out.println("% Change			:" +strPerChange);
			 System.out.println("*********************************************************************");

			}
			else
			{
				System.out.println("Stock " + strStockName +" Not Found"); 
				System.out.println("*********************************************************************");

				}
			
	

	}
}
