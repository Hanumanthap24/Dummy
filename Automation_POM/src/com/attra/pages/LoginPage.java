package com.attra.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.attra.driverscript.Driverscript;

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

}

	
	


