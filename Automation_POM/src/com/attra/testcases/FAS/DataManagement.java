package com.attra.testcases.FAS;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.attra.datatable.Datatable;
import com.attra.driverscript.Driverscript;
import com.attra.pages.FASPage;
import com.attra.pages.LoginPage;
import com.attra.utils.AppIndependant;

public class DataManagement extends Driverscript {
	
	@Test
	public void batchAuthorizationDetailLog() throws Exception {
		
		HashMap<String, String> dataHashMap;
		HashMap<String, String> dataOutputHashMap = new HashMap<String, String>();
		
		dataHashMap = Datatable.getCellData(datasheet, "Sheet1", 1);
		if(dataHashMap.get("RunStatus").equalsIgnoreCase("Y")) {
			
			Driverscript.runner(dataHashMap);
			driver.get(dataHashMap.get("Url"));
			initElements();
			loginPage.login(dataHashMap);
			Thread.sleep(5000);
			fasPage.navigateToDataManagement();
			fasPage.clickOnBatchAuthorizationDetailLog();
			fasPage.enterBatchAuthorizationDetailLog("0");
			fasPage.clickOnQueryButton();
			
			dataOutputHashMap = AppIndependant.getdefaultInputText(dataOutputHashMap, driver);
			dataOutputHashMap = AppIndependant.getdefaulttext(dataOutputHashMap, driver);
			
			Datatable.saveFetchedValuesToExcel(dataOutputSheet, FASPage.sheetname(), 1, 1, dataOutputHashMap);
		}
	}
	
	public void initElements() {
		loginPage = new LoginPage(driver);
		fasPage = new FASPage(driver);
	}
}