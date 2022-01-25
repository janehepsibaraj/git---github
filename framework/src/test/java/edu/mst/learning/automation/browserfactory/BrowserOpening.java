package edu.mst.learning.automation.browserfactory;

import java.security.InvalidParameterException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeSuite;

import edu.mst.learning.automation.basetest.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;



/**
 * @author jane hepsiba
 * Description:This class is used for opening the browser
 *
 */
public class BrowserOpening {

        static WebDriver driver;
	
	   public enum driversupportedbrowser{
		       chrome,firefox,internetexplorer;   //to store the constants
	}
	
	
	
	public static WebDriver browserInvoke(driversupportedbrowser browsertype) {
		
		switch(browsertype) {
		case chrome:
			
			
			 WebDriverManager.chromedriver().setup();     //To get the chrome driver
			 driver = new ChromeDriver();
			 driver.manage().window().maximize();
			break;
			
		case firefox:
			
			WebDriverManager.firefoxdriver().setup();    //To get the firefox driver
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;
			
		case internetexplorer:
			
			
			WebDriverManager.iedriver().setup();        //To get the internet explorer driver
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			break;
			 
		default:
			throw new InvalidParameterException("You must choose any one of the browser type");
		
		}
		return driver;
	}
          

}
