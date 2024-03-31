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

public class RediffGainer_Backup {

	@Test
	public void FetchGainer() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver Driver = new ChromeDriver();
		
		
		Driver.get("https://money.rediff.com/gainers");
		Driver.manage().window().maximize(); 
		System.out.println("1" );
		WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[contains(@class,'dataTable')]//tr")));
		
		List<WebElement>numberOfRows=	Driver.findElements(By.xpath("//table[contains(@class,'dataTable')]//tr")) ;
		System.out.println("No of Rows :" + numberOfRows.size() );
		System.out.println("==============================================" );
		
		List<WebElement>numberOfColumn=	Driver.findElements(By.xpath("//table[contains(@class,'dataTable')]//th")) ;
		System.out.println("No of Column :" + numberOfColumn.size() );
		System.out.println("==============================================" );
		
		List <WebElement> allData = Driver.findElements(By.xpath("//table[contains(@class,'dataTable')]//td")); 
		//Parnax Lab L
		boolean blnstockFound = false;
		boolean blnBreak = false;
		String strStockLookup="IDFC"; //Data available on the site
		//String strStockLookup="Tulika"; //Data missing on the site
		int intcount =0;
		//System.out.println(strStockLookup );
		for(WebElement ele: allData )
		{	
			String value =ele.getText();
			//System.out.println(value + " " + blnstockFound );
			if (blnstockFound && intcount <4)
			{
				intcount=intcount+1;
				switch (intcount) {
					case 1:
						System.out.println("Group " + value);
						break;
					case 2:
						System.out.println("Current Price " + value);
						break;
					case 3:
						System.out.println("Previous Close " + value);
						break;
					case 4:
						System.out.println("Percentage Change " + value);
						blnBreak= true;
						break;
					default :
						System.out.println("Do nothing " + value);
						break;
				}
				
				if (blnBreak ==true){
					break;
				}
				
			}
			if (value.contains(strStockLookup))
			{
				blnstockFound=true;
				System.out.println("Stock name Found : "+value); // Printing Stock name here

			}
		}
		
		if (blnstockFound == false)
		{
			System.out.println( "Stock name : "+ strStockLookup+" doesnot exists in Top Gainer Table. ");
		}
		
		Driver.close();
	}

}
