package dummy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.attra.datatable.Datatable;

public class Test1 {
	
	public static void main(String[] args) throws Exception
	{
		String [][] Values=new String[2][2];
		
		Values[0][0]="1";
		Values[0][1]="1";
		Values[1][0]="1";
		Values[1][1]="1";
		
		
		
		Test1.ArrayToexcel("C:\\temp\\tttt.xlsx", "sheetName", Values);
		
		Test1.ArrayToexcel("C:\\temp\\tttt.xlsx", "sheetName", Values);
	}
	
	public static void ArrayToexcel(String excelFileName,String sheetName,String [][] Values) throws Exception {
		XSSFSheet sheet=null;
			XSSFWorkbook wb = null;
			//sheet=wb.getSheet(sheetName);
			FileInputStream fis=null;
       	 File file = new File (excelFileName);

        	 if(new File(excelFileName).exists()){ //check if file exists
        		  fis = new FileInputStream(new File(excelFileName));
        		  wb = new XSSFWorkbook(fis);
        		  sheet=wb.getSheet(sheetName);
        		}
        		else{
        			wb = new XSSFWorkbook();
        			sheet =  wb.createSheet(sheetName);
        		   
        		}
        	 
			if(sheet==null) {
				 sheet = wb.createSheet(sheetName) ;
			}
		
			XSSFRow row=null;

			int lastRowNum=sheet.getLastRowNum();
			 row=sheet.getRow(lastRowNum);
			 int beginFromRow=0;
				String header1;
				try {
					header1 = sheet.getRow(lastRowNum).getCell(0).getStringCellValue();
					if(header1.length()<1) {
					}
					else {
							beginFromRow=lastRowNum+1;	
						}
				} catch (Exception e1) {
					beginFromRow=0;
					}

				
			

			 
			//iterating r number of rows
			for (int j=0;j < Values[0].length; j++ )
			{

				//iterating c number of columns
				int arrCounter=0;
			
				for (int i=beginFromRow;i <beginFromRow+Values.length; i++ ){
					
					row=sheet.getRow(i);
					if(row==null) {
						 row = sheet.createRow(i);
					}
						
					Cell cell = row.createCell(j);
					
					
					cell.setCellValue(Values[arrCounter][j]);
					arrCounter++;
				  
						 }
						 }
				
			FileOutputStream fileOut = new FileOutputStream(excelFileName);

			//write this workbook to an Outputstream.
			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();
		}
}
	
	

