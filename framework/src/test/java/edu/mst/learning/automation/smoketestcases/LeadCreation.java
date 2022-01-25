/**
 * 
 */
package edu.mst.learning.automation.smoketestcases;

import org.testng.annotations.Test;

import edu.mst.learning.automation.basetest.BaseTest;
//import edu.mst.learning.automation.extentreport.ExtentReport;
import edu.mst.learning.automation.extentreport.ReportGenerator;
//import edu.mst.learning.automation.extentreport.ExtentReport;
//import edu.mst.learning.automation.extentreport.ReportsGenerator;
//import edu.mst.learning.automation.pageobjects.LoginPage;

/**
 * @author Jane hepsiba 
 * Description: This class is for smoketestcases
 */
public class LeadCreation extends BaseTest {

	@SuppressWarnings("static-access")
	@Test

	public void creatingLead() throws InterruptedException {

		// To get the current running method name
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String tcID = "TC_001", author = "Jane hepsiba", category = "SmokeSuite";

		reporter = new ReportGenerator(methodName, author, tcID);
		home = login.salesforceLoginPage();
		reporter.childReport("Logged into SF");
		lead = home.verifyLead();
		lead.leadCreation(reporter, methodName, tcID);
	}
}
