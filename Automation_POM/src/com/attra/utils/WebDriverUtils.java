package com.attra.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.attra.driverscript.Driverscript;

public class WebDriverUtils extends Driverscript{
	
	public static void expilicitWait(WebDriver driver,WebElement welElement,int sec) {
		
		WebDriverWait wait=new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.visibilityOf(welElement));
		
		
	}

}
