/**
 * 
 */
package edu.mst.learning.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import edu.mst.learning.automation.abstractclass.DriverClass;
import edu.mst.learning.automation.basetest.BaseTest;

/**
 * @author Jane hepsiba Description:This class is used for login page access
 *
 */
public class LoginPage extends DriverClass { // extended the DriverClass

	public LoginPage(WebDriver driver) {
		super(driver); // used constructor and super keyword

		// super keyword is used to define the methods of parent class
	}

	@FindBy(how = How.ID, using = "username")
	public static WebElement username; // To get the attribute using @FindBy

	@FindBy(how = How.ID, using = "password")
	public static WebElement password;

	@FindBy(how = How.ID, using = "Login")
	public static WebElement Login;

	public HomePage salesforceLoginPage() throws InterruptedException { // method used to login the salesforce

		Thread.sleep(3000);
		username.sendKeys("janehepsiba.a@mstsolutions.com");
		password.sendKeys("janeselvi@2417");
		Login.click();
		return new HomePage(driver);

	}

}
