package com.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ExtentReport.ExtentReport;
import com.ExtentReport.Extentlogger;
import base.BaseClass;

public class Reports_AdministrationRequestPage extends BaseClass {

	@FindBy(xpath = "//span[@class='menu-item-text' and text()='Reports/System Messages']/../../following::div")
	public WebElement Reports;
	@FindBy(xpath = "//span[@class='menu-item-text' and text()='Administration Request']")
	public WebElement MenuListAccountReporting;
	@FindBy(xpath = "(//div[@id='demo-simple-select-autowidth'])[1]")
	public WebElement paymentservicedropdown;
	@FindBy(xpath = "//div[contains(@class,'MuiPaper-root MuiPaper-elevation')]//ul[1]/li[contains(text(),'TCH')]")
	public WebElement TCHoption;

	@FindBy(xpath = "//div[contains(.,'Select Administration Message') and @role='combobox']")
	public WebElement selectReportType;
	
	@FindBy(xpath = "//div[contains(.,'Sign') and @role='combobox']")
	public WebElement SignOnselectReportType;

	@FindBy(xpath = "//div[contains(.,'Echo') and @role='combobox']")
	public WebElement SignOffselectReportType;

	@FindBy(xpath = "//div[contains(.,'Sign') and @role='combobox']")
	public WebElement DatabaseselectReportType;

	@FindBy(xpath = "//div[@id=contains(.,'menu')]/following::ul//following::li")
	public List<WebElement> reportTypelist;

	@FindBy(xpath = "//li[contains(.,'Echo')]")
	public WebElement EchoreportType;

	@FindBy(xpath = "//li[contains(.,'Sign-On')]")
	public WebElement SignOnreportType;

	@FindBy(xpath = "//button[contains(text(),'Generate')]")
	public WebElement generatebtn;

	@FindBy(xpath = "//div[contains(text(),'System Message Generated Successfully')]/..")
	public WebElement generatedAlert;

	@FindBy(xpath = "//div[@class='ant-modal-body']")
	public WebElement GenerateResultscren;

	@FindBy(css="span[role='progressbar']")
	public WebElement loader;

	@FindBy(xpath="//button[contains(@class,'MuiButtonBase-root MuiIconButton-root')]/*[@data-testid='FileDownloadIcon']")
	public WebElement resultsdownloadbtn;

	@FindBy(xpath = "//button[@aria-label='Close']")
	public WebElement resultsClosebtn;

	@FindBy(xpath = "//div[contains(text(),'No data to download')]")
	public WebElement noDataAlert;

	@FindBy(xpath = "//li[contains(.,'Sign-Off')]")
	public WebElement SignOffreportType;
	
	@FindBy(xpath = "//li[contains(.,'Database')]")
	public WebElement DatabasereportType;
	
	/* ----------------------------------------------------------------------- */
	
	//CONSTRUCTOR
	public Reports_AdministrationRequestPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
/*----------------------Start of TCH Methods--------------------------------------------------------------------*/	
	/* TCH Flow Methods */
	
	public void TCHEchoreport() throws InterruptedException	
	{

				clickelementwithname(acreport.EchoreportType,"Choosing Echo Report Type");
Thread.sleep(2000);
		clickelementwithname(acreport.generatebtn,"Clicking Generate button");

//		visibleofele(driver, acreport.generatedAlert, "Generated alert");

		visibleofele(driver, acreport.GenerateResultscren, "Generated Results Screen");
//		acreport.assertLoaderAppears(acreport.loader);
	/*	boolean loaderstatus = acreport.waitForLoaderToDisappear(acreport.loader,30,2);

		if(loaderstatus)*/
		{
		Thread.sleep(5000);
			clickelementwithname(acreport.resultsdownloadbtn, "Results Download btn");
			Extentlogger.pass("Report is Generated, and able to download.",true);
			clickelementwithname(acreport.resultsClosebtn, "Results Close btn");

		}
	/*	else {
			//clickelementwithname(acreport.resultsdownloadbtn, "Results Download btn");
			clickelementwithname(acreport.noDataAlert, "Results no data alert");
			invisibilityofelement(driver, acreport.noDataAlert, "No data alert");
			clickelementwithname(acreport.resultsClosebtn, "Results Close btn");
			Extentlogger.fail("Loader did not disappear, Still loading and displays 'no data'.",true);
	}	*/
	}
    	
