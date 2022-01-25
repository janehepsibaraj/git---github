/**
 * 
 */
package edu.mst.learning.automation.utilsclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


/**
 * @author Jane hepsiba
 * Description: Class used for having all selenium methods
 *
 */
public class SeleniumUtils {

	WebDriver driver;
	
	public void alertAccept() {           //method used for alert
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
	public void dropDown() {                // method used for dropdown
		Select continents = new Select(driver.findElement(By.name("continents")));
		continents.selectByIndex(2);
		continents.selectByVisibleText("North America");
	}
	public void multiSelect() {               //method used to select multiple elements in the dropdown
		WebElement seleniumCommands = driver.findElement(By.name("selenium_commands"));
		Select commands = new Select(seleniumCommands);
		commands.selectByIndex(2);
		commands.selectByVisibleText("WebElement Commands");
		commands.selectByVisibleText("Wait Commands");
		
	}
	 public void windowHandle() {             // method used for window handling
		String currentWindow = driver.getWindowHandle();
		
		Set<String> allWindowhandles = driver.getWindowHandles();
				
		for(int i=0;i<allWindowhandles.size();i++) {
			String windowhandle = allWindowhandles.toArray()[i].toString();
			System.out.println(windowhandle);
			if(!windowhandle.equals(currentWindow)) {
				driver.switchTo().window(windowhandle);
				System.out.println(driver.findElement(By.id("sampleHeading")).getText());
				driver.close();
			}
		}
		
		driver.switchTo().window(currentWindow);
	}
	  public void frameHandle() {                 //method used for framehandling
		WebElement topWindowElement = driver.findElement(By.xpath("//div[contains(text(),'Sample Iframe page There are 2 Iframes in this pag')]"));
		System.out.println(topWindowElement.getText());
		
		driver.switchTo().frame(1);
		WebElement ElementInFrameOne = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		System.out.println("Frame1 Text: "+ElementInFrameOne.getText());
		
		driver.switchTo().defaultContent();
		System.out.println(topWindowElement.getText());
		
	}
	  public void robot() throws Exception {           //method used for robotclass
		 Actions a = new Actions(driver);
		 a.moveToElement(driver.findElement(By.id("uploadPicture"))).click().build().perform();
			
			StringSelection s= new StringSelection("D:\\text2.txt");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
			
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
			
			}
	 public static void checkboxChecked(WebElement element, WebDriver driver) throws Exception{    //method used for checkbox
              boolean checkStatus;
	        checkStatus=element.isSelected(); 
	        if(checkStatus == false){
	            element.click();
	        }
	    }
		
	}

	




	
	


