package dummy;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.hssf.record.cf.BorderFormatting;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.attra.datatable.Datatable;
import com.attra.pages.AccountDetails;

public class Hashmap {
       public static void main(String[] args) {
              HashMap<String,String> h1= new  HashMap<String, String>();
              h1.put("3ss", "Ae");
              h1.put("4sss4", "B");
              h1.put("34", "Ce");
              h1.put("d4", "De");
              h1.put("5", "E");
              //System.out.println(h1);
              Datatable.saveFetchedValuesToExcel("C:\\HASH\\BOOK.xlsx","Sheet 222", 10, 1, h1);
              
       }
       
       public static void saveFetchedValuesToExcel(String FileName,String SheetName,int rowNum,int colNum,HashMap<String, String> fetchedvalues)
    {
                OutputStream  fout=null;
                XSSFWorkbook wb=null;
                XSSFSheet sheet=null;
                XSSFRow  row=null;
                XSSFCell  cell=null;
                XSSFCell  cell2=null;
                    try
                    {
                                   
                    	 wb = new XSSFWorkbook();
                		 sheet = wb.createSheet(SheetName) ;
                                    if(sheet==null)
                                    {
                                                    sheet=wb.createSheet(SheetName);
                                    }
                                     row = sheet.createRow(0);
                                     XSSFRow nextRow=sheet.createRow(1);
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
                                   fout=new FileOutputStream("C:\\HASH\\BOOK.xlsx");
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

}



