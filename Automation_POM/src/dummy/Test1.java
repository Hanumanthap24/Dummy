package dummy;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.attra.datatable.Datatable;

public class Test1 {
	
	public static void main(String[] args) throws Exception {
	
			
			String excelFileName = "C:\\Temp\\testing.xlsx";//name of excel file

			String sheetName = "Sheet1";//name of sheet

			XSSFWorkbook wb = new XSSFWorkbook();
			XSSFSheet sheet = wb.createSheet(sheetName) ;

			//iterating r number of rows
			for (int r=0;r < 5; r++ )
			{
				XSSFRow row = sheet.createRow(r);

				//iterating c number of columns
				for (int c=0;c < 5; c++ )
				{
					XSSFCell cell = row.createCell(c);
		
					cell.setCellValue("Cell "+r+" "+c);
				}
			}

			FileOutputStream fileOut = new FileOutputStream(excelFileName);

			//write this workbook to an Outputstream.
			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();
		}
	    } 
	
	
	

