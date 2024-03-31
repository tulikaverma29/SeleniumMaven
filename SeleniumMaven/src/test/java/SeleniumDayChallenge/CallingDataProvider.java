package SeleniumDayChallenge;

import org.testng.annotations.Test;


public class CallingDataProvider {
  @Test(dataProvider = "getData", dataProviderClass =  ExcelDataReading.class)
  public void fetch(String a, String b, String c, String d) {
	  System.out.println(a);
	  System.out.println(b);
	  System.out.println(c);
	  System.out.println(d);
  }


}
