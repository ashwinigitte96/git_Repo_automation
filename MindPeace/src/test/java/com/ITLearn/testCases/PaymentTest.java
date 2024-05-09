package com.ITLearn.testCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.ITLearn.pages.BaseTest;
import com.ITLearn.pages.DashboardPage;
import com.ITLearn.pages.LoginPage;
import com.ITLearn.pages.PaymentPage;
import com.ITLearn.utility.ReadExcelFile;

public class PaymentTest extends BaseTest {
	LoginPage lp;
	DashboardPage dp;
	PaymentPage pp;
	
	String fileName = System.getProperty("user.dir")+"\\TestData\\excelOfEclipse.xlsx";

	
//	@Test(priority = 1)
//	public void verifyPayment() throws Exception {
//		lp = new LoginPage(driver);
//		String userName = ReadExcelFile.getCellValue(fileName, "LoginData", 1, 0);
//		String password = ReadExcelFile.getCellValue(fileName, "LoginData", 1, 1);
//		lp.loginPortal(userName,password);
//		
//		dp = new DashboardPage(driver);
//		
//		dp.dashboardOperation();
//		Thread.sleep(2000);
//		dp.handleDropdown();
//		Thread.sleep(2000);
//		dp.subscribeCourse();
//		Thread.sleep(2000);
//		pp = new PaymentPage(driver);
//		pp.stripeClick();
//		Thread.sleep(2000);
//		pp.placeOrder();
//		
//		if(pp.payWithStripeForm.isDisplayed()) {
//			Assert.assertTrue(true);
//		}
//		}
	
	
	//Verify on entering invalid card Number it displays error message as "Your card number is invalid."
	@Test(priority = 2)
	public void VerifyByEnteringInvalidCardNumber() throws Exception {
		lp = new LoginPage(driver);
		String userName = ReadExcelFile.getCellValue(fileName, "LoginData", 1, 0);
		String password = ReadExcelFile.getCellValue(fileName, "LoginData", 1, 1);
		String email = ReadExcelFile.getCellValue(fileName, "AllUrls", 1, 2);
		String errmsg = ReadExcelFile.getCellValue(fileName, "AllUrls", 1, 3);
		
		String cardNum = config.getCardNum();
		
		lp.loginPortal(userName,password);
		
		dp = new DashboardPage(driver);
		
		dp.dashboardOperation();
		Thread.sleep(2000);
		dp.handleDropdown();
		Thread.sleep(2000);
		dp.subscribeCourse();
		Thread.sleep(2000);
		pp = new PaymentPage(driver);
		pp.stripeClick();
		Thread.sleep(2000);
		
		pp.placeOrder();
		pp.enterEmail(email);
		switchToIframe(pp.cardDetails_Iframe);
		pp.enterCardNumber(cardNum);
		switchToParentFrame();
		System.out.println(pp.errMsg_card.getText());
		if(pp.errMsg_card.getText().equalsIgnoreCase(errmsg))
		Assert.assertTrue(true);
		}
	
	
	
}
