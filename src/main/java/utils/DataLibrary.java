package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DataLibrary {

	public static String[][] getData(String excelfilename) throws IOException {
		//To open a spreadsheet
		XSSFWorkbook book = new XSSFWorkbook("./testdata/"+excelfilename+".xlsx");
		//To open a specific sheet
		XSSFSheet sheet = book.getSheetAt(0);
		//To get the number of rows of data available
		int rowCount = sheet.getLastRowNum();
		System.out.println("No of rows in excel: " + rowCount);
		//to get the number of columns of data available
		int colCount = sheet.getRow(0).getLastCellNum();
		System.out.println("Column count is: " + colCount);

        //create 2D array to store the data from the excel
		String[][] data = new String[rowCount][colCount];
		//iterate over rows and columns
		for (int i=1;i<=rowCount;i++) {
			XSSFRow eachRow = sheet.getRow(i);
			for (int j=0; j<colCount;j++) {
				XSSFCell cell = eachRow.getCell(j);
				String stringCellValue = cell.getStringCellValue();
				System.out.println(stringCellValue);
				data[i-1][j] = stringCellValue;
			}
		}
		book.close();
		return data;
	}
}