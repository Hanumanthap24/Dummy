package com.attra.datatable;
    
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.attra.driverscript.Driverscript;
import com.attra.utils.AppIndependant;

public class Datatable extends Driverscript
{
	public static Workbook wb;
	public String path;
	public  FileInputStream fis = null;
    public  FileOutputStream fileOut =null;
    private XSSFWorkbook workbook = null;
    private XSSFSheet sheet = null;
    private XSSFRow row   =null;
    private XSSFCell cell = null;

	public Datatable(String path) 
    {

        this.path=path;
        try {
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	public Datatable()
	{
		
	}
	public int rowCount(String FileName,String SheetName)
	{
		FileInputStream fin=null;
		Workbook wb=null;
		Sheet sheet=null;
		int rc=0;
		try
		{
			fin=new FileInputStream(FileName);
			wb=new XSSFWorkbook(fin);
			sheet=wb.getSheet(SheetName);
			rc=sheet.getPhysicalNumberOfRows();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				fin.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return rc-1;
	}
	public boolean importExcelFile(String FileName,String SheetName)
	{
		FileInputStream fin=null;
		try
		{
			fin=new FileInputStream(FileName);
			wb=new XSSFWorkbook(fin);
			if(wb==null)
			{
				return false;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return true;
	}
	public int rowCount(String SheetName)
	{
		Sheet sheet=null;
		int rc=0;
		try
		{
			wb=new XSSFWorkbook();
			sheet=wb.getSheet(SheetName);
			rc=sheet.getLastRowNum();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return rc;
	}
	@SuppressWarnings("deprecation")
	public static HashMap<String, String> getCellData(String FileName,String SheetName,int rowNum)
	{
		FileInputStream fin=null;
		Workbook wb=null;
		Sheet sheet=null;
		Row headerRow=null;
		Row dataRow=null;
		Cell cell=null;
		Cell cell2=null;
		int colNum=0;
		String stringCellData="";
		 HashMap<String,String> data= new  HashMap<String, String>();
		try
		{
			fin=new FileInputStream(FileName);
			wb=new XSSFWorkbook(fin);
			sheet=wb.getSheet(SheetName);
			headerRow=sheet.getRow(0);
			dataRow=sheet.getRow(rowNum);
			for(int c=0;c<dataRow.getLastCellNum();c++)
			{
			cell=headerRow.getCell(c);
			cell2=dataRow.getCell(c);
			
				String ColumnName=cell.getStringCellValue();
				String value=cell2.getStringCellValue();
				data.put(ColumnName, value);
				/*
				 * if(ColumnName.equalsIgnoreCase(ColName.trim())) { colNum=c; break; }
				 */
			}
			/*
			 * row=sheet.getRow(rowNum); cell=row.getCell(colNum);
			 * if(cell.getCellTypeEnum()==CellType.BLANK) { stringCellData=""; }
			 * if(cell.getCellTypeEnum()==CellType.BOOLEAN) {
			 * stringCellData=String.valueOf(cell.getBooleanCellValue()); }
			 * if(cell.getCellTypeEnum()==CellType.STRING) {
			 * stringCellData=cell.getStringCellValue(); }
			 * 
			 * if(cell.getCellTypeEnum()==CellType.FORMULA||cell.getCellTypeEnum()==CellType
			 * .NUMERIC) { if(HSSFDateUtil.isCellDateFormatted(cell)) { double
			 * d=cell.getNumericCellValue(); Calendar cal=Calendar.getInstance();
			 * cal.setTime(HSSFDateUtil.getJavaDate(d));
			 * stringCellData=cal.get(Calendar.MONTH)+1+"-"+cal.get(Calendar.DAY_OF_MONTH)+
			 * "-"+cal.get(Calendar.YEAR); } else
			 * if(cell.getCellTypeEnum()==CellType.NUMERIC) { double
			 * d=cell.getNumericCellValue(); int in=(int) d;
			 * stringCellData=String.valueOf(in); } }
			 */
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				cell=null;
				wb.close();
				fin.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return data;
	}
	/*public void fileWriter(String fileName,String str)
	{
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			fw = new FileWriter(FILENAME);
			bw = new BufferedWriter(fw);
			bw.write(str);

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {
				bw.flush();
				fw.flush();
			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
	}*/
	public void setCellData(String FileName,String SheetName,String ColName,int rowNum,String strData)
	{
		FileOutputStream fout=null;
		FileInputStream fin=null;
		Workbook wb=null;
		Sheet sheet=null;
		Row row=null;
		Cell cell=null;
		int colNum=0;
		try
		{
			fin=new FileInputStream(FileName);
			wb=new XSSFWorkbook(fin);

			sheet=wb.getSheet(SheetName);
			if(sheet==null)
			{
				sheet=wb.createSheet(SheetName);
			}
			row=sheet.getRow(0);
			for(int c=0;c<row.getLastCellNum();c++)
			{
				cell=row.getCell(c);
				String ColumnName=cell.getStringCellValue();
				if(ColumnName.equalsIgnoreCase(ColName.trim()))
				{
					colNum=c;
					break;
				}
			}
			row=sheet.getRow(rowNum);
			if(row==null)
			{
				row=sheet.createRow(rowNum);
			}
			cell=row.getCell(colNum);
			if(cell==null)
			{
				cell=row.createCell(colNum);
			}
			cell.setCellValue(strData);
			fout=new FileOutputStream(FileName);
			wb.write(fout);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				wb=null;
				cell=null;
				fout.flush();
				fout.close();
				fin.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	public void setCellData(String FileName,String SheetName,int rowNum,int colNum,String strData)
	{
		FileOutputStream fout=null;
		Workbook wb=null;
		Sheet sheet=null;
		Row row=null;
		Cell cell=null;
		try
		{
			wb=new XSSFWorkbook();
			sheet=wb.getSheet(SheetName);
			if(sheet==null)
			{
				sheet=wb.createSheet(SheetName);
			}

			for(int r=0;r<rowNum;r++)
			{
				row=sheet.getRow(r);
				if(row==null)
				{
					row=sheet.createRow(r);
				}

				for(int c=0;c<colNum;c++)
				{
					cell=row.getCell(c);
					if(cell==null)
					{
						cell=row.createCell(c);
					}
					cell.setCellValue(strData);
				}
			}

			fout=new FileOutputStream(FileName);
			wb.write(fout);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				wb=null;
				cell=null;
				fout.flush();
				fout.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	@SuppressWarnings({ "resource" })
	public boolean addColumn(String fileName,String sheetName,String colName,int rowIndex)
	{
		FileInputStream fis=null;
		FileOutputStream fout=null;
		Workbook wb=null;
		Sheet sheet=null;
		Row row=null;
		Cell cell=null;
		try{
			fis = new FileInputStream(fileName);
			wb = new XSSFWorkbook(fis);
			int index = wb.getSheetIndex(sheetName);
			if(index==-1)
				return false;

			//CellStyle style = wb.createCellStyle();
			//style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
			//style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

			sheet=wb.getSheetAt(index);

			row = sheet.getRow(rowIndex);
			if (row == null)
				row = sheet.createRow(rowIndex);

			//cell = row.getCell();
			//if (cell == null)
			//System.out.println(row.getLastCellNum());
			if(row.getLastCellNum() == -1)
				cell = row.createCell(0);
			else
				cell = row.createCell(row.getLastCellNum());

			cell.setCellValue(colName);
			// cell.setCellStyle(style);	
			fout = new FileOutputStream(fileName);
			wb.write(fout);
			fout.close();

		}catch(Exception e){
			e.printStackTrace();
			return false;
		}

		return true;
	}
	public void cleanSheet(String fileName,String sheetName) 
    {
    	FileOutputStream fout=null;
		FileInputStream fin=null;
    	Workbook wb=null;
    	Sheet sheet=null;
    	try
    	{
    		fin=new FileInputStream(fileName);
    		wb=new XSSFWorkbook(fin);
    		sheet=wb.getSheet(sheetName);
    		int numberOfRows = sheet.getPhysicalNumberOfRows();
    		
            if(numberOfRows > 0) 
            {
                for (int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); i++) {
                    if(sheet.getRow(i) != null) {
                        sheet.removeRow( sheet.getRow(i));
                    } else {
                        System.out.println("Info: clean sheet='" + sheet.getSheetName() + "' ... skip line: " + i);
                    }
                }               
            } else {
                System.out.println("Info: clean sheet='" + sheet.getSheetName() + "' ... is empty");
            } 
            fout = new FileOutputStream(fileName);
            wb.write(fout);
            fout.close();
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    

    public static void saveFetchedValuesToExcel(String FileName,String SheetName,int rowNum,int colNum,HashMap<String, String> fetchedvalues)
 {
             OutputStream  fout=null;
             XSSFWorkbook wb=null;
             FileOutputStream outFile=null;
             FileInputStream fis = null;
             XSSFSheet sheet=null;
             XSSFRow  row=null;
             XSSFCell  cell=null;
             XSSFCell  cell2=null;
             if(!FileName.contains(".xlsx")){
            	 FileName = FileName+".xlsx";
             }
            
                 try
                 {
                	 File file = new File (FileName);
                	 if(new File(FileName).exists()){ //check if file exists
                		  fis = new FileInputStream(new File(FileName));
                		  wb = new XSSFWorkbook(fis);
                		}
                		else{
                			wb = new XSSFWorkbook();
                			sheet =  wb.createSheet(SheetName);
                		   
                		}
                	 
                     
                     
                 	// wb = new XSSFWorkbook();
             		 try {
						sheet = (XSSFSheet) wb.getSheet(SheetName);
					} catch (Exception e) {
						  sheet=(XSSFSheet) wb.createSheet(SheetName);
					}
                                 if(sheet==null)
                                 {
                                                 sheet=(XSSFSheet) wb.createSheet(SheetName);
                                 }
                                  row = sheet.createRow(0);
                                  XSSFRow nextRow=sheet.createRow(rowNum);
                                                 Set st = (Set) fetchedvalues.entrySet();
                                                 Iterator it = st.iterator();
                                                 int counter;
                                                 counter=0;
                                                 while(it.hasNext()){
                                                         CellStyle style = wb.createCellStyle();
                                                           style.setFillBackgroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
                                                           style.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
                                                           style.setBorderBottom(BorderStyle.THIN);
                                                           style.setBorderLeft(BorderStyle.THIN);
                                                           style.setBorderRight(BorderStyle.THIN);
                                                           style.setBorderTop(BorderStyle.THIN);
                                                           
                                                           
                                                           style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                                                     Map.Entry entry = (Entry) it.next();
                                                     Cell header=row.createCell(counter);
                                                     header.setCellStyle(style);
                                                     header.setCellValue((String) entry.getKey());
                                                     nextRow.createCell(counter++).setCellValue((String) entry.getValue());
                                                }
                                                 

                                                  outFile =new FileOutputStream(new File(FileName));
                                                 wb.write(outFile);
                                                 outFile.close();
                 }catch(Exception e)
                 {
                                 e.printStackTrace();
                 }
                 finally
                 {
                                 try
                                 {
                                                 wb=null;
                                                 cell=null;
                                                 outFile.flush();
                                                 outFile.close();
                                 }catch(Exception e)
                                 {
                                                 e.printStackTrace();
                                 }
                 }
 }
    
    public static void saveFetchedArrayValuesToExcel(String FileName,String SheetName,int rowNum,int colNum,String fetchedvalues[][])
    {
                OutputStream  fout=null;
                XSSFWorkbook wb=null;
                FileOutputStream outFile=null;
                FileInputStream fis = null;
                XSSFSheet sheet=null;
                XSSFRow  row=null;
                XSSFCell  cell=null;
                XSSFCell  cell2=null;
               
                    try
                    {
                   	 File file = new File (FileName);
                   	 if(new File(FileName).exists()){ //check if file exists
                   		  fis = new FileInputStream(new File(FileName));
                   		  wb = new XSSFWorkbook(fis);
                   		}
                   		else{
                   			wb = new XSSFWorkbook();
                   			sheet =  wb.createSheet(SheetName);
                   		   
                   		}
                   	        	// wb = new XSSFWorkbook();
                		 try {
   						sheet = (XSSFSheet) wb.getSheet(SheetName);
   					} catch (Exception e) {
   						  sheet=(XSSFSheet) wb.createSheet(SheetName);
   					}
                                    if(sheet==null)
                                    {
                                                    sheet=(XSSFSheet) wb.createSheet(SheetName);
                                    }
                                    for (int i = 0; i < fetchedvalues.length; i++) {
									
                                    row = sheet.getRow(i);
                        			if (row == null)
                        				row = sheet.createRow(i);
                        			for (int j = 0; j < fetchedvalues[i].length; j++) {
                        				cell=row.getCell(j);
                            			if (cell == null)
                            				row.createCell(j);                                                 
                                    	}
                                    }

                                                     outFile =new FileOutputStream(new File(FileName));
                                                    wb.write(outFile);
                                                    outFile.close();
                    }catch(Exception e)
                    {
                                    e.printStackTrace();
                    }
                    finally
                    {
                                    try
                                    {
                                                    wb=null;
                                                    cell=null;
                                                    outFile.flush();
                                                    outFile.close();
                                    }catch(Exception e)
                                    {
                                                    e.printStackTrace();
                                    }
                    }
    }
    

	public static void ArrayToexcel(String excelFileName,String sheetName,String [][] Values) throws Exception {
		XSSFSheet sheet=null;
			XSSFWorkbook wb = null;
			if(sheetName.length()>31){

				sheetName=sheetName.substring(0,31);

				sheetName =sheetName.replace("/", "_");

				}
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


	@SuppressWarnings("resource")
	public boolean addSheet(String  sheetname){

        FileOutputStream fileOut;
    	Workbook wb=null;
    	Sheet sheet=null;
        try 
        {
        	wb=new XSSFWorkbook();
        	sheet=wb.getSheet(sheetname);
            if(sheet==null)
            {
            	sheet=wb.createSheet(sheetname);
            }
            fileOut = new FileOutputStream(path);
            wb.write(fileOut);
            fileOut.flush();
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
	public static void main(String[] args) {
		Datatable dat=new Datatable("D://Test.xlsx");
		AppIndependant a=new AppIndependant();
		String sheet="Sheet_"+a.getDateTime("dd-MMM-YY_hh-mm-ss");
		dat.addSheet(sheet);
	}
}
