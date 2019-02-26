package com.attra.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.attra.driverscript.Driverscript;

public class HomePage extends Driverscript
{
	public static ArrayList<String> arrayOfLinks=new ArrayList<String>();
	
	@FindBy(tagName="a")
	private List<WebElement> noOfLinks;


	public HomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}

	public List<WebElement> linksInPage()
	{
		return this.noOfLinks;
	}
	public void linkCapture(String strSubElement)
	{
		try
		{
			String xpath1="//a[text()='";
			String xpath2="']";
			String finalXpath=xpath1+strSubElement+xpath2;

			By locator=By.xpath(finalXpath);

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
	public void navigateToLinks()
	{
		try
		{
			List<WebElement> listOfLinks=linksInPage();
			int size=listOfLinks.size();
			for(int i=0;i<size;i++)
			{
				WebElement element=listOfLinks.get(i);
				String strElement=element.getAttribute("href");
				//System.out.println(strElement);
				arrayOfLinks.add(strElement);
			}
			for(String link:arrayOfLinks)
			{
				switch (link)
				{
				/*case "http://www.attra.com/":
					attraPage=new AttraWebSitePage(driver);
					attraPage.navigateToAttraLinkAndCapture(link);
					break;
					
				case "https://ais.attra.com/":
					aispage=new AISPage(driver);
					aispage.navigateAISPageAndPeform(link);
					break;*/

				case "http://ams.attragroup.com/timemanager/":
					amsPage=new AMSPage(driver);
					amsPage.navigateToAMSPageAndPerform(link);
					break;
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}