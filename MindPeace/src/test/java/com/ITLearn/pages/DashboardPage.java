package com.ITLearn.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BaseTest {

	BaseTest bt = new BaseTest();

	@FindBy(xpath = "//a[contains(text(),'Dashboard')]")
	WebElement dashboard_Btn;

	@FindBy(xpath = "//ul[@class='tabs learn-press-tabs clearfix border-radius-sm']")
	WebElement dashboard;

	@FindBy(xpath = "//ul[@class='tabs learn-press-tabs clearfix border-radius-sm']//li")
	WebElement dashboard_list;

	@FindBy(xpath = "//h3[contains(text(),'Software Testing Academy')]//following-sibling::form//child::div[@class='subs_button']//child::button[contains(text(),'Subscribe Now')]")
	WebElement subscribe_Course;

	@FindBy(xpath="//h4[@class='user-nicename duserp']")
	public
	WebElement avatar_name;
	
	
	public String avtrName;

	

	public DashboardPage(WebDriver ldriver) {
		this.driver = ldriver;
		PageFactory.initElements(driver, this);
	}

	public void dashboardOperation() throws Exception {
		try {
		dashboard_Btn.click();
		  avtrName = avatar_name.getText();
		
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		Thread.sleep(2000);
	}

	public boolean handleDropdown() throws Exception {
		List<WebElement> options = driver
				.findElements(By.xpath("//ul[@class='tabs learn-press-tabs clearfix border-radius-sm']//li"));

		for (WebElement option : options) {

			if (option.getText().equals("Offered Academies")) {
				try {
					option.click();
					System.out.println("try block is running bcoz element is able to click");
					return true;

				} catch (Exception e) {
					bt.captureScreenShot(driver, "verifyDashboard");
					System.out.println("catch block is running bcoz element is not able to click");
					return true;
				}
			}
		}
		return true;
	}

	public void subscribeCourse() throws Exception {
		
		
		try {
			
		subscribe_Course.click();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		

	}
		

}
