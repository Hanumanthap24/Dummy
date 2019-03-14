package com.attra.testcases;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.attra.datatable.Datatable;
import com.attra.driverscript.Driverscript;
import com.attra.utils.AppIndependant;

public class Accountprocessing {
	HashMap<String, String> dataHashMap;
	 
	HashMap<String, String> dataOutputHashmap = new HashMap<String, String>();
	 
	dataHashMap = Datatable.getCellData(datasheet, "LMS", 1);
	 
	if (dataHashMap.get("RunStatus").equalsIgnoreCase("Y")){
	 
	try {
	 
	Driverscript.runner(dataHashMap);
	 
	driver.navigate().to(dataHashMap.get("Url"));

	initElements();
	 
	loginPage.login(dataHashMap);
	 
	// Thread.sleep(10000);
	 
	Thread.sleep(20000);
	 
	driver.navigate().to("https://si28.visionplus.io/ds1o/#!/appView/Loyalty_Management_System_Parameter_Management");
	 
	System.out.println("exe========");

	Thread.sleep(5000);
	 
	WebElement ele = driver
	 
	.findElement(By.xpath("//div[@class='animated fadeIn']/a[text() = 'Transaction Codes']"));
	 
	JavascriptExecutor js = (JavascriptExecutor) driver;
	 
	js.executeScript("arguments[0].click();", ele);

	Thread.sleep(5000);
	 
	transactionCodesPage.getBusinessUnit().sendKeys(dataHashMap.get("BusinessUnit"));
	 
	transactionCodesPage.getTransactionCode().sendKeys(dataHashMap.get("TransactionCode"));
	 
	transactionCodesPage.getQuery().click();

	Thread.sleep(5000);

	 
	for (int i = 0; i <2; i++) {
	 
	dataOutputHashmap = AppIndependant.getdefaulttext(dataOutputHashmap,driver);
	 
	dataOutputHashmap = AppIndependant.getdefaultInputText(dataOutputHashmap,driver);
	 
	Datatable.saveFetchedValuesToExcel(dataOutputSheet, transactionCodesPage.sheetname(driver), 1, 1, dataOutputHashmap);

	Thread.sleep(10000);
	 
	transactionCodesPage.getnextGroup().click();
	 
	dataHashMap.clear();

	}

	 
	} catch (Exception e) {
	 
	System.out.println(dataHashMap.get("TcName")+ " test case failed");
	 
	e.printStackTrace();
	 
	driver.quit();

	}

	 
	} else {


	}


	}
	 


}
	