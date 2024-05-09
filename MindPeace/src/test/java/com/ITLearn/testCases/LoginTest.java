package com.ITLearn.testCases;

import org.testng.annotations.Test;

import com.ITLearn.pages.BaseTest;
import com.ITLearn.pages.LoginPage;

public class LoginTest extends BaseTest {
	@Test
	public void verifyLogin() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		String username = "Demo12";
		String passwordd = "Test123456$";
		lp.loginPortal(username, passwordd);
		lp.logout();
		
	}
}
