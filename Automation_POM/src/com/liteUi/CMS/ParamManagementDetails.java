package com.liteUi.CMS;
import com.liteUi.CMS.*;
import java.util.HashMap;
import org.testng.annotations.Test;
import com.attra.datatable.Datatable;
import com.attra.driverscript.Driverscript;
import com.attra.pages.LoginPage;

public class ParamManagementDetails extends Driverscript {                
                
	public static ParameterManagement pm = null;
	
    public static void initElements()
    {	
        loginPage = new LoginPage(driver);
        pm = new ParameterManagement(driver);
    }
    
    public void Login() {
    	HashMap<String, String> dataHashMap;
        dataHashMap = Datatable.getCellData(datasheet, "Sheet1", 2);
        if (dataHashMap.get("RunStatus").equalsIgnoreCase("Y"))
    	{
        	try {
                Driverscript.runner(dataHashMap);
		    	driver.get(dataHashMap.get("Url"));
		        initElements();
		        loginPage.login(dataHashMap);
		        Thread.sleep(25000);
			} catch (InterruptedException e) {			
				e.printStackTrace();
				driver.quit();
			}
    	}
    }
    
    @Test(priority=1)
    public void AccountProcessingTableDetails() {
    	Login();
        pm.getAccountProcessingTableDetails();
        pm.getInsuranceTableDetails();
    }
    
    
//    @Test
    public void InsuranceTableDetails() {
    	//Login();
        pm.getInsuranceTableDetails(); 
    }
    
//    @Test
    public void FeeTableDetails() {
    	//Login();
        pm.getFeeTableDetails(); 
    }
    
//    @Test
    public void TaxTableDetails() {
    	//Login();
        pm.getTaxTableDetails(); 
    }
    
//    @Test
    public void RateIndexTableDetails() {
    	//Login();
        pm.getRateIndexTableDetails(); 
    }
    
//    @Test
    public void StateUsuryDetails() {
    	//Login();
    	pm.getStateUsuryDetails();
    }
    
//    @Test
    public void ProcessingControlTableID() {
    	//Login();
    	pm.getProcessingControlTableDetails();
    }
    
//    @Test
    public void MonetaryTransactionControl() {
    	//();
    	pm.getMonetaryTransactionControlDetails();
    }
       
}
