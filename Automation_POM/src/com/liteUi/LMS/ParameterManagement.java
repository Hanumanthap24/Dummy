package com.liteUi.LMS;

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

import com.attra.utils.AppIndependant;

import com.attra.utils.WebDriverUtils;


public class ParameterManagement extends Driverscript {

	@Test(enabled = true)

	public void transactionCodes() {

		HashMap<String, String> dataHashMap;

		HashMap<String, String> dataOutputHashmap = new HashMap<String, String>();

		dataHashMap = Datatable.getCellData(datasheet, "LMS", 1);

		if (dataHashMap.get("RunStatus").equalsIgnoreCase("Y")) {

			try {

				Driverscript.runner(dataHashMap);

				driver.navigate().to(dataHashMap.get("Url"));

				initElements();

				loginPage.login(dataHashMap);

// Thread.sleep(10000);

				Thread.sleep(20000);

				/*
				 * 
				 * driver.navigate().to(
				 * 
				 * "https://si28.visionplus.io/ds1o/#!/appView/Loyalty_Management_System_Parameter_Management"
				 * 
				 * ); System.out.println("exe========"); Thread.sleep(5000);
				 * 
				 * driver.findElement(By.
				 * 
				 * xpath("//div[@class='animated fadeIn']/a[text() = 'Transaction Codes']")).
				 * 
				 * click();
				 * 
				 */

				driver.navigate().to("https://si28.visionplus.io/ds1o/#!/appView/M.LMS.GMMTAS.AS.GE.GET-LIST1");

				Thread.sleep(5000);

				driver.findElement(By.xpath("//*[contains(.,'BusinessUnit*')]/following::input[1]"))
						.sendKeys(dataHashMap.get("BusinessUnit"));

				driver.findElement(By.xpath("//*[contains(.,'TransactionCode*')]/following::input[1]"))
						.sendKeys(dataHashMap.get("TransactionCode"));

				driver.findElement(By.xpath("//button[contains(.,'Query')]")).click();

				Thread.sleep(5000);

//driver.findElement(By.xpath("//button[contains(.,'Query')]")).click();

				List<WebElement> eleLinks = driver.findElements(By.xpath("//*[@id='siblingLinks']/ul/li/a"));

				int link_size = eleLinks.size();

				System.out.println(link_size);

				Thread.sleep(10000);

				for (int i = 0; i <= link_size - 1; i++) {

					System.out.println(eleLinks.get(i).getText());

					dataOutputHashmap = AppIndependant.getdefaulttext(dataOutputHashmap, driver);

					dataOutputHashmap = AppIndependant.getdefaultInputText(dataOutputHashmap, driver);

					String strSheetName = eleLinks.get(i).getText().split("-")[1];

					Datatable.saveFetchedValuesToExcel(dataOutputSheet, strSheetName, 1, 1, dataOutputHashmap);

					eleLinks.get(i).click();

					eleLinks = driver.findElements(By.xpath("//*[@id='siblingLinks']/ul/li/a"));

					Thread.sleep(2000);

					dataHashMap.clear();

					driver.quit();

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

	}
}
