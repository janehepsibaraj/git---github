/**
 * 
 */
package edu.mst.learning.automation.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import edu.mst.learning.automation.abstractclass.DriverClass;
import edu.mst.learning.automation.basetest.BaseTest;
import edu.mst.learning.automation.extentreport.ReportGenerator;
import edu.mst.learning.automation.utilsclass.ExcelUtils;

/**
 * @author Jane hepsiba 
 * Description: This page is to create a lead record
 * 
 */

public class LeadPage extends DriverClass {           // extended the driverclass

	public LeadPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//div[@class='slds-icon-waffle']")
	public static WebElement appLauncher;

	@FindBy(how = How.XPATH, using = "//input[@class='slds-input']")
	public static WebElement Search;

	@FindBy(how = How.XPATH, using = "//p[@class ='slds-truncate']")
	public static WebElement Leads;

	@FindBy(how = How.XPATH, using = "//div[text()='New']")
	public static WebElement New;

	@FindBy(how = How.XPATH, using = "//input[@name='firstName']")
	public static WebElement firstName;

	@FindBy(how = How.XPATH, using = "//input[@name='lastName']")
	public static WebElement lastName;

	@FindBy(how = How.XPATH, using = "//input[@name='Company']")
	public static WebElement company;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Lead Status')]/following::input[1]")
	public static WebElement LeadStatus;

	@FindBy(how = How.XPATH, using = "//span[@title='Working - Contacted']")
	public static WebElement LeadStatusValue;

	@FindBy(how = How.XPATH, using = "//button[text()='Save']")
	public static WebElement save;

	public static void leadCreation(ReportGenerator reporter, String sheet, String testcaseID)
			throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		appLauncher.click();
		reporter.childReport("Click AppLauncher");
		Search.sendKeys("Leads");
		reporter.childReport("Click on the Lead search button");
		Leads.click();
		reporter.childReport("Click on the Leads button");
		New.click();
		reporter.childReport("Click on the New button");
		firstName.sendKeys(ExcelUtils.readExcel(sheet, testcaseID, "FirstName")); // got the values from excelutilsclass
		reporter.childReport("Enter the value in firstname");
		lastName.sendKeys(ExcelUtils.readExcel(sheet, testcaseID, "LastName"));
		reporter.childReport("Enter the value in lastName");
		company.sendKeys(ExcelUtils.readExcel(sheet, testcaseID, "Company"));
		reporter.childReport("Enter the value in company");

		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();          // used actions class for scrolling down the page
		Thread.sleep(5000);
		LeadStatus.click();
		reporter.childReport("Click on the Lead status value");
		LeadStatusValue.click();
		reporter.childReport("Choose the Value Working - Contacted");

		save.click();
		reporter.childReport("Click on the save button");
		Thread.sleep(2000);
	}
}

