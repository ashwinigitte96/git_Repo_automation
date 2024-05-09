package com.ITLearn.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePaymentMethodPage extends BaseTest{
	
	public ChangePaymentMethodPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'Change Payment Method')]")
	WebElement ele_changepaymnt;
	
	@FindBy(xpath = "//input[@id='learn-press-change-card-detail']")
	WebElement changeCardDetails;
	
	@FindBy(name="spemail")
	WebElement email;
	
	@FindBy(xpath = "//iframe[@title='Secure card payment input frame']")
	WebElement iframe_expAndCvv;
	
	@FindBy(xpath="//div[@class='StripeElement StripeElement--empty']")
	WebElement txt_cardNumber;
	
	@FindBy(xpath="//input[@name='exp-date']")
	WebElement txt_expDate;
	
	@FindBy(xpath="//input[@name='cvc']")
	WebElement txt_cvc;
	
	@FindBy(xpath = "//button[@class='btn btn-secondary']")
	WebElement payCancel_btn;
	
	@FindBy(xpath = "//button[@id='payment-button']")
	WebElement payNow_btn;
	
public void click_ele_changepaymnt() throws InterruptedException  {
	//System.out.println(driver.getCurrentUrl());
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);",ele_changepaymnt);
    js.executeScript("arguments[0].click();",ele_changepaymnt);
	
}
public void click_changeCardDetails() throws Exception {
	
	try {
		changeCardDetails.click();
		Thread.sleep(2000);
	}catch(Exception e) {
		throw new Exception("click_changeCardDetails() not working...."+ e.getMessage());
	}
}
public void enter_email(String strvalue) throws Exception {
	try {
		
		email.click();
		
		email.clear();
		email.sendKeys(strvalue);
		
		
	}catch(Exception e) {
		throw new Exception(" click_email() not working...."+ e.getMessage());
	}
}
public void enter_txt_cardNumber() throws Exception {
	try {
		
   // driver.switchTo().frame(iframe_cardNum);
		
		String cardNum = config.getCardNum();
	
		Actions act = new Actions(driver);
		act.sendKeys(txt_cardNumber,cardNum).build().perform();
		
	//	txt_cardNumber.sendKeys(cardNum);
		Thread.sleep(5000);
		}catch(Exception e) {
			throw new Exception("enter_txt_cardNumber() not working...."+ e.getMessage());
		}
}
public void enter_txt_expDate() throws Exception {
	try{
		driver.switchTo().frame(iframe_expAndCvv);
		String expDate = config.getexpDate();
	Actions act = new Actions(driver);
	act.sendKeys(txt_expDate, expDate).build().perform();
	Thread.sleep(2000);
	}catch(Exception e) {
		throw new Exception("enter_txt_expDate() not working...."+ e.getMessage());
	}
}
public void enter_txt_cvc() throws Exception {
	try {
		System.out.println(driver.getCurrentUrl());
		String cvc = config.getcvc();
		Actions act = new Actions(driver);
		act.sendKeys(txt_cvc,cvc).build().perform();
		Thread.sleep(3000);
	}catch(Exception e) {
		throw new Exception("enter_txt_cvc() not working...."+ e.getMessage());
	}
}
public void click_payCancel_btn() {
	try {
		driver.switchTo().parentFrame();
		waitUntilElementIsAvailable(payCancel_btn);
		payCancel_btn.click();
		Thread.sleep(3000);
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
	
}
}
