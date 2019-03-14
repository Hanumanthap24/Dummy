package com.liteUi.CMS;

import java.util.HashMap;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

import com.attra.datatable.Datatable;

import com.attra.driverscript.Driverscript;

import com.attra.pages.LoginPage;

import com.attra.utils.AppIndependant;

public class StoreDemographics extends Driverscript {

	@Test(enabled = true)

	public void transactionCodes() {

		HashMap<String, String> dataHashMap;

		dataHashMap = Datatable.getCellData(datasheet, "CMS_SD", 1);

		if (dataHashMap.get("RunStatus").equalsIgnoreCase("Y")) {

			try {

				Driverscript.runner(dataHashMap);

				driver.navigate().to(dataHashMap.get("Url"));

				initElements();

				loginPage.login(dataHashMap);

				Thread.sleep(30000);

				driver.navigate()
						.to("https://si28.visionplus.io/ds1o/#!/appView/Customer_Management_System_Data_Management");

				Thread.sleep(5000);

				WebElement ele = driver

						.findElement(By.xpath("//div[@class='animated fadeIn']/a[text() = 'Store Demographics']"));

				JavascriptExecutor js = (JavascriptExecutor) driver;

				js.executeScript("arguments[0].click();", ele);

				Thread.sleep(5000);

				driver.findElement(By.xpath("//*[contains(.,'Business Unit*')]/following::input[1]")).clear();

				driver.findElement(By.xpath("//*[contains(.,'Business Unit*')]/following::input[1]"))
						.sendKeys(dataHashMap.get("BusinessUnit"));

				driver.findElement(By.xpath("//*[contains(.,'Store*')]/following::input[1]"))
						.sendKeys(dataHashMap.get("Store"));

				driver.findElement(By.xpath("//button[contains(.,'Query')]")).click();

				Thread.sleep(5000);

				AppIndependant.getValuesToFile("StoreDemographics");

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
