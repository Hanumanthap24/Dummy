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
import com.attra.utils.WebDriverUtils;

public class AccountDeatilsFetch extends Driverscript {

	@Test(enabled = true)
	public void fetchDetailsAccountDetails() {
		HashMap<String, String> dataHashMap;
		HashMap<String, String> dataOutputHashmap = new HashMap<String, String>();
		dataHashMap = Datatable.getCellData(datasheet, "Sheet1", 1);
		if (dataHashMap.get("RunStatus").equalsIgnoreCase("Y")) {
			try {
				Driverscript.runner(dataHashMap);
				driver.get(dataHashMap.get("Url"));
				initElements();
				// Thread.sleep(10000);
				loginPage.getUserName().sendKeys(dataHashMap.get("UserName"));
				loginPage.getPassword().sendKeys(dataHashMap.get("Password"));
				loginPage.getSubmitButton().click();
	
				WebDriverUtils.expilicitWait(driver,
						driver.findElement(By.xpath("//*[@id='side-menu']//i[@class='fa fa-desktop']")), 30);
				Actions actions = new Actions(driver);
				actions.moveToElement(driver.findElement(By.xpath("//*[@id='side-menu']//i[@class='fa fa-desktop']")))
						.click();
				Thread.sleep(3000);
				actions.click(driver
						.findElement(By.xpath("//*[@id='appMenuList']//a[contains(.,'Customer Management System')]")))
						.click();
				Thread.sleep(3000);
				actions.click(driver.findElement(By.xpath(
						"//*[@id='appMenuList']//a[contains(.,'Customer Management System')]/../ul/li[contains(.,'Data Management')]")))
						.click().build().perform();

				System.out.println("exe========");
				Thread.sleep(5000);
				WebElement ele = driver
						.findElement(By.xpath("//div[@class='animated fadeIn']/a[text() = 'Account Details']"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", ele);

				Thread.sleep(5000);
				accountDetails.getBusinessUnit().sendKeys(dataHashMap.get("BusinessUnit"));
				accountDetails.getAccountNumber().clear();
				accountDetails.getAccountNumber().sendKeys(dataHashMap.get("AccountNumber"));
				accountDetails.getProduct().sendKeys(dataHashMap.get("Product"));
				accountDetails.getBillingAcctInd().sendKeys(dataHashMap.get("BillingAcctInd"));
				accountDetails.getQuery().click();
				Thread.sleep(5000);

				for (int i = 0; i <27; i++) {
					dataOutputHashmap = AccountDetails.getdefaulttext(dataOutputHashmap);
					dataOutputHashmap = AccountDetails.getdefaultInputText(dataOutputHashmap);
					Datatable.saveFetchedValuesToExcel(dataOutputSheet, AccountDetails.sheetname(), 1, 1, dataOutputHashmap);
					accountDetails.getnextGroup().click();
					Thread.sleep(10000);
					dataHashMap.clear();
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
