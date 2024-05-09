package com.ITLearn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BaseTest {
	

	@FindBy(xpath = "//input[@class='search_course_mobile_hidden border-radius-sm']")
	WebElement searchCourse;

	@FindBy(xpath = "//input[@class='search_course_mobile_hidden border-radius-sm']//following-sibling::button")
	WebElement searchCourse_SearchIcon;

	public SearchPage(WebDriver sdriver) {
		this.driver = sdriver;
		PageFactory.initElements(driver, this);
	}

	public void searchCourse(String courseName) throws InterruptedException {
		searchCourse.sendKeys(courseName);
		Thread.sleep(3000);
		searchCourse_SearchIcon.click();
		Thread.sleep(3000);
		String url_HTML_For_Beginners = driver.getCurrentUrl();

	}

	public String get_url_courseResult() {
		String url_HTML_For_Beginners= driver.getCurrentUrl();
		try {
		 url_HTML_For_Beginners = driver.getCurrentUrl();
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return url_HTML_For_Beginners;
		
	}
}
