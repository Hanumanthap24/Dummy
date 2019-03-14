package com.attra.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.math3.util.MultidimensionalCounter.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.attra.driverscript.Driverscript;
import com.gargoylesoftware.htmlunit.javascript.host.Map;

public class AccountDetails extends Driverscript {
	
	public  static WebDriver driver;
    public AccountDetails(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}

    @FindBy(xpath="//a[contains(.,'Business Unit')]/following::input[1]")
	WebElement BusinessUnit;
public WebDriver getDriver() {
		return driver;
	}
@FindBy(xpath="//button[contains(.,'Next Group')]")
WebElement nextGroup;
public WebElement getnextGroup() {
	return nextGroup;
}
	public WebElement getBusinessUnit() {
		return BusinessUnit;
	}
	public WebElement getAccountNumber() {
		return AccountNumber;
	}
	public WebElement getProduct() {
		return Product;
	}
	public WebElement getBillingAcctInd() {
		return BillingAcctInd;
	}
	public WebElement getShortName() {
		return ShortName;
	}
	public WebElement getCustomerNumber() {
		return CustomerNumber;
	}
	public WebElement getAlternateCustomerNumberFlag() {
		return AlternateCustomerNumberFlag;
	}
	public WebElement getAlternateCustomerNumber() {
		return AlternateCustomerNumber;
	}
	public WebElement getUserAccountNumber() {
		return UserAccountNumber;
	}
	public WebElement getInternalStatus() {
		return InternalStatus;
	}
	public WebElement getChargeOffStatus() {
		return ChargeOffStatus;
	}
	public WebElement getBlockCode1() {
		return BlockCode1;
	}
	public WebElement getBlockCode2() {
		return BlockCode2;
	}
	public WebElement getBillingCycle() {
		return BillingCycle;
	}
	public WebElement getStatementFlag() {
		return StatementFlag;
	}
	public WebElement getStatementFrequency() {
		return StatementFrequency;
	}
	public WebElement getReturnMailCounter() {
		return ReturnMailCounter;
	}
	public WebElement getReturnMailUser() {
		return ReturnMailUser;
	}
	public WebElement getReturnMailDate() {
		return ReturnMailDate;
	}
	public WebElement getPermanentCollector() {
		return PermanentCollector;
	}
	public WebElement getCollateralCode() {
		return CollateralCode;
	}
	public WebElement getOwnerFlag() {
		return OwnerFlag;
	}
	public WebElement getEmployeeCode() {
		return EmployeeCode;
	}
	public WebElement getLetterRequest() {
		return LetterRequest;
	}
	public WebElement getCollateralCardRequest() {
		return CollateralCardRequest;
	}
	public WebElement getAccountDisplayRequest() {
		return AccountDisplayRequest;
	}
	public WebElement getRestructureFlag() {
		return RestructureFlag;
	}
	public WebElement getStatementReprintFlag() {
		return StatementReprintFlag;
	}
	public WebElement getFlexBillingFlag() {
		return FlexBillingFlag;
	}
	public WebElement getApplicationDate() {
		return ApplicationDate;
	}
	public WebElement getDateAccountOpened() {
		return DateAccountOpened;
	}
	public WebElement getBlockCodeDate1() {
		return BlockCodeDate1;
	}
	public WebElement getBlockCodeDate2() {
		return BlockCodeDate2;
	}
	public WebElement getDateClosed() {
		return DateClosed;
	}
	public WebElement getCardFeeDate() {
		return CardFeeDate;
	}
	public WebElement getNextStatementDate() {
		return NextStatementDate;
	}
	public WebElement getDateLastMaintenance() {
		return DateLastMaintenance;
	}
	public WebElement getAltCustomerExpiryDate() {
		return AltCustomerExpiryDate;
	}
	public WebElement getStatementReprintDate() {
		return StatementReprintDate;
	}
	public WebElement getDateofNotificationReceived() {
		return DateofNotificationReceived;
	}
	public WebElement getCardExpirationDate() {
		return CardExpirationDate;
	}
	public WebElement getCreditLimit() {
		return CreditLimit;
	}
	public WebElement getHighBalanceAmount() {
		return HighBalanceAmount;
	}
	public WebElement getIncomeoftheAccount() {
		return IncomeoftheAccount;
	}
	public WebElement getNumberofUnblockedCards() {
		return NumberofUnblockedCards;
	}
	public WebElement getNumberofChargeOffDays() {
		return NumberofChargeOffDays;
	}
	public WebElement getResetChargeoffDaysSwitch() {
		return ResetChargeoffDaysSwitch;
	}
	public WebElement getReportFraudulentActivity() {
		return ReportFraudulentActivity;
	}
	public WebElement getSystemDefinedChargeOffReason() {
		return SystemDefinedChargeOffReason;
	}
	public WebElement getUserDefinedChargeOffReason() {
		return UserDefinedChargeOffReason;
	}
	public WebElement getGreatestExpiryDate() {
		return GreatestExpiryDate;
	}
	public WebElement getRelationshipnumber() {
		return Relationshipnumber;
	}
	public WebElement getCardScheme() {
		return CardScheme;
	}
	public WebElement getPrimaryAccountFlag() {
		return PrimaryAccountFlag;
	}
	public WebElement getReissueScheme() {
		return ReissueScheme;
	}
	public WebElement getDateLastCycle() {
		return DateLastCycle;
	}
	public WebElement getMemoBillingCurrency() {
		return MemoBillingCurrency;
	}
	public WebElement getCustomerStatementFlag() {
		return CustomerStatementFlag;
	}
	public WebElement getCustomerStatementLetterFlag() {
		return CustomerStatementLetterFlag;
	}
	public WebElement getCurrencyCode() {
		return CurrencyCode;
	}
	public WebElement getBillingLevel() {
		return BillingLevel;
	}
	public WebElement getVIPStatus() {
		return VIPStatus;
	}
	public WebElement getDualBillingFlag() {
		return DualBillingFlag;
	}
	public WebElement getLiabilityIndicator() {
		return LiabilityIndicator;
	}
	public WebElement getDueDay() {
		return DueDay;
	}
	public WebElement getDeferMembershipFeeDate() {
		return DeferMembershipFeeDate;
	}
	public WebElement getCorrespondenceCustomerNumber() {
		return CorrespondenceCustomerNumber;
	}
	public WebElement getAltCustomeraddressEffectiveDate() {
		return AltCustomeraddressEffectiveDate;
	}
	public WebElement getCCMCustomerID() {
		return CCMCustomerID;
	}
	
	

@FindBy(xpath="//a[contains(.,'Account Number')]/following::input[1]")
	WebElement AccountNumber;
@FindBy(xpath="//a[contains(.,'Product')]/following::input[1]")
	WebElement Product;
@FindBy(xpath="//a[contains(.,'Billing Acct Ind(Req only for ADD)*')]/following::input[1]")
	WebElement BillingAcctInd;
@FindBy(xpath="//a[contains(.,'Short Name')]/following::input[1]")
	WebElement ShortName;
@FindBy(xpath="//a[contains(.,'Customer Number')]/following::input[1]")
	WebElement CustomerNumber;
@FindBy(xpath="//a[contains(.,'Alternate Customer Number Flag')]/following::select[1]")
	WebElement AlternateCustomerNumberFlag;
@FindBy(xpath="//a[contains(.,'Alternate Customer Number')]/following::input[1]")
	WebElement AlternateCustomerNumber;
@FindBy(xpath="//a[contains(.,'User Account Number')]/following::input[1]")
	WebElement UserAccountNumber;
@FindBy(xpath="//a[contains(.,'Internal Status')]/following::select[1]")
	WebElement InternalStatus;
@FindBy(xpath="//a[contains(.,'Charge Off Status')]/following::input[1]")
	WebElement ChargeOffStatus;
@FindBy(xpath="//a[contains(.,'Block Code 1')]/following::select[1]")
	WebElement BlockCode1;
@FindBy(xpath="//a[contains(.,'Block Code 2')]/following::select[1]")
	WebElement BlockCode2;
@FindBy(xpath="//a[contains(.,'Billing Cycle')]/following::input[1]")
	WebElement BillingCycle;
@FindBy(xpath="//a[contains(.,'Statement Flag')]/following::select[1]")
	WebElement StatementFlag;
@FindBy(xpath="//a[contains(.,'Statement Frequency')]/following::select[1]")
	WebElement StatementFrequency;
@FindBy(xpath="//a[contains(.,'Return Mail Counter')]/following::input[1]")
	WebElement ReturnMailCounter;
@FindBy(xpath="//a[contains(.,'Return Mail User')]/following::input[1]")
	WebElement ReturnMailUser;
@FindBy(xpath="//a[contains(.,'Return Mail Date')]/following::input[1]")
	WebElement ReturnMailDate;
@FindBy(xpath="//a[contains(.,'Permanent Collector')]/following::input[1]")
	WebElement PermanentCollector;
@FindBy(xpath="//a[contains(.,'Collateral Code')]/following::input[1]")
	WebElement CollateralCode;
@FindBy(xpath="//a[contains(.,'Owner Flag')]/following::input[1]")
	WebElement OwnerFlag;
@FindBy(xpath="//a[contains(.,'Employee Code')]/following::input[1]")
	WebElement EmployeeCode;
@FindBy(xpath="//a[contains(.,'Letter Request')]/following::input[1]")
	WebElement LetterRequest;
@FindBy(xpath="//a[contains(.,'Collateral Card Request')]/following::select[1]")
	WebElement CollateralCardRequest;
@FindBy(xpath="//a[contains(.,'Account Display Request')]/following::select[1]")
	WebElement AccountDisplayRequest;
@FindBy(xpath="//a[contains(.,'Restructure Flag')]/following::select[1]")
	WebElement RestructureFlag;
@FindBy(xpath="//a[contains(.,'Statement Reprint Flag')]/following::select[1]")
	WebElement StatementReprintFlag;
@FindBy(xpath="//a[contains(.,'Flex Billing Flag')]/following::select[1]")
	WebElement FlexBillingFlag;
@FindBy(xpath="//a[contains(.,'Application Date')]/following::input[1]")
	WebElement ApplicationDate;
@FindBy(xpath="//a[contains(.,'Date Account Opened')]/following::input[1]")
	WebElement DateAccountOpened;
@FindBy(xpath="//a[contains(.,'Block Code Date 1')]/following::input[1]")
	WebElement BlockCodeDate1;
@FindBy(xpath="//a[contains(.,'Block Code Date 2')]/following::input[1]")
	WebElement BlockCodeDate2;
@FindBy(xpath="//a[contains(.,'Date Closed')]/following::input[1]")
	WebElement DateClosed;
@FindBy(xpath="//a[contains(.,'Card Fee Date')]/following::input[1]")
	WebElement CardFeeDate;
@FindBy(xpath="//a[contains(.,'Next Statement Date')]/following::input[1]")
	WebElement NextStatementDate;
@FindBy(xpath="//a[contains(.,'Date Last Maintenance')]/following::input[1]")
	WebElement DateLastMaintenance;
@FindBy(xpath="//a[contains(.,'Alt Customer Expiry Date')]/following::input[1]")
	WebElement AltCustomerExpiryDate;
@FindBy(xpath="//a[contains(.,'Statement Reprint Date')]/following::input[1]")
	WebElement StatementReprintDate;
@FindBy(xpath="//a[contains(.,'Date of Notification Received')]/following::input[1]")
	WebElement DateofNotificationReceived;
@FindBy(xpath="//a[contains(.,'Card Expiration Date')]/following::input[1]")
	WebElement CardExpirationDate;
@FindBy(xpath="//a[contains(.,'Credit Limit')]/following::input[1]")
	WebElement CreditLimit;
@FindBy(xpath="//a[contains(.,'High Balance Amount')]/following::input[1]")
	WebElement HighBalanceAmount;
@FindBy(xpath="//a[contains(.,'Income of the Account')]/following::input[1]")
	WebElement IncomeoftheAccount;
@FindBy(xpath="//a[contains(.,'Number of Unblocked Cards')]/following::input[1]")
	WebElement NumberofUnblockedCards;
@FindBy(xpath="//a[contains(.,'Number of Charge Off Days')]/following::input[1]")
	WebElement NumberofChargeOffDays;
@FindBy(xpath="//a[contains(.,'Reset Chargeoff Days Switch')]/following::input[1]")
	WebElement ResetChargeoffDaysSwitch;
@FindBy(xpath="//a[contains(.,'Report Fraudulent Activity')]/following::input[1]")
	WebElement ReportFraudulentActivity;
@FindBy(xpath="//a[contains(.,'System Defined Charge Off Reason')]/following::select[1]")
	WebElement SystemDefinedChargeOffReason;
@FindBy(xpath="//a[contains(.,'User Defined Charge Off Reason')]/following::input[1]")
	WebElement UserDefinedChargeOffReason;
@FindBy(xpath="//a[contains(.,'Greatest Expiry Date')]/following::input[1]")
	WebElement GreatestExpiryDate;
@FindBy(xpath="//a[contains(.,'Relationship number')]/following::input[1]")
	WebElement Relationshipnumber;
@FindBy(xpath="//a[contains(.,'Card Scheme')]/following::input[1]")
	WebElement CardScheme;
@FindBy(xpath="//a[contains(.,'Primary Account Flag')]/following::select[1]")
	WebElement PrimaryAccountFlag;
@FindBy(xpath="//a[contains(.,'Reissue Scheme')]/following::select[1]")
	WebElement ReissueScheme;
@FindBy(xpath="//a[contains(.,'Date Last Cycle')]/following::input[1]")
	WebElement DateLastCycle;
@FindBy(xpath="//a[contains(.,'Memo Billing Currency')]/following::input[1]")
	WebElement MemoBillingCurrency;
@FindBy(xpath="//a[contains(.,'Customer Statement Flag')]/following::select[1]")
	WebElement CustomerStatementFlag;
@FindBy(xpath="//a[contains(.,'Customer Statement Letter Flag')]/following::select[1]")
	WebElement CustomerStatementLetterFlag;
@FindBy(xpath="//a[contains(.,'Currency Code')]/following::input[1]")
	WebElement CurrencyCode;
@FindBy(xpath="//a[contains(.,'Billing Level')]/following::select[1]")
	WebElement BillingLevel;
@FindBy(xpath="//a[contains(.,'VIP Status')]/following::select[1]")
	WebElement VIPStatus;
@FindBy(xpath="//a[contains(.,'Dual Billing Flag')]/following::select[1]")
	WebElement DualBillingFlag;
@FindBy(xpath="//a[contains(.,'Liability Indicator')]/following::select[1]")
	WebElement LiabilityIndicator;
@FindBy(xpath="//a[contains(.,'Due Day')]/following::input[1]")
	WebElement DueDay;
@FindBy(xpath="//a[contains(.,'Defer Membership Fee Date')]/following::input[1]")
	WebElement DeferMembershipFeeDate;
@FindBy(xpath="//a[contains(.,'Correspondence Customer Number')]/following::input[1]")
	WebElement CorrespondenceCustomerNumber;
@FindBy(xpath="//a[contains(.,'Alt Customer address Effective Date')]/following::input[1]")
	WebElement AltCustomeraddressEffectiveDate;
@FindBy(xpath="//a[contains(.,'CCM Customer ID')]/following::input[1]")
	WebElement CCMCustomerID;
@FindBy(xpath="//button[contains(.,'Query')]")
WebElement query;
public WebElement getQuery() {
	return query;
	}

public static HashMap<String, String> getdefaulttext(HashMap<String, String> hMap) {
	List<WebElement> list = driver.findElements(By.xpath("//select[@class='alpaca-control form-control']/parent::div/a"));
	String actual = "";
	for (int i=0; i<list.size(); i++) 
	{
		String header = list.get(i).getAttribute("innerHTML");
		System.out.println(header);	
		
		   WebElement ele = driver.findElement(By.xpath("//a[contains(text() ,'" + header + "')]/parent::div/select[1]"));				
		   Select select = new Select(ele);
		   
	     try {
	
		    actual = select.getFirstSelectedOption().getText();
	     }

		catch(Exception e) {
		
			actual = "";
	}
	hMap.put(header, actual);
							
			}
	return hMap;
		
	}

public static HashMap<String, String> getdefaultInputText(HashMap<String, String> hMap) {
	List<WebElement> list = driver.findElements(By.xpath("//input[@class='alpaca-control form-control']/parent::div/a"));
	String actual = "";
	for (int i=0; i<list.size(); i++) 
	{
		String header = list.get(i).getAttribute("innerHTML").replace("*", "").toString().split("<")[0];
				
		System.out.println(header);	
		
		   WebElement element = driver.findElement(By.xpath("//a[contains(text(), '" + header + "')]/parent::div/input"));				
		  			   
	     try {
	    	  actual = element.getAttribute("value");
		    
	     }

		catch(Exception e) {
		
		//	actual = "";
	}
	hMap.put(header, actual);
							
			}
	return hMap;
		
	}

public static void getTableData() {
	
	String actual = "";
	
	String[][] data = new String[40][27];
	String[] pages = driver.findElement(By.xpath("//span[@class='paginate_of']")).getText().split(" ");
	int totalPageNumber = Integer.parseInt(pages[1]);
	
	for(int i=1; i<totalPageNumber; i++) {
		
		int rows=driver.findElements(By.xpath("//*[@id='table_object2_table2_transposedTable']/tbody/tr")).size();
		int columns=driver.findElements(By.xpath("//*[@id='table_object2_table2_transposedTable']/tbody/tr[1]/td")).size();
		
		System.out.println("rows "+rows);
		System.out.println("Columns "+columns);
		for (int p = 1; p <= columns; p++) {	
			for (int k = 1; k <= rows; k++) {
			String value  = driver.findElement(By.xpath("//*[@id='table_object2_table2_transposedTable']/tbody/tr["+k+"]/td["+p+"]")).getAttribute("innerHTML");
			
			if(value.contains("select")) {
				WebElement element = driver.findElement(By.xpath("//*[@id='table_object2_table2_transposedTable']/tbody/tr["+k+"]/td["+p+"]/select"));
				Select select = new Select(element);
				
				try {
					 actual = select.getFirstSelectedOption().getText();
				}
				catch (Exception e) {
					actual = "";
				}
				
			}
			else if(value.contains("input")){
				WebElement element = driver.findElement(By.xpath("//*[@id='table_object2_table2_transposedTable']/tbody/tr["+k+"]/td["+p+"]/input"));				
				 actual = element.getText();
			}
			else {
				WebElement element = driver.findElement(By.xpath("//*[@id='table_object2_table2_transposedTable']/tbody/tr["+k+"]/td["+p+"]"));						
				 actual = element.getText();	
			}
			
			data[k][p] = actual;
			
			System.out.println(data[k][p] = actual);

		}
		
		
		
	}
	

			driver.findElement(By.xpath("//span[@class='next paginate_button']")).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
}

}
