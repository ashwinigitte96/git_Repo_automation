package com.ITLearn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ITLearnLandingPage extends BaseTest {

	public ITLearnLandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"logo\" and @class='logo desktop-hide']//a//span")
	 WebElement itLearnLogo;
	
	@FindBy(xpath = "//*[@id=\"primary_menu\"]/a")
	WebElement allCourcesBtn;
	
	
	public void isLogoDisplayed() throws Exception {
		waitUntilElementIsAvailable(itLearnLogo);
	}
	public String getTextOnLogo() {
		return itLearnLogo.getText();
	}
	
	public void isAllCourcesBtnDisplayed() throws Exception {
		waitUntilElementIsAvailable(allCourcesBtn);
	}
	public String allCourcesBtnText() {
		return allCourcesBtn.getText();
	}
	
}
