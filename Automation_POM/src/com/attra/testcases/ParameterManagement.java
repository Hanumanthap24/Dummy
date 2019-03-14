package com.attra.testcases;

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

import dummy.Test1;

public class ParameterManagement extends Driverscript {

	@Test(enabled = true)

	public void ProcessingParametersSystem() {

		HashMap<String, String> dataHashMap;

		HashMap<String, String> dataOutputHashmap = new HashMap<String, String>();

		dataHashMap = Datatable.getCellData(datasheet, "Sheet1", 1);

		if (dataHashMap.get("RunStatus").equalsIgnoreCase("Y")) {

			try {
				Driverscript.runner(dataHashMap);
				driver.get(dataHashMap.get("Url"));
				initElements();
				loginPage.login(dataHashMap);
				Thread.sleep(30000);

//Commeted now 

// WebDriverUtils.expilicitWait(driver,

// driver.findElement(By.xpath("//*[@id='side-menu']//i[@class='fa fa-desktop']")), 30);

// Actions actions = new Actions(driver);

// actions.moveToElement(driver.findElement(By.xpath("//*[@id='side-menu']//i[@class='fa fa-desktop']")))

// .click();

// Thread.sleep(3000);

// actions.click(driver

// .findElement(By.xpath("//*[@id='appMenuList']//a[contains(.,'Financial Authorisation System')]")))

// .click();

// Thread.sleep(3000);

// actions.click(driver.findElement(By.xpath(

// "//*[@id='appMenuList']//a[contains(.,'Financial Authorisation System')]/../ul/li[contains(.,'Parameter Management')]")))

// .click().build().perform();

				driver.navigate().to(
						"https://si28.visionplus.io/ds1o/#!/appView/Financial_Authorisation_System_Parameter_Management");

				System.out.println("exe========");

				Thread.sleep(12000);

				WebElement ele = driver

						.findElement(
								By.xpath("//div[@class='animated fadeIn']/a[text() ='Processing Parameters-System']"));

				JavascriptExecutor js = (JavascriptExecutor) driver;

				js.executeScript("arguments[0].click();", ele);

// Thread.sleep(5000);

// ParameterManagement.getBusinessUnit().sendKeys(dataHashMap.get("BusinessUnit"));

// ParameterManagement.getAccountNumber().clear();

// ParameterManagement.getAccountNumber().sendKeys(dataHashMap.get("AccountNumber"));

// ParameterManagement.getProduct().sendKeys(dataHashMap.get("Product"));

// FinancialAuthorisationSystem.getBillingAcctInd().sendKeys(dataHashMap.get("BillingAcctInd"));

				driver.findElement(By.xpath("//button[contains(.,'LIST')]")).click();

				Thread.sleep(5000);

// for (int i = 0; i < 27; i++) {

// dataOutputHashmap = AppIndependant.getdefaulttext(dataOutputHashmap,driver);

// dataOutputHashmap = AppIndependant.getdefaultInputText(dataOutputHashmap,driver);

// Datatable.saveFetchedValuesToExcel(dataOutputSheet, AppIndependant.sheetname(driver), 1, 1,

// dataOutputHashmap);

// driver.findElement(By.xpath("//button[contains(.,'Next Group')]")).click();
				List<WebElement> eleLinks = driver.findElements(By.xpath("//*[@id='siblingLinks']/ul/li/a"));
	            

	            int link_size= eleLinks.size();

	            System.out.println(link_size);

	            Thread.sleep(10000);

	            int j=1;

	            for(int K=j;K<=link_size-1;K++) {

	            
	System.out.println(eleLinks.get(K).getText());

	            
	dataOutputHashmap = AppIndependant.getdefaulttext(dataOutputHashmap,driver);
    dataOutputHashmap = AppIndependant.getdefaultInputText(dataOutputHashmap,driver);
	                
	                

//	                 dataOutputHashmap = AppIndependant.getTableData

	                String strSheetName = eleLinks.get(K).getText().split("-")[1];

	                Datatable.saveFetchedValuesToExcel(dataOutputSheet, AppIndependant.sheetname(driver), 1, 1,dataOutputHashmap);

	                Thread.sleep(1000);

	                eleLinks.get(K).click();

	            
	j++;

	            
	eleLinks = driver.findElements(By.xpath("//*[@id='siblingLinks']/ul/li/a"));
	            

	                Thread.sleep(2000);

	                   dataHashMap.clear();
				
			
	            }} catch (Exception e) {

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
