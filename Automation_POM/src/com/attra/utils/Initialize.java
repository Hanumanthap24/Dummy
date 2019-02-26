package com.attra.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.attra.driverscript.Driverscript;


public class Initialize extends Driverscript
{

	public static WebDriver driver;
	
	public WebDriver browserLaunch(String browserType)
	{
		try
		{
			switch (browserType.toLowerCase()) 
			{
			case "ie":
				String keyIE="webdriver.ie.driver";
				String valueIE=System.getProperty("user.dir")+"\\Library\\Drivers\\IEDriverServer.exe";
				System.setProperty(keyIE, valueIE);
				driver=new InternetExplorerDriver();
				break;
			case "chrome":
				String keyC="webdriver.chrome.driver";
				String valueC=System.getProperty("user.dir")+"\\Library\\Drivers\\chromedriver.exe";
				
				System.setProperty(keyC, valueC);
				driver=new ChromeDriver();
				break;

			case "firefox":
				DesiredCapabilities cap=DesiredCapabilities.firefox();
				String keyFF="webdriver.gecko.driver";
				String valueFF=System.getProperty("user.dir")+"\\Library\\Drivers\\geckodriver.exe";
				System.setProperty(keyFF, valueFF);
				driver=new FirefoxDriver(cap);
				break;
			}
			if(driver!=null)
			{
				System.out.println(" Browser launched successfully ");
				return driver;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		return driver;
	}
	public String navigateToURL(String URL)
	{
		try
		{
			driver.get(URL);
			
			/*driver.navigate().to(URL);
			
			driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);*/
			
			return "Pass";
			
		}catch(Exception e)
		{
			return "exception arised while navigating URL"+e.getMessage();
		}
	}
	
	public void closeBrowser()
	{
		try
		{
			driver.quit();
			//Thread.sleep(5000);
		}catch(Exception e)
		{
			System.out.println("exception arised while Closing Browser :: "+e.getMessage());
		}
	}
	public WebDriver initialize(String browserType,String URL)
	{
		try
		{
			driver=init.browserLaunch(browserType);
			String result=init.navigateToURL(URL);
			System.out.println(" navigating to the URL :: "+result);
			return driver;
		}catch(Exception e)
		{
			System.out.println("exception arised in intialize() ::"+e.getMessage());
			return null;
		}
	}
	public void executor(String type,String id,String from_to)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		if(type.equalsIgnoreCase("id"))
		{
			String script="document.getElementById('"+id+"').value='"+from_to+"'";
			js.executeScript(script);
		}
		if(type.equalsIgnoreCase("class"))
		{
			String script="document.getElementsByClassName('"+id+"')[0].value='"+from_to+"'";
			js.executeScript(script);
		}
		
	}
}