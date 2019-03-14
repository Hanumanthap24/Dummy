package com.liteUi.CMS;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.attra.datatable.Datatable;
import com.attra.driverscript.Driverscript;
import com.attra.utils.AppIndependant;

public class ParameterManagement extends Driverscript {                
                
	public  static WebDriver driver;
	
	public WebDriver getDriver() {
        return driver;
    }
	
	public ParameterManagement(WebDriver driver) {
		ParameterManagement.driver=driver;
		PageFactory.initElements(driver, this);
	}
	          
	@FindBy(xpath="//a[contains(.,'Business Unit')]/following::input[1]")
	static WebElement BusinessUnit;
	public static WebElement getBusinessUnit() {
		return BusinessUnit;
    }
	
	@FindBy(xpath="//a[contains(.,'Product*')]/following::input[1]")
	static WebElement Product;
	public static WebElement getProduct() {
		return Product;
	}
	
	@FindBy(xpath="//a[contains(.,'Tax Table')]/following::input[1]")
	static WebElement TaxTablefield;
	public static WebElement getTaxTablefield() {
		return TaxTablefield;
	}
		
	@FindBy(xpath="//a[contains(.,'Rate Index Identification Number')]/following::input[1]")
	static WebElement RateIndexIdentificationNumber;
	public static WebElement getRateIndexNumber() {
		return RateIndexIdentificationNumber;
	}
	
	@FindBy(xpath="//button[contains(.,'Query')]")
	static WebElement query;
	public static WebElement getQuery() {
		return query;
    }
	
	@FindBy(xpath="//a[contains(.,'Insurance Table Number')]/following::input[1]")
	static WebElement InsuranceTableNumber;
	public static WebElement getInsuranceTableNumber() {
		return InsuranceTableNumber;
	}
	
	@FindBy(xpath="//a[contains(.,'Associated Insurance Product')]/following::input[1]")
	static WebElement AsctdInsuranceProduct;
	public static WebElement getAsctdInsuranceProduct() {
		return AsctdInsuranceProduct;
	}
	
	@FindBy(xpath="//a[contains(.,'Table Number')]/following::input[1]")
	static WebElement TableNumber;
	public static WebElement getTableNumber() {
		return TableNumber;
	}
	
	@FindBy(xpath="//a[contains(.,'Processing Control Table ID')]/following::input[1]")
	static WebElement ProcessingControlTableID;
	public static WebElement getProcessingControlTableID() {
		return TableNumber;
	}
	
	@FindBy(xpath="a[contains(.,'Transaction Code')]/following::input[1]")
	static WebElement TransactionCode;
	public static WebElement getTransactionCode() {
		return TransactionCode;
	}		
	
	
	public void getAccountProcessingTableDetails() {
        HashMap<String, String> dataHashMap;
        dataHashMap = Datatable.getCellData(datasheet, "Sheet1", 2);
        if (dataHashMap.get("RunStatus").equalsIgnoreCase("Y"))
    	{
        	try {               
                Thread.sleep(25000);
                driver.navigate().to("https://si28.visionplus.io/ds1o/#!/appView/Customer_Management_System_Parameter_Management");
                Thread.sleep(10000);                
                WebElement ele = driver.findElement(By.xpath("//div[@class='animated fadeIn']/a[text() = 'Account Processing Table']"));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", ele);
                Thread.sleep(5000);
                getBusinessUnit().clear();
                getBusinessUnit().sendKeys(dataHashMap.get("BusinessUnit"));
                getProduct().clear();
                getProduct().sendKeys(dataHashMap.get("Product"));
                getTableNumber().clear();
                getTableNumber().sendKeys(dataHashMap.get("TableNumber"));
                getQuery().click();
                Thread.sleep(1000);                
	            AppIndependant.getValuesToFile("AccountProcessingTable");
            } 
        	catch (Exception e) {
				System.out.println(dataHashMap.get("TcName") + " test case failed");
				e.printStackTrace();
				driver.quit();
            }
      	}

     }
	
