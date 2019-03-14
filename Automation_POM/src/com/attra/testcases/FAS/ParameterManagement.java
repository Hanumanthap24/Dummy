package com.attra.testcases.FAS;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.attra.datatable.Datatable;
import com.attra.driverscript.Driverscript;
import com.attra.pages.AccountDetails;
import com.attra.pages.LoginPage;
import com.attra.testcases.Webtable_utility;
import com.attra.utils.AppIndependant;
import com.attra.utils.WebDriverUtils;

public class ParameterManagement extends Driverscript {
	
	@Test(enabled = true)
	public void ProcessingParametersSystem() {
		HashMap<String, String> dataHashMap;
		HashMap<String, String> dataOutputHashmap = new HashMap<String, String>();
		dataHashMap = Datatable.getCellData(datasheet, "Sheet1",10 );
		if (dataHashMap.get("RunStatus").equalsIgnoreCase("Y")) {
			try {
				Driverscript.runner(dataHashMap);
				driver.get(dataHashMap.get("Url"));
				initElements();				
				loginPage.login(dataHashMap);
				Thread.sleep(30000);
				driver.navigate().to("https://si28.visionplus.io/ds1o/#!/appView/Financial_Authorisation_System_Parameter_Management");
				Thread.sleep(12000);
				WebElement ele = driver
						.findElement(By.xpath("//div[@class='animated fadeIn']/a[text() ='Processing Parameters-System']"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", ele);	
//				driver.findElement(By.xpath("//button[contains(.,'Query')]")).click();
				Thread.sleep(5000);				
				driver.findElement(By.xpath("//button[contains(.,'Query')]")).click();
				Thread.sleep(5000);
				List<WebElement> eleLinks = driver.findElements(By.xpath("//*[@id='siblingLinks']/ul/li/a"));
				int link_size = eleLinks.size();
				System.out.println(link_size);
				
				Thread.sleep(10000);
				for (int K = 0; K < link_size; K++) {
					List<WebElement> eleLinks2 = driver.findElements(By.xpath("//*[@id='siblingLinks']/ul/li/a"));
					String Sheetname = AppIndependant.clickLeftMenu(driver, eleLinks2, K);
					dataOutputHashmap = AppIndependant.getdefaulttext(dataOutputHashmap, driver);
					dataOutputHashmap = AppIndependant.getdefaultInputText(dataOutputHashmap, driver);
//	dataOutputHashmap = AppIndependant.getTableData
					Datatable.saveFetchedValuesToExcel(dataOutputSheet, Sheetname, 1, 1, dataOutputHashmap);
					Webtable_utility.simpleTableDataCapture(driver, Sheetname);
					Thread.sleep(2000);
					dataOutputHashmap.clear();
				}
			} catch (Exception e) {
				System.out.println(dataHashMap.get("TcName") + " test case failed");
				e.printStackTrace();
				driver.quit();
			}

		} else {

		}

	}

	public void initElements() {
		loginPage = new LoginPage(driver);
		accountDetails = new AccountDetails(driver);

	}

}



