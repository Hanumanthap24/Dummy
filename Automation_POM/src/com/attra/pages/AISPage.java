package com.attra.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.attra.driverscript.Driverscript;
import com.attra.utils.AppIndependant;

public class AISPage extends Driverscript
{
	@FindBy(id="user")
	private WebElement userEdit;
	
	@FindBy(name="pass")
	private WebElement passEdit;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement login;
	
	@FindBy(css="li#li-tickets>a")
	private WebElement ticketHover;
	
	By ticket_Locator=By.cssSelector("li#li-tickets>a");
	
	@FindBy(css="a#tickets-closed")
	private WebElement closedTickets;
	
	@FindBy(css="table.ticket-list.collection-as-table>tbody>tr")
	private List<WebElement> closedTicketCount;
	
	@FindBy(css="a#preferences")
	private WebElement userHover;
	
	By user_locator=By.cssSelector("a#preferences");
	
	@FindBy(css="a#preferences-logout")
	private WebElement logoutEle;
	
	@FindBy(xpath="//ul[@class='action-results']")
	private WebElement errMsg;
	
	public AISPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void setUserEdit(String user)
	{
		userEdit.sendKeys(user);
	}
	public String getUserEdit()
	{
		return userEdit.getAttribute("value");
	}
	
	public void setPassEdit(String pass)
	{
		passEdit.sendKeys(pass);
	}
	public String getPassEdit()
	{
		return passEdit.getAttribute("value");
	}
	public void loginClick()
	{
		login.click();
	}
	public void clickOnTickets()
	{
		ticketHover.click();
	}
	public void hoverOnTickets(WebDriver driver)
	{
		app.actionMouseHover(driver,ticket_Locator);
	}
	
	public void closedTicketsClick()
	{
		closedTickets.click();
	}
	public int getClosedTicketCount()
	{
		return closedTicketCount.size()-1;
	}
	
	public void hoverOnUser(WebDriver driver)
	{
		app.actionMouseHover(driver,user_locator);
	}
	
	public void logoutClick()
	{
		logoutEle.click();
	}
	
	public String getErrorMsg()
	{
		return errMsg.getText();
	}
	
	public String loginWithCredentials(String user,String pass)
	{
		Object obj=null;
		try
		{
			setUserEdit(user);
			obj=app.waitFor(driver,userEdit,60L,"text",user);
			System.out.println("Is UserName of AIS Page entered successfully ? "+obj.toString());
			setPassEdit(pass);
			obj=app.waitFor(driver,passEdit,60L,"text",pass);
			System.out.println("Is PassWord of AIS Page entered successfully ? "+obj.toString());
			loginClick();
			app.waitFor(driver,null,60L,"title","Open tickets");
			String title=driver.getTitle();
			if(title.equalsIgnoreCase("Open tickets"))
			{
				return "Pass";
			}
			else
			{
				return getErrorMsg();
			}
		}catch(Exception e)
		{
			return "Exception arised while Login in AIS_Page :: "+e.getMessage(); 
		}
	}
	
	public int countNoOfClosedTickets()
	{
		try
		{
			hoverOnTickets(driver);
			Thread.sleep(2000);
			closedTicketsClick();
			app.waitFor(driver,closedTickets,60L,"title","Closed tickets");
			return getClosedTicketCount();
		}catch(Exception e)
		{
			System.out.println(" Exception arised while countNoOfClosedTickets() :: "+e.getMessage());
			return -1;
		}
	}
	public String logoutOfPage()
	{
		try
		{
			hoverOnUser(driver);
			Thread.sleep(2000);
			logoutClick();
			app.waitFor(driver,null,60L,"title","Login");
			String title=driver.getTitle();
			if(title.equalsIgnoreCase("Login"))
			{
				return "Pass";
			}
			else
			{
				return "Fail";
			}
		}catch(Exception e)
		{
			return "Exception arised while Logout in AIS_Page :: "+e.getMessage();
		}
	}
	public void navigateAISPageAndPeform(String link)
	{
		driver.get(link);
		String userAIS=prop.getProperty("userNameAIS");
		String passAIS=prop.getProperty("passWordAIS");
		aispage=new AISPage(driver);
		String aisLoginResult=aispage.loginWithCredentials(userAIS, passAIS);
		System.out.println(" Login of AIS_Page :: "+aisLoginResult);
		int noOfClosedTickets=aispage.countNoOfClosedTickets();
		System.out.println("# of Closed Tickets :: "+noOfClosedTickets);
		String aisLogoutResult=aispage.logoutOfPage();
		System.out.println(" LogOut From AIS_Page :: "+aisLogoutResult);
		String result=aisLoginResult+aisLogoutResult;
		if(result.contains("Fail"))
		{
			data.setCellData(datasheet,"Sheet1","AIS",rowNumber,"Fail");
		}
		else
		{
			data.setCellData(datasheet,"Sheet1","AIS",rowNumber,"Pass");
		}
	}
}
