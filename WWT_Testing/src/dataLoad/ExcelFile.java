package dataLoad;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
//import com.google.common.collect.Table.Cell;

import org.junit.Test;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;

import pageObjects.PageObjects;

public class ExcelFile {

@Test 
	
	//Read each cell from given excel file and convert to 2 dimensional array
	public static String[][] ReadMyExcel(String filepath, String sheetName) throws IOException{
		int XDRows;
		int XDCols;
		String[][] XData;
			File myxl=new File(filepath);
			FileInputStream stream=new FileInputStream(myxl);
			HSSFWorkbook workbook=new HSSFWorkbook(stream);
			//HSSFSheet sheet=workbook.getSheetAt(sheetnumber);
			
			HSSFSheet sheet=workbook.getSheet(sheetName);
			XDRows=sheet.getLastRowNum()+1;
			 XDCols=sheet.getRow(0).getLastCellNum();
			 System.out.println(" Excel files Rows :"+XDRows+"  Columns :"+XDCols);
			 XData=new String [XDRows][XDCols];
			for(int i=0; i<XDRows; i++){
				HSSFRow row=sheet.getRow(i);
				for(int j=0; j<XDCols; j++){
					HSSFCell cell=row.getCell(j);
					String cellvalue=cellToString(cell);
					XData[i][j]=cellvalue;
					//System.out.print(" "+XData[i][j]);
				}
				//System.out.println("");
			}
			stream.close();
	return XData;
	}
		@Test 
		public static String cellToString(HSSFCell cell){
			//this function will identify the cell content type and coverts into string
			int type=cell.getCellType();
			  Object result;
			switch (type){
			case Cell.CELL_TYPE_NUMERIC: //0
	            result =(int) cell.getNumericCellValue();
	           // int t=Integer.parseInt(result);
	            break;
	        case Cell.CELL_TYPE_STRING: //1
	            result = cell.getStringCellValue();
	            break;
	        case Cell.CELL_TYPE_FORMULA: //2
	            throw new RuntimeException("We can't evaluate formulas in Java");
	        case Cell.CELL_TYPE_BLANK: //3
	            result = "-";
	            break;
	        case Cell.CELL_TYPE_BOOLEAN: //4
	            result = cell.getBooleanCellValue();
	            break;
	        case Cell.CELL_TYPE_ERROR: //5
	            throw new RuntimeException ("This cell has an error");
	        default:
	            throw new RuntimeException("We don't support this cell type: " + type);
			}
			 return result.toString();
			
		}
}