	public void getInsuranceTableDetails() {
        HashMap<String, String> dataHashMap;
        dataHashMap = Datatable.getCellData(datasheet, "Sheet1", 3);
        if (dataHashMap.get("RunStatus").equalsIgnoreCase("Y"))
    	{
        	try {               
                Thread.sleep(5000);
                driver.navigate().to("https://si28.visionplus.io/ds1o/#!/appView/Customer_Management_System_Parameter_Management");
                Thread.sleep(10000);                
                WebElement ele = driver.findElement(By.xpath("//div[@class='animated fadeIn']/a[text() = 'Insurance Table']"));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", ele);
                Thread.sleep(5000);
                getBusinessUnit().clear();
                getBusinessUnit().sendKeys(dataHashMap.get("BusinessUnit"));
                getProduct().clear();
                getProduct().sendKeys(dataHashMap.get("Product"));
                getInsuranceTableNumber().clear();
                getInsuranceTableNumber().sendKeys(dataHashMap.get("InsuranceTableNumber"));
                getAsctdInsuranceProduct().clear();
                getAsctdInsuranceProduct().sendKeys(dataHashMap.get("AsctdInsuranceProduct"));
                getQuery().click();
                Thread.sleep(3000);                
	            AppIndependant.getValuesToFile("InsuranceTable");
            } 
        	catch (Exception e) {
				System.out.println(dataHashMap.get("TcName") + " test case failed");
				e.printStackTrace();
				driver.quit();
            }
      	}

     }
	
	public void getFeeTableDetails() {
        HashMap<String, String> dataHashMap;
        dataHashMap = Datatable.getCellData(datasheet, "Sheet1", 4);
        if (dataHashMap.get("RunStatus").equalsIgnoreCase("Y"))
    	{
        	try {
                Thread.sleep(5000);
                driver.navigate().to("https://si28.visionplus.io/ds1o/#!/appView/Customer_Management_System_Parameter_Management");
                Thread.sleep(10000);                
                WebElement ele = driver.findElement(By.xpath("//div[@class='animated fadeIn']/a[text() = 'Fee Table']"));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", ele);
                Thread.sleep(5000);                
                getBusinessUnit().clear();
                getBusinessUnit().sendKeys(dataHashMap.get("BusinessUnit"));
                getProduct().clear();
                getProduct().sendKeys(dataHashMap.get("Product"));
                getTableNumber().clear();
                getTableNumber().sendKeys(dataHashMap.get("TableNumber"));
                getQuery().click();
                Thread.sleep(3000);                
                AppIndependant.getValuesToFile("FeeTable");
            } 
        	catch (Exception e) {
				System.out.println(dataHashMap.get("TcName") + " test case failed");
				e.printStackTrace();
				driver.quit();
            }
      	}

     } 
	
	public void getTaxTableDetails() {
        HashMap<String, String> dataHashMap;
        dataHashMap = Datatable.getCellData(datasheet, "Sheet1", 5);
        if (dataHashMap.get("RunStatus").equalsIgnoreCase("Y"))
    	{
        	try {
                Thread.sleep(5000);
                driver.navigate().to("https://si28.visionplus.io/ds1o/#!/appView/Customer_Management_System_Parameter_Management");
                Thread.sleep(10000);                
                WebElement ele = driver.findElement(By.xpath("//div[@class='animated fadeIn']/a[text() = 'Tax Table']"));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", ele);
                Thread.sleep(5000);                
                getBusinessUnit().clear();
                getBusinessUnit().sendKeys(dataHashMap.get("BusinessUnit"));
                getProduct().clear();
                getProduct().sendKeys(dataHashMap.get("Product"));
                getTaxTablefield().clear();
                getTaxTablefield().sendKeys(dataHashMap.get("TaxTable"));
                getQuery().click();
                Thread.sleep(3000);                
	            AppIndependant.getValuesToFile("TaxTable");
            } 
        	catch (Exception e) {
				System.out.println(dataHashMap.get("TcName") + " test case failed");
				e.printStackTrace();
				driver.quit();
            }
      	}

     }
	
