package com.attra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.attra.driverscript.Driverscript;

public class FASPage extends Driverscript {
	
	public  static WebDriver driver;

    public FASPage(WebDriver driver) {
    	this.driver = driver;
    	PageFactory.initElements(driver, this);
    }

	
	@FindBy(xpath="//*[@id='side-menu']//i[@class='fa fa-desktop']")
	private WebElement desktopIcon;
	
	
	@FindBy(xpath="//*[@id='appMenuList']//a[contains(.,'Financial Authorisation System')]")
	private WebElement FinancialAuthorisationSystem;
	
	@FindBy(xpath="//*[@id='appMenuList']//a[contains(.,'Financial Authorisation System')]/../ul/li[contains(.,'Data Management')]")
	private WebElement FAS_DataManagement;
	
	@FindBy(xpath="//div[@class='animated fadeIn']/a[text() = 'Batch Authorization Detail Log']")
	private WebElement BatchAuthorizationDetailLog; 
	
	@FindBy(xpath="//a[text()='KEY']/parent::div/input")
	private WebElement keyField;
	
	@FindBy(xpath="//button[text()='Query']")
	private WebElement queryButton;
	
	
	public void navigateToDataManagement() throws Exception {
		Actions actions = new Actions(driver);

		
		actions.moveToElement(desktopIcon).click();
		
		Thread.sleep(3000);
		
		actions.moveToElement(FinancialAuthorisationSystem).click();
		
		Thread.sleep(3000);
		
		actions.moveToElement(FAS_DataManagement).click().build().perform();
		actions.moveToElement(FAS_DataManagement).click().build().perform();	
	}
	
	public void clickOnBatchAuthorizationDetailLog() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", BatchAuthorizationDetailLog);
	}
	
	public void enterBatchAuthorizationDetailLog(String value) {
		keyField.clear();
		keyField.sendKeys(value);
	}
	
	public void clickOnQueryButton() {
		queryButton.click();
	}
	
	public static String sheetname()
	{
		String sheet= driver.findElement(By.xpath("//div[@class='ibox-title {1}']/h4/span[@id='linkName']")).getText();
	//	String[] str1 = sheet.split("-");
	//	String sheetName = str1[0].concat(" ").concat(str1[1]);
		String sheetName_dynamic[] = sheet.split("-");
		String sheet1="";
		for (int i = 1; i < sheetName_dynamic.length; i++) {
			sheet1=sheet1+ sheetName_dynamic[i];
		}
		return sheet1;
	}

}
