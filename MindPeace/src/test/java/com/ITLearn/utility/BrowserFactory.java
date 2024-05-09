package com.ITLearn.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
public static WebDriver startApplication(WebDriver driver,String browserName,String appUrl) {
		
		if(browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			ChromeOptions op = new ChromeOptions();
			
			driver = new ChromeDriver(op);
			
		} else if(browserName.equals("Firefox")) {
			System.setProperty("webdriver.chrome.driver", "browser path");
			driver = new FirefoxDriver();
			
		} else if(browserName.equals("Edge")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/msedgedriver.exe");
			driver = new EdgeDriver();
			
		}else {
			System.out.println("we do not support this browser");
		}
		
		driver.manage().window().maximize();
		driver.get(appUrl);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		
		return driver;
	}
	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}
}
