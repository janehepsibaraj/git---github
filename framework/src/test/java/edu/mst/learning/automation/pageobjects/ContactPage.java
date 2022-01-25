/**
 * 
 */
package edu.mst.learning.automation.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Jane hepsiba
 * Description:
 * 
 */
public class ContactPage {
	@FindBy(how=How.CSS,using ="div.slds-icon-waffle" )
	public WebElement AppLauncher;

	@FindBy(how=How.XPATH,using ="//input[@class='slds-input']")
	public WebElement Search; 

	@FindBy(how=How.XPATH,using="//p[@class ='slds-truncate']")
	public WebElement Contacts;

	@FindBy(how=How.XPATH,using="//div[text()='New']")
	public WebElement New;
	
	@FindBy(how=How.NAME,using="lastName")
	public WebElement lastName;
	
	@FindBy(how=How.NAME,using="Phone")
	public WebElement Phone;
	
	@FindBy(how=How.ID,using="input-457")
	public WebElement SearchAccounts;
	
	@FindBy(how=How.NAME,using ="saveEdit")
	public WebElement save;
	
	public void ContactCreation() {
		  Search.sendKeys("Contacts");
		  Contacts.click();
		  New.click();
		  lastName.sendKeys("Ken");
		  Phone.sendKeys("9632568912");
		  Select Account = new Select (SearchAccounts);
	      SearchAccounts.click();
	      Account.selectByIndex(1);
	      save.click();
		  
	}

}
