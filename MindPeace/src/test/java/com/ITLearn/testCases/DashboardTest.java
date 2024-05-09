package com.ITLearn.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ITLearn.pages.BaseTest;
import com.ITLearn.pages.DashboardPage;
import com.ITLearn.pages.LoginPage;
import com.ITLearn.utility.ReadExcelFile;

public class DashboardTest extends BaseTest {
String fileName = System.getProperty("user.dir")+"\\TestData\\excelOfEclipse.xlsx";
	
	@Test(priority = 4)
	public void verifyDashboard() throws Exception {
		LoginPage lp = new LoginPage(driver);
		String username = ReadExcelFile.getCellValue(fileName,"LoginData", 1, 0);
		String password = ReadExcelFile.getCellValue(fileName,"LoginData", 1, 1);
		lp.loginPortal(username,password);
		
		DashboardPage dp = new DashboardPage(driver);
		dp.dashboardOperation();
		String dashboardTitle = ReadExcelFile.getCellValue(fileName,"AllUrls", 1, 1);
		String titleOfDashBrdPage = driver.getTitle();
		System.out.println(titleOfDashBrdPage);
		Assert.assertEquals(titleOfDashBrdPage,dashboardTitle);
		
		dp.handleDropdown();
		dp.subscribeCourse();
		
		lp.logout();
		
	}
}
