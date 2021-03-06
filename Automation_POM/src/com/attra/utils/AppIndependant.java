package com.attra.utils;

import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.attra.datatable.Datatable;
import com.attra.driverscript.Driverscript;
import com.attra.testcases.Webtable_utility;

import dummy.Test1;

public class AppIndependant extends Driverscript {
	/*
	 * 
	 * 
	 * 
	 */
	// public static WebDriver driver;
	public static Alert alert = null;

	public static Select select = null;

	public void WriteResult(String strType, String strMessage) {
		Logger log = Logger.getLogger("reports");
		try {
			switch (strType.toLowerCase()) {
			case "pass":
				log.info(strMessage);
				break;
			case "fail":
				log.error(strMessage);
				break;
			case "warning":
				log.warn(strMessage);
				break;
			case "fatal":
				log.fatal(strMessage);
				break;
			default:
				System.out.println("Invalid report type provided.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Properties property(String FileName) {
		Properties prop = null;
		FileInputStream fin = null;
		try {
			fin = new FileInputStream(FileName);
			prop = new Properties();
			prop.load(fin);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}

	public String getDateTime(String currentDateTime) {
		String strDateTime = "";
		try {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat(currentDateTime);
			strDateTime = sdf.format(cal.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strDateTime;
	}

	public void takeScreenShot(WebDriver _driver, String path) {
		File srcFile = null;
		File destFile = null;
		try {
			srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			destFile = new File(path);
			FileUtils.copyFile(srcFile, destFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectClass(WebElement ele_Select, String value) {
		try {
			select = new Select(ele_Select);
			select.selectByVisibleText(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionClick(WebDriver driver, WebElement element) {
		try {
			action = new Actions(driver);
			action.moveToElement(element).click().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionClick(WebDriver driver, By locator) {
		try {
			action = new Actions(driver);
			action.moveToElement(driver.findElement(locator)).click().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionMouseHover(WebDriver driver, WebElement element) {
		try {
			action = new Actions(driver);
			action.moveToElement(element).build().perform();
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionMouseHover(WebDriver driver, By locator) {
		try {
			action = new Actions(driver);
			action.moveToElement(driver.findElement(locator)).build().perform();
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Object waitFor(WebDriver driver, WebElement ele, long timeOuts, String waitType, String text) {
		WebDriverWait wait = null;
		try {
			wait = new WebDriverWait(driver, timeOuts);
			if (waitType.equalsIgnoreCase("alert")) {
				Alert alert = wait.until(ExpectedConditions.alertIsPresent());
				return alert;
			}
			if (waitType.equalsIgnoreCase("title")) {
				return wait.until(ExpectedConditions.titleIs(text));
			}
			if (waitType.equalsIgnoreCase("select")) {
				return wait.until(ExpectedConditions.elementToBeSelected(ele));
			}
			if (waitType.equalsIgnoreCase("click")) {
				return wait.until(ExpectedConditions.elementToBeClickable(ele));
				// ele.click();
			}
			if (waitType.equalsIgnoreCase("text")) {
				//
				return wait.until(ExpectedConditions.textToBePresentInElementValue(ele, text));
			}
			if (waitType.equalsIgnoreCase("value")) {
				return wait.until(ExpectedConditions.textToBePresentInElement(ele, text));
			}
		} catch (Exception e) {
			System.out.println("Exception arised while waiting :: " + waitType + " :: " + e.getMessage());
			return null;
		}
		return wait;
	}

	public void robot(int keyCode) {
		try {
			robot = new Robot();
			robot.keyPress(keyCode);
			robot.keyRelease(keyCode);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void fileMove(String beforeMoving, String afterMoving) {
		File srcFile = null;
		File destFile = null;
		try {
			srcFile = new File(beforeMoving);
			destFile = new File(afterMoving);
			if (srcFile.isFile()) {
				FileUtils.moveFile(srcFile, destFile);
				System.out.println(" File Moved successfully to the path :: " + afterMoving);
			} else {
				System.out.println(" file Doesnot exists in :: " + beforeMoving);

			}
		} catch (Exception e) {
			System.out.println(" Exception arised in fileMove() :: " + e.getMessage());
		}
	}

	public void deleteFile(String path) {
		File file = null;
		try {
			file = new File(path);
			if (file.exists()) {
				FileUtils.forceDelete(file);
			} else {
				System.out.println("File doesnot exists in path to delete :: " + path);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * public static void main(String[] args) { AppIndependant a=new
	 * AppIndependant();
	 * //System.out.println("Sheet_"+a.getDateTime("dd:MMM:YY_hh:mm:ss"));
	 * a.fileMove("D:\\UserInout.xls",
	 * "C:\\Users\\yogesh.thimmappa\\Downloads\\UserInout(2).xls");
	 * //a.fileMove("C:\\Users\\yogesh.thimmappa\\Downloads\\UserInout(2).xls",
	 * "D:\\UserInout.xls");
	 * 
	 * }
	 */

	public static HashMap<String, String> getdefaultInputText(HashMap<String, String> hMap, WebDriver driver) {

		List<WebElement> list = driver
				.findElements(By.xpath("//input[@class='alpaca-control form-control']/parent::div/a"));

		String actual = "";

		for (int i = 0; i < list.size(); i++)

		{

			String header = list.get(i).getAttribute("innerHTML").replace("*", "").toString().split("<")[0];

			System.out.println(header);

			WebElement element = driver
					.findElement(By.xpath("//a[contains(text(), '" + header + "')]/parent::div/input"));

			try {

				actual = element.getAttribute("value");

			}

			catch (Exception e) {

				// actual = "";

			}

			hMap.put(header, actual);

		}

		return hMap;

	}

//  Function is created to select the data from list  -  drop down 

	public static HashMap<String, String> getdefaulttext(HashMap<String, String> hMap, WebDriver driver) {

		List<WebElement> list = driver
				.findElements(By.xpath("//select[@class='alpaca-control form-control']/parent::div/a"));

		String actual = "";

		for (int i = 0; i < list.size(); i++)

		{

			String header = list.get(i).getAttribute("innerHTML");

			System.out.println(header);

			WebElement ele = driver
					.findElement(By.xpath("//a[contains(text() ,'" + header + "')]/parent::div/select[1]"));

			Select select = new Select(ele);

			try {

				actual = select.getFirstSelectedOption().getText();

			}

			catch (Exception e) {

				actual = "";

			}

			hMap.put(header, actual);

		}

		return hMap;

	}
	
	public static void getTablevalue(HashMap<String, String> hMap, WebDriver driver,String SheetName,String sheetPath) throws Exception {

		List<WebElement> list = driver
				.findElements(By.xpath("//table[contains(@id,'table')]"));

		String actual = "";
		if(list.size()<1) {
			return;
			
		}

		for (int i = 0; i < list.size(); i++)

		{
			String id=list.get(i).getAttribute("id");
			String [][]values=Webtable_utility.getTableData(driver,"//table[@id='"+id+"']");
			Test1.ArrayToexcel(sheetPath,SheetName,values);
	

		}
	}
	

public static String sheetname(WebDriver driver)
{
	String sheet= driver.findElement(By.xpath("//div[@class='ibox-title {1}']/h4/span[@id='linkName']")).getText().replace("/", "_");
	//String[] str1 = sheet.split(" ");
	//String sheetName_dynamic = str1[3].concat(" ").concat(str1[5]);
	String sheetName_dynamic[] = sheet.split("-");
	String sheet1="";
	for (int i = 1; i < sheetName_dynamic.length; i++) {
		sheet1=sheet1+ sheetName_dynamic[i];
	}
	return sheet1;
}


public static void navigateAndCapture(int pageNumberToNavigate,int startfrom) throws Exception {
	
	HashMap<String, String> dataOutputHashmap=null;
	
	List<WebElement> eleLinks = driver.findElements(By.xpath("//*[@id='siblingLinks']/ul/li/a"));

	int link_size = eleLinks.size();


	Thread.sleep(10000);
	for (int K = 1; K <= pageNumberToNavigate - 1; K++) {

		System.out.println(eleLinks.get(startfrom).getText());

		dataOutputHashmap = AppIndependant.getdefaulttext(dataOutputHashmap, driver);

		dataOutputHashmap = AppIndependant.getdefaultInputText(dataOutputHashmap, driver);

		String strSheetName = eleLinks.get(startfrom).getText().split("-")[1];

		Datatable.saveFetchedValuesToExcel(dataOutputSheet, AppIndependant.sheetname(driver), 1, 1,
				dataOutputHashmap);

		Thread.sleep(1000);

		eleLinks.get(K).click();

		eleLinks = driver.findElements(By.xpath("//*[@id='siblingLinks']/ul/li/a"));

		Thread.sleep(2000);

		dataHashMap.clear();
		startfrom++;

	
}


}
public static void getValuesToFile(String strFileName){

    

    HashMap<String, String> dataOutputHashmap = new HashMap<String, String>();            

    try {

           List<WebElement> eleLinks = driver.findElements(By.xpath("//*[@id='siblingLinks']/ul/li/a"));            

           int link_size= eleLinks.size();                             

           for(int i=0;i<=link_size-1;i++){

                 eleLinks.get(i).click();

                 Thread.sleep(10000);

                 eleLinks = driver.findElements(By.xpath("//*[@id='siblingLinks']/ul/li/a"));

                 dataOutputHashmap = AppIndependant.getdefaulttext(dataOutputHashmap, driver);

               dataOutputHashmap = AppIndependant.getdefaultInputText(dataOutputHashmap,driver);

               String strSheetName = eleLinks.get(i).getText();//.split("-")[1];

               Datatable.saveFetchedValuesToExcel(strFileName, strSheetName, 1, 1, dataOutputHashmap);

                 Thread.sleep(2000);

               dataOutputHashmap.clear();

           }

    } catch (InterruptedException e) {

           //  TODO Auto-generated catch block

           e.printStackTrace();

    }

}

public static String clickLeftMenu(WebDriver driver, List<WebElement> eleLinks, int k) throws Exception {


	WebElement element = eleLinks.get(k);


	String str = element.getText();


	if (k > 0) {


	 


	element.click();


	Thread.sleep(10000);


	return str;


	 


	} else {


	return str;


	}


	 


	}



}
