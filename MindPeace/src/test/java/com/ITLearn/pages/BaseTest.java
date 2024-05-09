package com.ITLearn.pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.ITLearn.utility.BrowserFactory;
import com.ITLearn.utility.ConfigDataProvider;

public class BaseTest {
public WebDriver driver;
	
	public ConfigDataProvider config = new ConfigDataProvider() ; //created to call non-static methods

	@BeforeClass 
	//used to open the path of driver and websites
	public void setUp() {
		driver = BrowserFactory.startApplication(driver,config.getBrowser(),config.getStagingUrl());
	}
	// here @Test annotation that means test cases part will be running i.e S T C M @T M C T S
	@AfterClass
	//used to put closing part
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}
	
	 public void captureScreenShot(WebDriver driver,String testName) throws IOException
	 {
		 // Convert webdriver object to TakesScreenshot interface
		 TakesScreenshot screenshot= ((TakesScreenshot)driver);
		 
		 // Step 2 :call getScreenshotAs method to capture image file
		 
		 File src= screenshot.getScreenshotAs(OutputType.FILE);
		 File srcpath=new File("."+"//Screenshots//"+ testName + ".png");
		 
		 // Step 3 : copy image file to destination 
		 FileUtils.copyFile(src, srcpath);
		 
	 }
	 public void methodscrollTillThisElement(WebElement ele) throws InterruptedException {
	
				JavascriptExecutor js = (JavascriptExecutor)  driver;
				js.executeScript("arguments[0].scrollIntoView(true);", ele);
				js.executeScript("arguments[0].click()", ele);
				
				Thread.sleep(5000);
			
			}
	 public WebElement waitUntilElementIsAvailable(WebElement first_Name) throws Exception {
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
				WebElement ele= wait.until(ExpectedConditions.elementToBeClickable(first_Name));
				return ele;
				
			} catch(Exception e) {
				driver.switchTo().defaultContent();
				throw new Exception("WebElement is not found....locator details::" + first_Name + e);
			}
		}
	 public WebElement waitUntilElementIsEnabled(WebElement ele) throws Exception {
		 try {
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ele));
			 return ele;
			 
		 }catch(Exception e) {
			 throw new Exception("WebElement not clickable...."+ e.getMessage());
		 }
		 
	 }
	 public void setValue(WebElement ele, String value) throws InterruptedException {
		 try {
		 ele.clear();
		 ele.sendKeys(value);
		 waitTime(3);
		} catch(Exception e) {
			 System.out.println("setValue not working"+ e.getMessage());
		 }
		 
	 }
	 
	 public void waitTime(int secs) throws InterruptedException {
			Thread.sleep(secs * 1000);
		}
	 
	 public void selec_dropdown_byIndex(WebElement drpdown, int indexValue) throws InterruptedException {
		try {
			isElementDisplayed(drpdown);
		 Select drp = new Select(drpdown);
	     drp.selectByIndex(indexValue);
		}catch(Exception e) {
			System.out.println("selec_dropdown_byIndex not working" + e.getMessage());
		}
	 }
	 
	 public void select_dropdownByValue(WebElement drpdwn, String strValue) {
		 try {
			 isElementDisplayed(drpdwn);
			 Select drp = new Select(drpdwn);
			 drp.selectByValue(strValue);
		 }catch(Exception e) {
			 System.out.println("select_dropdownByValue not working....."+ e.getMessage());
		 }
	 }
	 
	 public void isElementDisplayed(WebElement ele) throws InterruptedException {
		 waitTime(3);
		 try {
		 ele.isDisplayed();
		 }
		 catch(Exception e) {
			 System.out.println("isElementDisplayed"+ e.getMessage());
		 }
	 }
	 
	 public void switchToIframe(WebElement iframe) throws Exception {
		 waitUntilElementIsAvailable(iframe);
		 driver.switchTo().frame(iframe);
	 }
	 
	 public void switchToParentFrame() throws Exception {
	
		 driver.switchTo().parentFrame();
	 }
	 
	
	
	 
		
}
