package com.ITLearn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {

	
	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
		PageFactory.initElements(driver, this);
	}


@FindBy(xpath="//a[@class='lg_button' and text()='Log in']")
WebElement lg_Btn ;

@FindBy(xpath="//input[@id='user_login' and @class='input required']")
WebElement user_Name;

@FindBy(xpath="//input[@class='input required' and @id='user_pass']")
WebElement passwd;

@FindBy(xpath="//input[@id='wp-submit']")
WebElement login_Btn;

@FindBy(xpath="//i[@class='fa fa-user']")
WebElement userIcon;

@FindBy(xpath="//a[text()='Logout']")
WebElement logout;





public void loginPortal(String username, String password) throws InterruptedException {
	try{
		lg_Btn.click();
	}catch(Exception e) {
		System.out.println("lg_Btn not working..." + e.getMessage());
	}
	Thread.sleep(3000);
	user_Name.sendKeys(username);
	Thread.sleep(3000);
	passwd.sendKeys(password);
	Thread.sleep(3000);
	login_Btn.click();
}
public void logout() throws InterruptedException {
	userIcon.click();
	Thread.sleep(3000);
	logout.click();
}
}
