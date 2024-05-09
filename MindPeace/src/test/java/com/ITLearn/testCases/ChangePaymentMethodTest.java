package com.ITLearn.testCases;

import org.testng.annotations.Test;

import com.ITLearn.pages.BaseTest;
import com.ITLearn.pages.ChangePaymentMethodPage;
import com.ITLearn.pages.DashboardPage;
import com.ITLearn.pages.LoginPage;
import com.ITLearn.utility.ReadExcelFile;

public class ChangePaymentMethodTest extends BaseTest {
String fileName = System.getProperty("user.dir")+"\\TestData\\excelOfEclipse.xlsx";
	
	
	@Test(priority = 1)
	public void verify_ChangeCardDetailsAndCancel() throws Exception {
		
		String userName = ReadExcelFile.getCellValue(fileName, "LoginData", 1, 0);
		String passwd = ReadExcelFile.getCellValue(fileName, "LoginData", 1, 1);
		String email = ReadExcelFile.getCellValue(fileName, "AllUrls",1, 2);
		//double cardNum = ReadExcelFile.getNumericData("LoginData",1, 5);
		LoginPage lp = new LoginPage(driver);
		lp.loginPortal(userName, passwd);
		DashboardPage dp = new DashboardPage(driver);
	
		dp.dashboardOperation();
		ChangePaymentMethodPage cpmt = new ChangePaymentMethodPage(driver);
		
		cpmt.click_ele_changepaymnt();
		cpmt.click_changeCardDetails();
		cpmt.enter_email(email);
		cpmt.enter_txt_cardNumber();
		cpmt.enter_txt_expDate();
		cpmt.enter_txt_cvc();
		cpmt.click_payCancel_btn();
		
	
		
		lp.logout();
	}

}
