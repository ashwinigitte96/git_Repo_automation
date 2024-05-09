package MindPeace.MindPeace;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetAllUrlsOnPage {
	static WebDriver driver;
	@BeforeTest
	public static void googlelaunch() {
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	
	@Test(priority = 1)
	public void getAllURLsOnPage() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for(WebElement link:links) {
			
			System.out.println(link.getText()+"-"+ link.getAttribute("href"));
		}
	}
	
	
	@AfterSuite
	public void tearDownEnv() {
		driver.quit();
	}
}