	public void getRateIndexTableDetails() {
        HashMap<String, String> dataHashMap;
        dataHashMap = Datatable.getCellData(datasheet, "Sheet1", 6);
        if (dataHashMap.get("RunStatus").equalsIgnoreCase("Y"))
    	{
        	try {
                Thread.sleep(5000);
                driver.navigate().to("https://si28.visionplus.io/ds1o/#!/appView/Customer_Management_System_Parameter_Management");
                Thread.sleep(10000);                
                WebElement ele = driver.findElement(By.xpath("//div[@class='animated fadeIn']/a[text() = 'Rate Index Table']"));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", ele);
                Thread.sleep(5000);                
                getBusinessUnit().clear();
                getBusinessUnit().sendKeys(dataHashMap.get("BusinessUnit"));
                getRateIndexNumber().clear();
                getRateIndexNumber().sendKeys(dataHashMap.get("RateIndex"));
                getQuery().click();
                Thread.sleep(3000);                
	            AppIndependant.getValuesToFile("RateIndexTable");
            } 
        	catch (Exception e) {
				System.out.println(dataHashMap.get("TcName") + " test case failed");
				e.printStackTrace();
				driver.quit();
            }
      	}

     }
	
	public void getStateUsuryDetails() {
        HashMap<String, String> dataHashMap;
        dataHashMap = Datatable.getCellData(datasheet, "Sheet1", 7);
        if (dataHashMap.get("RunStatus").equalsIgnoreCase("Y"))
    	{
        	try {
                Thread.sleep(5000);
                driver.navigate().to("https://si28.visionplus.io/ds1o/#!/appView/Customer_Management_System_Parameter_Management");
                Thread.sleep(10000);                
                WebElement ele = driver.findElement(By.xpath("//div[@class='animated fadeIn']/a[text() = 'State Usury']"));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", ele);
                Thread.sleep(5000);                
                getBusinessUnit().clear();
                getBusinessUnit().sendKeys(dataHashMap.get("BusinessUnit"));
                getQuery().click();
                Thread.sleep(3000);                
	            AppIndependant.getValuesToFile("StateUsury");
            } 
        	catch (Exception e) {
				System.out.println(dataHashMap.get("TcName") + " test case failed");
				e.printStackTrace();
				driver.quit();
            }
      	}

     }
	
	public void getProcessingControlTableDetails() {
		HashMap<String, String> dataHashMap;
		dataHashMap = Datatable.getCellData(datasheet, "Sheet1", 8);
		if (dataHashMap.get("RunStatus").equalsIgnoreCase("Y")) {
			try {
				Thread.sleep(5000);
				driver.navigate().to("https://si28.visionplus.io/ds1o/#!/appView/Customer_Management_System_Parameter_Management");
				Thread.sleep(5000);
				WebElement ele = driver.findElement(By.xpath("//div[@class='animated fadeIn']/a[text() = 'Processing Control Table']"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", ele);
				Thread.sleep(5000);
				getBusinessUnit().clear();
				getBusinessUnit().sendKeys(dataHashMap.get("BusinessUnit"));
				getProduct().clear();
				getProduct().sendKeys(dataHashMap.get("Product"));
				getProcessingControlTableID().clear();
				getProcessingControlTableID().sendKeys(dataHashMap.get("ProcessingControlTableID"));
				getQuery().click();				
				Thread.sleep(3000);
				AppIndependant.getValuesToFile("ProcessingControlTable");
			} catch (Exception e) {
				System.out.println(dataHashMap.get("TcName") + " test case failed");
				e.printStackTrace();
				driver.quit();
			}
		}
	}
	
	public void getMonetaryTransactionControlDetails () {
		HashMap<String, String> dataHashMap;
		dataHashMap = Datatable.getCellData(datasheet, "Sheet1", 9);
		if (dataHashMap.get("RunStatus").equalsIgnoreCase("Y")) {
			try {
				Thread.sleep(5000);
				driver.navigate().to("https://si28.visionplus.io/ds1o/#!/appView/Customer_Management_System_Parameter_Management");
				Thread.sleep(10000);
				WebElement ele = driver.findElement(By.xpath("//div[@class='animated fadeIn']/a[text() = 'Monetary Transaction Control']"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", ele);
				Thread.sleep(5000);
				getBusinessUnit().clear();
				getBusinessUnit().sendKeys(dataHashMap.get("BusinessUnit"));
				getTransactionCode().clear();
				getTransactionCode().sendKeys(dataHashMap.get("TransactionCode"));
				driver.findElement(By.xpath("//button[contains(.,'Query')]")).click();
				Thread.sleep(3000);
				AppIndependant.getValuesToFile("MonetaryTransactionControl");
			}catch (Exception e) {
				System.out.println(dataHashMap.get("TcName") + " test case failed");
				e.printStackTrace();
				driver.quit();
			}
		}
	}

 
}
