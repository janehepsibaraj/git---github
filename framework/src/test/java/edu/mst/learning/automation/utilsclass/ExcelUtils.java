package edu.mst.learning.automation.utilsclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import edu.mst.learning.automation.constant.Constant;

/**
 * @author Jane Hepsiba
 * Description: To create a excelutils class
 *
 */
public class ExcelUtils {
	static FileInputStream filelocation;        //declared the instance variables
	static Workbook wb;
	static Sheet sheet;
    static Row row;
	static Cell cell;
	static int totalrows;
	static int totalcolumns;
	static String result;
	
	

	
	
	  public static void openExcel() throws IOException  {                        //method used to open the excel
		  System.out.println(Constant.datafilepath);
		filelocation  = new FileInputStream(Constant.datafilepath);
		String fileExtension = Constant.datafilepath.substring(Constant.datafilepath.indexOf("."));
		System.out.println(fileExtension);
		
		if(fileExtension.equals(".xlsx")) {
			wb = new XSSFWorkbook(filelocation);
			
		}
		else if(fileExtension.equals(".xls")){
			wb = new HSSFWorkbook(filelocation);
		}
		
		
		
		
	}
	public static String readExcel(String Sheetname, String Testcase_ID, String Headervalue) {    //method used to read the values in excel
		Object result = new Object();
		sheet = wb.getSheet(Sheetname);
		totalrows = sheet.getLastRowNum();
		row = sheet.getRow(1);
		totalcolumns = row.getLastCellNum();
		cell= row.getCell(0);
		
		for(int i=0;i<=totalrows;i++) {
			String TC_ID = sheet.getRow(i).getCell(0).getStringCellValue();
			if(TC_ID.equals(Testcase_ID)) {
				System.out.println(TC_ID);
			}
			for(int j=1;j<=totalcolumns;j++) {
				String TestDataHeaderValues = sheet.getRow(0).getCell(j).getStringCellValue();
				if(TestDataHeaderValues.equals(Headervalue)) {
					cell = sheet.getRow(i).getCell(j);
					System.out.println(cell);
					if(cell!=null) {
						switch (cell.getCellType()) {
						case NUMERIC:
							result = cell.getNumericCellValue();
							break;
							
						case STRING:
							result = cell.getStringCellValue();
							break;
							
						case BOOLEAN:
							result = cell.getBooleanCellValue();
							break;
							
						case BLANK:
							result = cell.getStringCellValue();
						}
						result =result.toString();
					}
				}
			}
			
		}
		    return  (String) result;
		
		
		        
	}
	public static void closeExcel() throws IOException  {    //method used to close the excel
		filelocation.close();
		
	}

}
