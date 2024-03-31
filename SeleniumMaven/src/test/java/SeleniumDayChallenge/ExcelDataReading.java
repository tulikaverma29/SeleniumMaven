package SeleniumDayChallenge;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataReading {
@DataProvider
	public String[][] getData() throws IOException {
		// TODO Auto-generated method stub
		File excelFile = new File("./src/test/resources/ClaimsData.xlsx");
		System.out.println(excelFile.exists());
		FileInputStream fis = new FileInputStream(excelFile);
		//xls (H) .xlsx(X)
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int noOfRows =sheet.getPhysicalNumberOfRows();
		int noOfColumns = sheet.getRow(0).getLastCellNum();
		
//		System.out.println("noOfRows "+ noOfRows);
//		System.out.println("noOfColumns "+ noOfColumns);
		String[][] data = new String[noOfRows -1][noOfColumns];
		
		for (int i=0;i<noOfRows-1;i++) {
			for (int j=0;j<noOfColumns;j++) {
				DataFormatter df = new DataFormatter();
				
				data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j) );
				System.out.println(data[i][j]);
				//System.out.println( sheet.getRow(i).getCell(j).getStringCellValue());
			}
			}
		workbook.close();
		fis.close();
		
//		for (String[] dataArr:data) {
//			System.out.println(Arrays.toString(dataArr));
//			
//		}
		return data;
		
	}

}


