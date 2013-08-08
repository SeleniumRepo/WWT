package dataLoad;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class FileData{

	
	public  Map<String, String>  getValues(String fileName){
		
		Map<String,String> elementLocator = new HashMap<String,String>();
		try {
		     
		    FileInputStream file = new FileInputStream(new File(fileName));
		     
		    //Get the workbook instance for XLS file 
		    HSSFWorkbook workbook = new HSSFWorkbook(file);
		 
		    //Get first sheet from the workbook
		    HSSFSheet sheet = workbook.getSheetAt(0);
		     
		    //Iterate through each rows from first sheet
		    Iterator<Row> rowIterator = sheet.iterator();
		    while(rowIterator.hasNext()) {
		        Row row = rowIterator.next();
		       // System.out.println("number of rows"+ row.getFirstCellNum());
		        elementLocator.put(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue());
		        //For each row, iterate through each columns
		        /*
		        Iterator<Cell> cellIterator = row.cellIterator();
		        while(cellIterator.hasNext()) {
		             
		            Cell cell = cellIterator.next();
		             

		                    System.out.print(cell.getStringCellValue() + "\t\t");
		                    
		                    
		                    
		         
		        }
		        */
		        
		    }
		    file.close();
		    FileOutputStream out = 
		        new FileOutputStream(new File("C:\\test.xls"));
		    workbook.write(out);
		    out.close();
		     
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		return elementLocator;
	}
	

}