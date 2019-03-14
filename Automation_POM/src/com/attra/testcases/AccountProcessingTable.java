package com.attra.testcases;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.attra.datatable.Datatable;
import com.attra.driverscript.Driverscript;
import com.attra.pages.AccountDetails;
import com.attra.pages.LoginPage;
import com.attra.utils.AppIndependant;
import com.attra.utils.WebDriverUtils;

public class AccountProcessingTable extends Driverscript {

	@Test(enabled = true)
	public void fetchDetailsAccountDetails() {
		HashMap<String, String> dataHashMap;
		HashMap<String, String> dataOutputHashmap = new HashMap<String, String>();
		dataHashMap = Datatable.getCellData(datasheet, "Sheet1", 2);
		if (dataHashMap.get("RunStatus").equalsIgnoreCase("Y")) {
			try {
				Driverscript.runner(dataHashMap);
				driver.get(dataHashMap.get("Url"));
				initElements();
				// Thread.sleep(10000);
				loginPage.login(dataHashMap);
				Thread.sleep(20000);
				
				System.out.println("exe========");
				
				driver.navigate().to("https://si28.visionplus.io/ds1o/#!/appView/Customer_Management_System_Parameter_Management");
				
				
				WebElement ele = driver
						.findElement(By.xpath("//div[@class='animated fadeIn']/a[text() = 'Account Processing Table']"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", ele);

				Thread.sleep(5000);
				driver.findElement(By.xpath("//a[contains(.,'Business Unit*')]/following::input[1]")).sendKeys(dataHashMap.get("BusinessUnit"));
				driver.findElement(By.xpath("//a[contains(.,'Product*')]/following::input[1]")).sendKeys(dataHashMap.get("Product"));
				driver.findElement(By.xpath("//a[contains(.,'Table Number*')]/following::input[1]")).sendKeys(dataHashMap.get("TableNumber"));
				driver.findElement(By.xpath("//button[contains(.,'Query')]")).click();
				
				Thread.sleep(5000);

				for (int i = 0; i <27; i++) {
					dataOutputHashmap = AccountDetails.getdefaulttext(dataOutputHashmap);
					dataOutputHashmap = AccountDetails.getdefaultInputText(dataOutputHashmap);
					Datatable.saveFetchedValuesToExcel(dataOutputSheet, AppIndependant.sheetname(driver), 1, 1, dataOutputHashmap);
					accountDetails.getnextGroup().click();
					Thread.sleep(10000);
					dataHashMap.clear();
				}

			} catch (Exception e) {
				System.out.println(dataHashMap.get("TcName") + " test case failed");
				e.printStackTrace();
				loginPage.logout();
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
