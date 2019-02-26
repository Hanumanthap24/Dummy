package com.attra.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.attra.driverscript.Driverscript;

public class AMSPage extends Driverscript
{
	@FindBy(css="a#ctl00_LoginStatus2")
	private WebElement loginClickEle;

	@FindBy(css="input#ctl00_maincontent_Login1_UserName")
	private WebElement userEdit;

	@FindBy(css="input#ctl00_maincontent_Login1_Password")
	private WebElement passEdit;

	@FindBy(css="input#ctl00_maincontent_Login1_LoginButton")
	private WebElement loginBtn;

	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logoutBtn;

	@FindBy(xpath="(//a[@class='ctl00_MainMenu_1 menuItem ctl00_MainMenu_3'])[2]")
	WebElement attendanceBtn;
	
	By attendanceLocator=By.xpath("(//a[@class='ctl00_MainMenu_1 menuItem ctl00_MainMenu_3'])[2]");
	
	By vw_attendanceLocator=By.xpath("(//a[@class='ctl00_MainMenu_1 menuPopupItem ctl00_MainMenu_6'])[6]");

	@FindBy(xpath="(//a[@class='ctl00_MainMenu_1 menuPopupItem ctl00_MainMenu_6'])[6]")
	WebElement vw_attendanceBtn;

	@FindBy(css="input#ctl00_maincontent_txtdtFrom")
	private WebElement fromDate;

	@FindBy(css="input#ctl00_maincontent_txtdtTo")
	private WebElement toDate;

	@FindBy(css="input#ctl00_maincontent_AddButton")
	private WebElement processBtn;
	
	@FindBy(css="input#ctl00_maincontent_Button1")
	private WebElement exportToPDf;
	
	
	@FindBy(css="input#ctl00_maincontent_btnExportGrid")
	private WebElement exportToExcel;
	
	//@FindBy(xpath="(//span[@class='errormsg'])[1]")
	//private WebElement errorMsgText;

	/*@FindBy(css="a#ctl00_LoginStatus2")
	private WebElement logout;*/
	@FindBy(xpath="//td[@class='tdback']")
	private WebElement moveCursor;

	public AMSPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void loginClick()
	{
		loginClickEle.click();
	}
	public void setUserEdit(String user)
	{
		userEdit.sendKeys(user);
	}
	public String getPassEdit() 
	{
		return passEdit.getAttribute("value");
	}
	public void setPassEdit(String pass) 
	{
		passEdit.sendKeys(pass);
	}
	public String getUserEdit()
	{
		return userEdit.getAttribute("value");
	}
	public void loginBtnClick()
	{
		loginBtn.click();
	}
	
	public void vwAttdanceClick()
	{
		vw_attendanceBtn.click();
	}
	public void fromDateClick()
	{
		fromDate.click();
	}
	public void toDateClick()
	{
		toDate.click();
	}
	public void fromDateEdit(String from)
	{
		fromDate.sendKeys(from);
	}
	public void toDateEdit(String to)
	{
		toDate.sendKeys(to);
	}
	public void processBtnClick()
	{
		processBtn.click();
	}
	
	public void exportPdfClick()
	{
		this.exportToPDf.sendKeys("");
	}

	public void exportExcelClick()
	{
		this.exportToExcel.sendKeys("");
	}
	
	public void logOutClick()
	{
		logoutBtn.click();
	}
	public void moveCursorTo()
	{
		moveCursor.click();
	}
	public void hoverOnAttendanceAndClick(WebDriver driver)
	{
		try
		{
			app.actionMouseHover(driver,attendanceLocator);
			app.actionClick(driver,vw_attendanceLocator);
		}catch(Exception e)
		{
			System.out.println("Exception arised while hoverOnAttendance() :: "+e.getMessage());
		}
	}
	public String loginWithValidCredentials(String user,String pass)
	{
		Object obj=null;
		try
		{
			loginClick();
			app.waitFor(driver,null, 60L, "title", "Time office Login");
			setUserEdit(user);
			obj=app.waitFor(driver, userEdit, 60L,"text",user);
			System.out.println("Is UserName of AMS Page entered successfully ? "+obj.toString());
			setPassEdit(pass);
			obj=app.waitFor(driver, passEdit, 60L,"text",pass);
			System.out.println("Is PassWord of AMS Page entered successfully ? "+obj.toString());
			moveCursorTo();
			loginBtnClick();
			app.waitFor(driver,null, 60L, "title", "Time office Home");
			String title=driver.getTitle();
			System.out.println(" title :: "+title);
			if(title.equalsIgnoreCase("Time office Home"))
			{
				return "Pass";
			}
			else
			{
				return "Fail";
			}


		}catch(Exception e)
		{
			return "exception arised while login of AMSPAge :: "+e.getMessage();
		}
	}
	public void captureReportSetUp(String from,String to,String pdfOrExcel)
	{
		try
		{
			hoverOnAttendanceAndClick(driver);
			app.waitFor(driver,null,60L,"title","In and Out Report Processing");
			init.executor("id","ctl00_maincontent_txtdtFrom", from);
			Thread.sleep(2000);
			init.executor("id","ctl00_maincontent_txtdtTo",to);
			Thread.sleep(2000);
			processBtnClick();
			app.waitFor(driver,null,60L,"title","In and Out Report");
			//data.cleanSheet(datasheet,"Sheet3");
			//String sheetName="Sheet_"+app.getDateTime("dd-MMM-YY_hh-mm-ss");
			//data.addSheet(datasheet, sheetName);
			//captureAttendanceReport("Sheet3");
			if(pdfOrExcel.equalsIgnoreCase("excel"))
			{
				app.deleteFile(afterMoving+"InOutReport"+".xls");
				Thread.sleep(2000);
				exportToExcel("InOutReport");
			}
			else if(pdfOrExcel.equalsIgnoreCase("pdf"))
			{
				app.deleteFile(afterMoving+"InOutReport"+".pdf");
				Thread.sleep(2000);
				exportToPDF("InOutReport");
			}
			else
				System.out.println("Invalid Option :: "+pdfOrExcel);
			
		}catch(Exception e)
		{
			System.out.println("exception arised while captureReport()  :: "+e.getMessage());
		}
	}
	
