/**
 * 
 */
package edu.mst.learning.automation.extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import edu.mst.learning.automation.basetest.BaseTest;

/**
 * @author Jane hepsiba 
 * Description:This class is for generating report
 * 
 */
public class ReportGenerator {

	ExtentTest childTest;
	ExtentTest parentTest;

	private static ExtentReports reporter = ExtentReportFactory.getReporter();

	public ReportGenerator(String methodName, String author, String tcID) {
		parentReport(methodName, author, tcID);
	}

	public void parentReport(String methodName, String author, String tcID) {
		parentTest = reporter.createTest(tcID + " - " + methodName);
		parentTest.assignAuthor(author);
		parentTest.assignCategory("Automation Test cases");
	}

	public void childReport(String methodName) {
		childTest = parentTest.createNode(methodName);
		childTest.log(Status.PASS, methodName);
	}
	
	public void flush() {
		reporter.flush();
	}

}
