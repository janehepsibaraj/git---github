/**
 * 
 */
package edu.mst.learning.automation.pageobjects;

import org.openqa.selenium.WebDriver;

import edu.mst.learning.automation.abstractclass.DriverClass;
import edu.mst.learning.automation.basetest.BaseTest;

/**
 * @author Jane hepsiba
 * Description: This class is for Home page 
 * 
 */
public class HomePage extends DriverClass {               //entended the driverclass
	
	
	public HomePage(WebDriver driver) {                   //Constructor for homepage
		super(driver);
		 
   }

    public LeadPage verifyLead() throws InterruptedException {           
    	Thread.sleep(5000);
		return new LeadPage(driver);
	}

}
