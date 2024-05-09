package com.ITLearn.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BaseTest {

	public PaymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//label[@for='payment_method_stripe']")
	public WebElement payment_method_stripe;

	@FindBy(xpath = "//input[@class='button alt onpayment']")
	WebElement place_Order;

	@FindBy(xpath = "//input[@name='spemail']")
	WebElement email;

	@FindBy(xpath = "//form[@id='smform']")
	public WebElement payWithStripeForm;

	

	@FindBy(xpath = "//input[@name='cardnumber']")
	WebElement txt_cardNumber;
	
	@FindBy(xpath="//input[@name='exp-date']")
	WebElement txt_expDate;
	
	@FindBy(xpath="//input[@name='cvc']")
	WebElement txt_cvc;
	
	@FindBy(xpath = "//button[@class='btn btn-secondary cancelpf']")
	WebElement cancelPay;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement payNmow;
	
	@FindBy(xpath = "//span[text()='Your card number is invalid.']")
	public WebElement errMsg_card;
	
	@FindBy(xpath = "//*[@id=\"card-element\"]/div/iframe")
	public WebElement cardDetails_Iframe;
	
	public void stripeClick() throws IOException {

		// if (payment_method_stripe.isDisplayed() && payment_method_stripe.isEnabled())
		// {
		try {

			waitUntilElementIsAvailable(payment_method_stripe);
			Thread.sleep(2000);
			payment_method_stripe.click();

		} catch (Exception e) {
			System.out.println("stripeClick() method not working..."+e.getMessage());
			captureScreenShot(driver, "subscribeCourse");
			
            
		}
	}

	// }
	public void placeOrder() throws InterruptedException {
		
        methodscrollTillThisElement(place_Order);
		//place_Order.click();
	}
	
	public void enterEmail(String emaill) throws Exception {
		try {
		waitUntilElementIsAvailable(email);
		email.clear();
		email.sendKeys(emaill);
		}catch(Exception e) {
			System.out.println("enterEmail not working...."+ e.getMessage());
			captureScreenShot(driver, "enterEmail");
		}
	}
	
	public void enterCardNumber(String cardNum) throws IOException {
		try {
			
			//waitUntilElementIsAvailable(txt_cardNumber);
			
			txt_cardNumber.sendKeys(cardNum);
		
		}catch(Exception e) {
			System.out.println("enterCardNumber not working...."+e.getMessage());
			captureScreenShot(driver, "enterCardNumber");
		}
	}
	public void enterExpDate(String expDate) throws IOException {
		try {
		
			waitUntilElementIsAvailable(txt_expDate);
			txt_expDate.sendKeys(expDate);
		}catch(Exception e) {
			System.out.println("enterExpDate not working...."+e.getMessage());
			captureScreenShot(driver, "enterExpDate");
		}
	}
	public void enterCvc(String CVC) throws IOException {
		try {
			waitUntilElementIsAvailable(txt_cvc);
			txt_cvc.sendKeys(CVC);
		}catch(Exception e) {
			System.out.println("enterCvc not working..."+ e.getMessage());
			captureScreenShot(driver,"enterCvc");
		}
	}
	
	public void cancelButtonClick() {
		try {
			driver.switchTo().parentFrame();
			waitUntilElementIsAvailable(cancelPay);
			cancelPay.click();
		}catch(Exception e) {
			System.out.println("cancelButtonClick not working...."+ e.getMessage());
		}
	}
	

	

}
