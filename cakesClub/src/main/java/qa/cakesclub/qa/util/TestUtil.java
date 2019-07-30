package qa.cakesclub.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtil {
	// Page loading timeout
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	public static String Error = "Error: The Actual Result does not match with Expected Result";
	
	public static String TESTDATA_SHEET_PATH = "C:/workspace_sanjib/cakesClub/src/main/java/qa/cakesclub/qa/testdata/CakesClubTestData.xls";
	static Workbook book;
	static Sheet sheet;


	public static Object[][] getTestData(String sheetName){		
		
		FileInputStream file = null;
		Object[][] data = null;
		try{
			file = new FileInputStream(TESTDATA_SHEET_PATH);
			book = WorkbookFactory.create(file);
		sheet = book.getSheet(sheetName);
		 data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i < sheet.getLastRowNum(); i++){
			for(int k=0; k<sheet.getRow(0).getLastCellNum(); k++){
				if(sheet.getRow(i+1).getCell(k) != null){
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();				
				}
				else
					data[i][k] = "";
			}
		}
		}
		
		
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(InvalidFormatException e){
				e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();		
		}
		
		return data;
		
		
	}
	

}
