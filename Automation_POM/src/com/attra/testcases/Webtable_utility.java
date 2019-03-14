package com.attra.testcases;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.attra.datatable.Datatable;
import com.attra.driverscript.Driverscript;

public class Webtable_utility extends Driverscript {

///
	
	//*[@id='table_object2_table2']/preceding::table//tr[1]/th
	
	public static String[][] getTableHeaderData(WebDriver driver, String tableXpath) {

		String actual = "";
		int rows = driver.findElements(By.xpath(tableXpath + "/tr")).size();
		int columns = driver.findElements(By.xpath(tableXpath + "/tr[1]/th")).size();

		String[][] valuesFetched = new String[rows][columns];
		System.out.println("rows " + rows);
		System.out.println("Columns " + columns);
		for (int p = 1; p <= columns; p++) {
			for (int k = 1; k <= 1; k++) {
				String value = driver.findElement(By.xpath(tableXpath + "/tr[" + k + "]/th[" + p + "]"))
						.getAttribute("innerHTML");
				if (value.contains("select")) {
					WebElement element = driver
							.findElement(By.xpath(tableXpath + "/tr[" + k + "]/th[" + p + "]/select"));
					Select select = new Select(element);

					try {
						actual = select.getFirstSelectedOption().getText();
					} catch (Exception e) {
						actual = "";
					}

				} else if (value.contains("input")) {
					WebElement element = driver
							.findElement(By.xpath(tableXpath + "/tr[" + k + "]/th[" + p + "]/input"));
					actual = element.getAttribute("value");
				} else {
					WebElement element = driver
							.findElement(By.xpath(tableXpath + "/tr[" + k + "]/th[" + p + "]"));
					actual = element.getText();
				}

				valuesFetched[k-1][p-1] = actual;
			}

		}
		return valuesFetched;

	}


	
	public static String[][] getTableData(WebDriver driver, String tableXpath) {

		String actual = "";
		int rows = driver.findElements(By.xpath(tableXpath + "/tbody/tr")).size();
		int columns = driver.findElements(By.xpath(tableXpath + "/tbody/tr[1]/td")).size();

		String[][] valuesFetched = new String[rows][columns];
		System.out.println("rows " + rows);
		System.out.println("Columns " + columns);
		for (int p = 1; p <= columns; p++) {
			for (int k = 1; k <= rows; k++) {
				String value = driver.findElement(By.xpath(tableXpath + "/tbody/tr[" + k + "]/td[" + p + "]"))
						.getAttribute("innerHTML");
				if (value.contains("select")) {
					WebElement element = driver
							.findElement(By.xpath(tableXpath + "/tbody/tr[" + k + "]/td[" + p + "]/select"));
					Select select = new Select(element);

					try {
						actual = select.getFirstSelectedOption().getText();
					} catch (Exception e) {
						actual = "";
					}

				} else if (value.contains("input")) {
					WebElement element = driver
							.findElement(By.xpath(tableXpath + "/tbody/tr[" + k + "]/td[" + p + "]/input"));
					actual = element.getAttribute("value");
				} else {
					WebElement element = driver
							.findElement(By.xpath(tableXpath + "/tbody/tr[" + k + "]/td[" + p + "]"));
					actual = element.getText();
				}

				valuesFetched[k-1][p-1] = actual;
			}

		}
		return valuesFetched;

	}
	
	 


	public static void simpleTableDataCapture(WebDriver driver,String sheetName) {
	int counter=1;
	List<WebElement> allTables=driver.findElements(By.tagName("table"));
	for (Iterator iterator = allTables.iterator(); iterator.hasNext();) {
		WebElement webElement = (WebElement) iterator.next();
		String id=webElement.getAttribute("id");
		if(!(id.equals(""))) {
			
			try {
				String [][]values=Webtable_utility.getTableHeaderData(driver,"//*[@id='"+id+"']/preceding::table[1]/thead");
				String tableName=driver.findElement(By.xpath("//*[@id='"+id+"']/preceding::legend[1]")).getText();
				Datatable.ArrayToexcel(dataOutputSheet, sheetName.substring(0,10)+"_"+tableName+counter, values);
				String [][]values2=Webtable_utility.getTableData(driver,"//*[@id='"+id+"']");
				Datatable.ArrayToexcel(dataOutputSheet,sheetName.substring(0,10)+"_"+tableName+counter++, values2);
			} catch (Exception e) {
				System.out.println("Error in copying data to excel from webtable");
				e.printStackTrace();
			}
		}}
}
	
	public static void simpleTableWithOutHeadersDataCapture(WebDriver driver,String sheetName) {
		int counter=1;
		List<WebElement> allTables=driver.findElements(By.xpath("//div[contains(@id,'paginate')]/preceding::table[1]"));
		for (Iterator iterator = allTables.iterator(); iterator.hasNext();) {
			WebElement webElement = (WebElement) iterator.next();
			String id=webElement.getAttribute("id");
			if(!(id.equals(""))) {
				
				
				try {
					
					int numberOfpages=Integer.parseInt(driver.findElement(By.xpath("//div[@id='"+id+"_paginate']/span[@class='paginate_of']")).getText().split("of")[1].trim());
					String [][]values=Webtable_utility.getTableHeaderData(driver,"//*[@id='"+id+"']/preceding::table[1]/thead");
					String tableName=driver.findElement(By.xpath("//*[@id='"+id+"']/preceding::legend[1]")).getText();
					String tableSheetName=tableName+counter++;

					Datatable.ArrayToexcel(dataOutputSheet,sheetName.substring(0,10)+"_"+tableSheetName, values);

					for (int i = 1; i<=numberOfpages; i++) {
					String [][]values2=Webtable_utility.getTableData(driver,"//*[@id='"+id+"']");
					Datatable.ArrayToexcel(dataOutputSheet,sheetName.substring(0,10)+"_"+tableSheetName, values2);
					
				}
					
				} catch (Exception e) {
					System.out.println("Error in copying data to excel from webtable");
					e.printStackTrace();
				}
			}
	}
}


}
