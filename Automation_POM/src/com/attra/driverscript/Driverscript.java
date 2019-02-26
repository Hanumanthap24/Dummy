package com.attra.driverscript;

import java.awt.Robot;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.attra.datatable.Datatable;
import com.attra.pages.AISPage;
import com.attra.pages.HomePage;
import com.attra.pages.LoginPage;
import com.attra.testcases.AccountDeatilsFetch;
import com.attra.pages.AMSPage;
import com.attra.pages.AccountDetails;
import com.attra.pages.AttraWebSitePage;
import com.attra.utils.AppIndependant;
import com.attra.utils.Initialize;

public class Driverscript 
{
	public static AppIndependant app=null;
	public static Initialize init=null;
	public static WebDriver driver=null;
	public static Datatable data=null;
	public static AMSPage amsPage=null;
	public static AISPage aispage=null;
	public static AccountDetails accountDetails=null;
	public static LoginPage loginPage=null;
	public static Actions action=null;
	public static Robot robot=null;
	public static AttraWebSitePage attraPage=null;
	public static Properties prop=null;
	public static String configFile=System.getProperty("user.dir")+"\\PropertiesFiles\\Configuration.properties";
	public static String datasheet=System.getProperty("user.dir")+"\\DataSheet\\TestData.xlsx";
	public static String dataOutputSheet=System.getProperty("user.dir")+"\\DataSheet\\DataExtracted.xlsx";
	public static String sheetName;
	public static String browser;
	public static int rowNumber;
	public static String beforeMoving="C:\\Users\\yogesh.thimmappa\\Downloads\\",afterMoving=System.getProperty("user.dir")+"\\Results\\ResultExcel\\";
	public static String sheet;
	public static HashMap<String, String> dataHashMap;
	
	@BeforeClass
	public void preCondition()
	{
		try
		{
		//	robot=new Robot();
			app=new AppIndependant();
			init=new Initialize();
			data=new Datatable();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void runner(HashMap<String, String> testDataHashMap)
	{
			dataHashMap=testDataHashMap;
			browser=dataHashMap.get("Browser");
			driver=init.browserLaunch(browser);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
	}
	
	
}
