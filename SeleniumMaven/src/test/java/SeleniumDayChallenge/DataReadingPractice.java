package SeleniumDayChallenge;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReadingPractice {

	public static void main(String[] args) throws InvalidFormatException, IOException {
		// TODO Auto-generated method stub

		File fs = new File("./src/test/resources/ClaimsData.xlsx");
		FileInputStream fis = new FileInputStream(fs);

		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getLastCellNum();
		String[][] arr = new String[rowCount-1] [colCount];
		DataFormatter df = new DataFormatter();
		for (int i = 0; i < rowCount-1; i++) {
			for (int j = 0; j < colCount; j++) {
				arr[i][j] =df.formatCellValue(sheet.getRow(i+1).getCell(j));
				
				System.out.println( df.formatCellValue(sheet.getRow(i+1).getCell(j)));
				//System.out.println(sheet.getRow(rowCount + 1).getCell(colCount).getStringCellValue());
			}
		}
		workbook.close();
		fis.close();
	}

}
