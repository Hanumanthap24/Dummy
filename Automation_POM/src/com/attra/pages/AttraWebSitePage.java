package com.attra.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.attra.driverscript.Driverscript;
import com.attra.utils.AppIndependant;

public class AttraWebSitePage extends Driverscript
{
	@FindBy(tagName="a")
	private List<WebElement> noOfLinks;
	
	public AttraWebSitePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public List<WebElement> linksInPage()
	{
		return this.noOfLinks;
	}
	
	By locator=null;
	
	public void linkCapture(String strSubElement)
	{
		try
		{
			String xpath1="//a[text()='";
			String xpath2="']";
			String finalXpath=xpath1+strSubElement+xpath2;

			locator=By.xpath(finalXpath);

			WebElement ele=driver.findElement(locator);
			app.actionMouseHover(driver, ele);
			String aboutId=data.getCellData(datasheet,"Sheet2",strSubElement,1);

			By locator_subElement=By.xpath(aboutId);

			List<WebElement> listOfSubElement=driver.findElements(locator_subElement);
			for(int k=0;k<listOfSubElement.size();k++)
			{
				String str=listOfSubElement.get(k).getText();
				data.setCellData(datasheet,sheetName,strSubElement,k+1,str);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void navigateToAttraLinkAndCapture(String link)
	{
		try
		{
			driver.get(link);
			List<WebElement> list=linksInPage();
			for(int j=0;j<list.size();j++)
			{
				String strSubElement=list.get(j).getText();
				switch (strSubElement.trim()) 
				{
				case "About Attra":
					homePage.linkCapture(strSubElement);
					break;
				case "Services":
					homePage.linkCapture(strSubElement);
					break;
				case "Domain":
					homePage.linkCapture(strSubElement);
					break;
				case "Products":
					homePage.linkCapture(strSubElement);
					break;
				case "Careers":
					homePage.linkCapture(strSubElement);
					break;
				case "News":
					homePage.linkCapture(strSubElement);
					break;
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
