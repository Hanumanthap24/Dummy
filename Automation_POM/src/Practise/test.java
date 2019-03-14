package Practise;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.attra.datatable.Datatable;
import com.attra.driverscript.Driverscript;
import com.attra.pages.AccountDetails;
import com.attra.pages.LoginPage;
import com.attra.testcases.Webtable_utility;

import dummy.Test1;

public class test extends Driverscript {

	@Test(enabled=true)
public void hi() throws Exception {
HashMap<String, String> dataHashMap;
		HashMap<String, String> dataOutputHashmap = new HashMap<String, String>();
		dataHashMap = Datatable.getCellData(datasheet, "Sheet1", 1);
	
		Driverscript.runner(dataHashMap);
		driver.get(dataHashMap.get("Url"));
		initElements();
		// Thread.sleep(10000);
		loginPage.getUserName().sendKeys(dataHashMap.get("UserName"));
		loginPage.getPassword().sendKeys(dataHashMap.get("Password"));
		loginPage.getSubmitButton().click();
		Webtable_utility.simpleTableWithOutHeadersDataCapture(driver,"sxzxheetName");	
		}
		
		
		
//		int rows=driver.findElements(By.xpath("//*[@id='table_object2_table2_transposedTable']/tbody/tr")).size();
//		int columns=driver.findElements(By.xpath("//*[@id='table_object2_table2_transposedTable']/tbody/tr[1]/td")).size();
//		System.out.println("rows "+rows);
//		System.out.println("Columns "+columns);
//		for (int i = 0; i < rows; i++) {
//			for (int j = 0; j < columns; j++) {
//				String val=driver.findElement(By.xpath("//*[@id='table_object2_table2_transposedTable']/tbody/tr["+i+"]/td["+j+"]")).getText();
//				System.out.println(val+"in row "+rows+" in column "+ columns);
//			}
//			
		//}
	


	
		
	
	
	public static void initElements() {
		loginPage = new LoginPage(driver);
		accountDetails = new AccountDetails(driver);

	}

}