	public void TCHSignOnReport() throws InterruptedException	
	{
	
		clickelementwithname(acreport.SignOnreportType,"Choosing SignOn Report Type");
		Thread.sleep(2000);
				
		clickelementwithname(acreport.generatebtn,"Clicking Generate button");

		visibleofele(driver, acreport.generatedAlert, "Generated alert");

		visibleofele(driver, acreport.GenerateResultscren, "Generated Results Screen");
//		acreport.assertLoaderAppears(acreport.loader);
		/*boolean loaderstatus = acreport.waitForLoaderToDisappear(acreport.loader,60,5);

		if(loaderstatus)*/
		{
		Thread.sleep(5000);
			clickelementwithname(acreport.resultsdownloadbtn, "Results Download btn");
			Extentlogger.pass("Report is Generated, and able to download.",true);
			clickelementwithname(acreport.resultsClosebtn, "Results Close btn");

		}
	/*	else {
			clickelementwithname(acreport.resultsdownloadbtn, "Results Download btn");
			clickelementwithname(acreport.noDataAlert, "Results no data alert");
			invisibilityofelement(driver, acreport.noDataAlert, "No data alert");
			clickelementwithname(acreport.resultsClosebtn, "Results Close btn");
			Extentlogger.fail("Loader did not disappear, Still loading and displays 'no data'.",true);
		}*/
	}
	public void TCHDatabaseReport() throws InterruptedException	
	{
		
		clickelementwithname(acreport.DatabasereportType,"Choosing Database Report Type");
		Thread.sleep(2000);
				clickelementwithname(acreport.generatebtn,"Clicking Generate button");

		visibleofele(driver, acreport.generatedAlert, "Generated alert");

		visibleofele(driver, acreport.GenerateResultscren, "Generated Results Screen");
//		acreport.assertLoaderAppears(acreport.loader);
		/*boolean loaderstatus = acreport.waitForLoaderToDisappear(acreport.loader,30,2);

		if(loaderstatus)*/
		{
			clickelementwithname(acreport.resultsdownloadbtn, "Results Download btn");
			clickelementwithname(acreport.resultsClosebtn, "Results Close btn");

		}
		/*else {
			clickelementwithname(acreport.resultsdownloadbtn, "Results Download btn");
			clickelementwithname(acreport.noDataAlert, "Results no data alert");
			invisibilityofelement(driver, acreport.noDataAlert, "No data alert");
			clickelementwithname(acreport.resultsClosebtn, "Results Close btn");
			Extentlogger.fail("Loader did not disappear, Still loading and displays 'no data'.");
		}	*/
	}
	public void TCHSignOffReport() throws InterruptedException	
	{
	
		clickelementwithname(acreport.SignOffreportType,"Choosing SignOff Report Type");
		Thread.sleep(2000);

				clickelementwithname(acreport.generatebtn,"Clicking Generate button");

		visibleofele(driver, acreport.generatedAlert, "Generated alert");

		visibleofele(driver, acreport.GenerateResultscren, "Generated Results Screen");
//		acreport.assertLoaderAppears(acreport.loader);
		/*boolean loaderstatus = acreport.waitForLoaderToDisappear(acreport.loader,30,2);

		if(loaderstatus)*/
		{
			clickelementwithname(acreport.resultsdownloadbtn, "Results Download btn");
			clickelementwithname(acreport.resultsClosebtn, "Results Close btn");

		}
		/*else {
			clickelementwithname(acreport.resultsdownloadbtn, "Results Download btn");
			clickelementwithname(acreport.noDataAlert, "Results no data alert");
			invisibilityofelement(driver, acreport.noDataAlert, "No data alert");
			clickelementwithname(acreport.resultsClosebtn, "Results Close btn");
			Extentlogger.fail("Loader did not disappear, Still loading and displays 'no data'.");
		}	*/
	}
	
/*----------------------End of TCH Methods----------------------------------------------------------------------*/	

}

