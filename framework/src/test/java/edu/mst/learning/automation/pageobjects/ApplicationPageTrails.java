package edu.mst.learning.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ApplicationPageTrails {
	WebDriver driver;

	public void main(String[] args) throws InterruptedException {
		
         WebDriverManager.chromedriver().setup();     //To get the chrome driver
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();

	     driver.get("https://sumathinco-developer-edition.na172.force.com/s/login/");
	     driver.findElement(By.xpath("//a[text()='Application Status']")).click();
	     driver.findElement(By.xpath("//div[text()='New']")).click();
	     Thread.sleep(5000);
	     WebElement element = driver.findElement(By.xpath("//span[text()='Save']"));
	     element.click();
	     String actualAlert = element.getText();
	     JavascriptExecutor js = (JavascriptExecutor)driver; 
		 js.executeScript("arguments[0].setAttribute('style','background: green; border: 2px solid green;');", element);

			

     }
}
