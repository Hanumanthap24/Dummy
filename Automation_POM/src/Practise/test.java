package Practise;

import java.util.HashMap;

import org.openqa.selenium.By;

import com.attra.datatable.Datatable;
import com.attra.driverscript.Driverscript;
import com.attra.pages.AccountDetails;
import com.attra.pages.LoginPage;

public class test extends Driverscript {

	public static void main(String[] args) {
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
		int rows=driver.findElements(By.xpath("//*[@id='table_object2_table2_transposedTable']/tbody/tr")).size();
		int columns=driver.findElements(By.xpath("//*[@id='table_object2_table2_transposedTable']/tbody/tr[1]/td")).size();
		System.out.println("rows "+rows);
		System.out.println("Columns "+columns);
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				String val=driver.findElement(By.xpath("//*[@id='table_object2_table2_transposedTable']/tbody/tr["+i+"]/td["+j+"]")).getText();
				System.out.println(val+"in row "+rows+" in column "+ columns);
			}
			
		}
	


	
		
	}
	
	public static void initElements() {
		loginPage = new LoginPage(driver);
		accountDetails = new AccountDetails(driver);

	}

}
