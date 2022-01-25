/**
 * 
 */
package edu.mst.learning.automation.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Jane hepsiba
 * Description:
 * 
 */
public class AccountPage {
	@FindBy(how=How.CSS,using ="div.slds-icon-waffle" )
	public WebElement AppLauncher;

	@FindBy(how=How.XPATH,using ="//input[@class='slds-input']")
	public WebElement Search; 

	@FindBy(how=How.XPATH,using="//p[@class ='slds-truncate']")
	public WebElement Accounts;

	@FindBy(how=How.XPATH,using="//div[text()='New']")
	public WebElement New;
	
	@FindBy(how=How.XPATH,using="//input[@name='Name']")
	public WebElement Name;
	
	@FindBy(how=How.XPATH,using="//input[@name='Phone']")
	public WebElement Phone;
	
	@FindBy(how=How.XPATH,using="//input[@name='Site']")
	public WebElement Site;
	
	@FindBy(how=How.NAME,using ="saveEdit")
	public WebElement save;
	
	 public void AccountCreation() {
		  Search.sendKeys("Accounts");
		  Accounts.click();
		  New.click();
		  Name.sendKeys("Test Account");
		  Phone.sendKeys("9876543210");
		  Site.sendKeys("Arizona");
		  save.click();
		  
		

	
}

}
