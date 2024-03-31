package SeleniumDayChallenge;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utils {

	public static void captureScreenshot(WebDriver driver, String fileName) throws IOException {
		// TODO Auto-generated method stub
		TakesScreenshot ts = (TakesScreenshot )driver;
		File f = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f,new File("./Screenshots/"+fileName+""));
		
	}

}
