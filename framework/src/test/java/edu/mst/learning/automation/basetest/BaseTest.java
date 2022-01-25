package edu.mst.learning.automation.basetest;
import java.io.IOException;
//import java.util.concurrent.TimeUnit;

//import edu.mst.learning.automation.browserfactory;
/**
 * @author Jane hepsiba
 * Description: This class is used for basetest
 * 
 */

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

//import com.aventstack.extentreports.ExtentReports;

import edu.mst.learning.automation.browserfactory.BrowserOpening;
import edu.mst.learning.automation.browserfactory.BrowserOpening.driversupportedbrowser;
//import edu.mst.learning.automation.extentreport.ExtentReport;
import edu.mst.learning.automation.extentreport.ExtentReportFactory;
import edu.mst.learning.automation.extentreport.ReportGenerator;
//import edu.mst.learning.automation.extentreport.ExtentReport;
//import edu.mst.learning.automation.extentreport.ReportsGenerator;
//import edu.mst.learning.automation.extentreport.ExtentReportClass;
import edu.mst.learning.automation.pageobjects.HomePage;
import edu.mst.learning.automation.pageobjects.LeadPage;
import edu.mst.learning.automation.pageobjects.LoginPage;
import edu.mst.learning.automation.utilsclass.ExcelUtils;
/**
 * @author Jane hepsiba
 * Description:This class is used for base page access
 *
 */



public class BaseTest  {
	  

	public  static WebDriver driver;
	protected static ReportGenerator reporter;
	
	
    //ExtentReports extentReport;
	//protected static ExtentReport er;
	
	protected static LoginPage login;
	protected static HomePage home;
	protected LeadPage lead;
	
	@BeforeSuite
	
	public void beforeSuite() throws IOException {
		ExcelUtils.openExcel();                           //Called the excelutils class to open the excel
	}
	

    @Parameters ("browsertype")
	@BeforeTest
	
	public void beforeTest(driversupportedbrowser browsertype) throws InterruptedException, IOException {
 
    	driver = BrowserOpening.browserInvoke(browsertype);          // To call the Browseropening class
    	Thread.sleep(5000);
    	driver.get("https://login.salesforce.com/");        //To open the url
    	login = new LoginPage(driver);
    }
	
     @AfterTest
     
	public void afterTest() throws IOException {
    	
		 driver.quit();                              //To close the browsewr
		                        
		 }
     @AfterSuite
     public void afterSuite() throws IOException {
    	 ExcelUtils.closeExcel();                   //To close the excel
    	 reporter.flush();
    	 
     }
}