	public void captureAttendanceReport(String sheetName)
	{
		String tr="//table[@id='ctl00_maincontent_GridView1']//tr";
		try
		{
			int noOfRows=driver.findElements(By.xpath(tr)).size();
			int noOfheaders=driver.findElements(By.xpath(tr+"/th")).size();
			for(int row=1;row<=noOfRows;row++)
			{
				if(row==1)
				{
					String xpath_Row=tr+"["+row+"]/th";
					for(int col=1;col<=noOfheaders;col++)
					{
						String xpath_Col=xpath_Row+"["+col+"]";
						WebElement eleCol = driver.findElement(By.xpath(xpath_Col));
						String str=eleCol.getText();
						//System.out.print("  "+str);
						data.addColumn(datasheet,sheetName,str,row-1);
					}
					//System.out.println();
				}
				if(row!=1)
				{
					String xpath_Row=tr+"["+row+"]/td";
					List<WebElement> eleRow = driver.findElements(By.xpath(xpath_Row));
					int noOfColumns=eleRow.size();
					for(int col=1;col<=noOfColumns;col++)
					{
						String xpath_Col=xpath_Row+"["+col+"]";
						WebElement eleCol = driver.findElement(By.xpath(xpath_Col));
						String str=eleCol.getText();
						
						//System.out.print("  "+str);
						data.addColumn(datasheet,sheetName,str,row-1);
					}
					//System.out.println();
				}
			}
		}catch(Exception e)
		{
			System.out.println("exception arised while captureAttendanceReport()  :: "+e.getMessage());
		}
	}
	public void navigateToAMSPageAndPerform(String link)
	{
		try
		{
			driver.get(link);
			String userAMS=prop.getProperty("userNameAMS");
			String passAMS=prop.getProperty("passWordAMS");
			amsPage=new AMSPage(driver);
			String loginResult=amsPage.loginWithValidCredentials(userAMS,passAMS);
			System.out.println(" Login to AMS_PAGE :: "+loginResult);
			Thread.sleep(5000);
			amsPage.captureReportSetUp("18/Jul/2017","31/Jul/2017","excel");
			Thread.sleep(5000);
			String logoutResult=logOutFromAMS();
			System.out.println("Logout from AMS_PAGE :: "+logoutResult);
			String result=loginResult+logoutResult;
			if(result.contains("Fail"))
			{
				data.setCellData(datasheet,"Sheet1","AMS",rowNumber,"Fail");
			}
			else
			{
				data.setCellData(datasheet,"Sheet1","AMS",rowNumber,"Pass");
			}
		}catch(Exception e)
		{
			System.out.println("Exception arised while navigateToAMSPageAndPerform() :: "+e.getMessage());
		}
		
	}
	public String logOutFromAMS()
	{
		amsPage.logOutClick();
		app.waitFor(driver,null, 60L, "title","Time office Login");
		String title=driver.getTitle();
		if(title.equalsIgnoreCase("Time office Login"))
		{
			return "Pass";
		}
		else
		{
			return "Fail";
		}
	}
	public void exportToExcel(String fileName)
	{
		
		try
		{
			exportExcelClick();
			Thread.sleep(2000);
			saveAndEnter();
			Thread.sleep(2000);
			app.fileMove(beforeMoving+"UserInout.xls",afterMoving+fileName+".xls");
		}catch(Exception e)
		{
			System.out.println("Exception arised in exportToExcel() :: "+e.getMessage());
		}
	}
	public void exportToPDF(String fileName)
	{
		
		try
		{
			exportPdfClick();
			Thread.sleep(2000);
			saveAndEnter();
			Thread.sleep(2000);
			app.fileMove(beforeMoving+"Timecard.pdf",afterMoving+fileName+".pdf");
		}catch(Exception e)
		{
			System.out.println("Exception arised in exportToPDF() :: "+e.getMessage());
		}
	}
	public void saveAndEnter()
	{
		try
		{
			robot=new Robot();
			 // pressing enter            
		      robot.keyPress(KeyEvent.VK_ENTER);
		     robot.keyRelease(KeyEvent.VK_ENTER);
		              
		    Thread.sleep(2000);
		    
		   //press s key to save            
		   robot.keyPress(KeyEvent.VK_ALT);
		   robot.keyRelease(KeyEvent.VK_S);
		   Thread.sleep(2000);
		  //press enter to save the file with default name and in default location
		    robot.keyPress(KeyEvent.VK_S);
		    robot.keyRelease(KeyEvent.VK_ALT);
			if(browser!="ie")
			{
				app.robot(KeyEvent.VK_ENTER);
			}
			
		}catch(Exception e)
		{
			System.out.println("Exception arised in saveAndEnter() :: "+e.getMessage());
		}
	}
	/*public static void main(String[] args) {
		AMSPage ams=new AMSPage();
		ams.exportToExcel("InOutReport");
	}*/
}
