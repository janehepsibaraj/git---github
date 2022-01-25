/**
 * 
 */
package edu.mst.learning.automation.extentreport;

import java.io.File;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


import edu.mst.learning.automation.basetest.BaseTest;
import edu.mst.learning.automation.constant.Constant;

/**
 * @author Jane hepsiba 
 * Description:This class is for extent report
 * 
 */
public class ExtentReportFactory {

	private static ExtentHtmlReporter htmlReporter;

	private static ExtentReports reporter;

	public static synchronized ExtentReports getReporter() {
		try {
			String workspace = ((new File(".").getAbsolutePath()).replace("\\", "/")).replace(".", "");
			String fileName = workspace + "src/test/resources/Report/extent_config.xml";
			File file = new File(fileName);
			if (reporter == null) {
				htmlReporter = new ExtentHtmlReporter(Constant.REPORTPATH);
				htmlReporter.loadXMLConfig(file);
				reporter = new ExtentReports();
				reporter.attachReporter(htmlReporter);
				reporter.setSystemInfo("Author", "Jane Hepsiba");
				reporter.setSystemInfo("User Name", "Automation");
				reporter.setSystemInfo("Environment", "QA");
				reporter.setSystemInfo("Selenium Version", "3.4.0");
				reporter.setAnalysisStrategy(AnalysisStrategy.CLASS);
			}
		}
		catch (Exception error) {
			System.out.println("" + error);
		}
		return reporter;

	}

}
