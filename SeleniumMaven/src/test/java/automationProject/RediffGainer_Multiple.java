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


public class RediffGainer_Multiple {

	@Test
	public void FetchGainer() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver Driver = new ChromeDriver();
		Driver.get("https://money.rediff.com/gainers");
		Driver.manage().window().maximize(); 
		//Explicit Wait
		WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[contains(@class,'dataTable')]//tr")));
		
		List<WebElement>numberOfRows=	Driver.findElements(By.xpath("//table[contains(@class,'dataTable')]//tr")) ;
		System.out.println("No of Rows :" + numberOfRows.size() );
		System.out.println("==============================================" );
		
		List<WebElement>numberOfColumn=	Driver.findElements(By.xpath("//table[contains(@class,'dataTable')]//th")) ;
		System.out.println("No of Column :" + numberOfColumn.size() );
		System.out.println("==============================================" );
		
		List <WebElement> allrows = Driver.findElements(By.xpath("//table[contains(@class,'dataTable')]//tr")); 

		
		String[] objects = { "Kraft","Swamy","Tulika"};
		boolean[] blnstockFound = {false, false,false};
		
		
		//System.out.println(strStockLookup );
		for (int j = 0 ;j<objects.length;j++  )
		{
			int intcount =0;
			String strStockLookup =objects[j] ;
		for(WebElement ele: allrows )
		{	
			String value =ele.getText();
			
			
			if (value.contains(objects[j] ))
			{
				blnstockFound[j]=true;
				System.out.println("****************************************************************"); 
				System.out.println("Stock name Found : "+value); // Printing Stock name here
				System.out.println("****************************************************************"); 
				String ColData ="";
				String ColHeader ="";
				
				for (int i= 1; i<=numberOfColumn.size();i++) {
					ColHeader = Driver.findElement(By.xpath("//table[@class='dataTable']/thead/tr/th["+i+"]")).getText();
					ColData =Driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+ intcount+ "]/td["+i+"]")).getText();
					
				System.out.println(ColHeader + " : "+ ColData) ;
				
				}
				//System.out.println("---------------------------------------------------------------- "); 
				break;	
			}
			intcount++;
			
			//System.out.println(" Searching ........" + intcount );
		}
		
		if (blnstockFound[j] == false)
		{
			System.out.println("****************************************************************"); 
			System.out.println( "Stock name : "+ strStockLookup+" doesnot exists in Top Gainer Table. ");
			System.out.println("****************************************************************"); 
		}
		}
		
		Driver.quit();
	}

}
