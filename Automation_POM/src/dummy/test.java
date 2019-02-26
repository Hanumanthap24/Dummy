package dummy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException; 
import org.apache.poi.sl.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class test {

	public static void main(String[] args) throws IOException, EncryptedDocumentException, InvalidFormatException {
		
		    // Obtain a workbook from the excel file
		    Workbook workbook = WorkbookFactory.create(new File("C:\\Temp\\Test2.xlsx"));

		    // Get Sheet at index 0
		    Sheet sheet = workbook.getSheetAt(0);

		    // Get Row at index 1
		    //Row nextRow=sheet.createRow(1);
		    Row row = sheet.createRow(1);
		    
		    // Get the Cell at index 2 from the above row
		    Cell cell = row.createCell(1);
		     cell = row.getCell(1);

		    // Create the cell if it doesn't exist
		    if (cell == null)
		        cell = row.createCell(1);

		    // Update the cell's value
		    cell.setCellType(CellType.STRING);
		    cell.setCellValue("Updated Value");

		    // Write the output to the file
		    FileOutputStream fileOut = new FileOutputStream("C:\\Temp\\Test2.xlsx");
		    try {
				workbook.write(fileOut);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    fileOut.close();

		    // Closing the workbook
		    workbook.close();
		}

	}


