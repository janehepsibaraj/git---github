/**
 * 
 */
package edu.mst.learning.automation.abstractclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;

import edu.mst.learning.automation.basetest.BaseTest;

/**
 * @author Jane hepsiba
 * Description: This class is for driver session
 *
 */

public abstract class DriverClass {
	
	protected static WebDriver driver;
	 
       public DriverClass(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);      //to intialiaze pageobjects
			
		}                                                 // this refers to define the current class objects
		                                       
		
	}


