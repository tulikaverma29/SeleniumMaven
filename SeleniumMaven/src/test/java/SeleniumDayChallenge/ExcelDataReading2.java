package SeleniumDayChallenge;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReading2 {

	public static void main(String[] args) throws InvalidFormatException, IOException {
		// TODO Auto-generated method stub
		File f = new File("./src/test/resources/ClaimsData.xlsx");
		FileInputStream fis = new FileInputStream(f);
		System.out.println("1");
		XSSFWorkbook workbook = new XSSFWorkbook(f);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int rownum = sheet.getPhysicalNumberOfRows();
		int colnum = sheet.getRow(0).getLastCellNum();
		System.out.println(rownum);
		System.out.println(colnum);
		DataFormatter df = new DataFormatter();
		for (int i=0;i<rownum-1;i++)
		{
			for(int j=0;j<colnum;j++) {
				System.out.println( df.formatCellValue(sheet.getRow(i+1).getCell(j)));
			}
			
			
		}
		workbook.close();
		fis.close();
		
		
		
	}

}
