package IndividualFlows;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.ExtentReport.ExtentReport;
import com.pages.Reports_AdministrationRequestPage;

import base.BaseClass;

public class Reports_AdministrationRequestTCH extends BaseClass{

	@Test
	public void AdministrationRequest_TCH() throws InterruptedException
	{
		ExtentReport.createTest("Administration Request Summary TCH Test");
		acreport = new Reports_AdministrationRequestPage(driver);

		scrollByVisibilityOfElement(driver, acreport.Reports);

		visibleofele(driver, acreport.MenuListAccountReporting, "Administration Request");
		JSClick(driver, acreport.MenuListAccountReporting, "Navigating to Administration Request");
		
		// Get report types from config
		String[] reportTypesFromConfig = prop.getProperty("TCHReportType").split(",");
		System.out.println(reportTypesFromConfig.length);
		for (String reportType : reportTypesFromConfig) {
			ExtentReport.createChildTest(reportType);
			// Step 1: Reopen the dropdown
			
//			clickelementwithname(acreport.selectReportType, "Reopening Report Type dropdown");
			 WebElement dropdownToOpen = getDropdownForReportType(reportType);
		        clickelementwithname(dropdownToOpen, "Open dropdown for " + reportType);

			// Step 2: Re-fetch the list to avoid stale element
			List<WebElement> reportTypelist = acreport.reportTypelist;

			boolean matchFound = false;
			for (WebElement webElement : reportTypelist) 
			{
				String reportName = webElement.getText().trim();
				if (reportName.toLowerCase().contains(reportType.trim().toLowerCase())) {
					// Step 3: Click matching element
					webElement.click();

					// Step 4: Call corresponding method
					switch (reportType.trim().toUpperCase()) {
					case "ECHO":
//						clickelementwithname(acreport.selectReportType, "Reopening Report Type dropdown");
						acreport.TCHEchoreport();
						break;
					case "SIGN-ON":
//						clickelementwithname(acreport.SignOnselectReportType, "Reopening Report Type dropdown");
						acreport.TCHSignOnReport();
						break;
					case "SIGN-OFF":
//						clickelementwithname(acreport.SignOffselectReportType, "Reopening Report Type dropdown");
						acreport.TCHSignOffReport();
						break;
					case "DATABASE":
//						clickelementwithname(acreport.DatabaseselectReportType, "Reopening Report Type dropdown");
						acreport.TCHDatabaseReport();
						break;
						// Add more if needed
					default:
						System.out.println("No method defined for: " + reportType);
					}

					// Optional: refresh page if needed
//					refresh();
					matchFound = true;
					break;
				}
			}

			if (!matchFound) 
				System.out.println("Report type not found in dropdown: " + reportType);
			ExtentReport.resetToParent(); 
		}
		
	}
	private WebElement getDropdownForReportType(String reportType) {
	    switch (reportType.toUpperCase()) {
	        case "ECHO":
	            return acreport.selectReportType;         // example - adapt if needed
	        case "SIGN-ON":
	            return acreport.SignOnselectReportType;
	        case "SIGN-OFF":
	            return acreport.SignOffselectReportType;
	        case "DATABASE":
	            return acreport.DatabaseselectReportType;
	        default:
	            return acreport.selectReportType; // fallback
	    }
	}
}
