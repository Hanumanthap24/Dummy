package com.attra.pages;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.attra.driverscript.Driverscript;
import com.attra.utils.WebDriverUtils;

public class LoginPage extends Driverscript {
    public  WebDriver driver;
	public LoginPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	@FindBy(xpath="//input[@id='userName']")
	private WebElement userName;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement password;
	
	@FindBy(id="submitButton")
	private WebElement submitButton;
	
	  public void login(HashMap<String , String> dataHashMap) {
		  
          getUserName().sendKeys(dataHashMap.get("UserName"));
          getPassword().sendKeys(dataHashMap.get("Password"));
          getSubmitButton().click();

          WebDriverUtils.expilicitWait(driver,
          driver.findElement(By.xpath("//*[@id='side-menu']//i[@class='fa fa-desktop']")), 30);

}

	public void logout() {
	
		
	}


}

	
	


