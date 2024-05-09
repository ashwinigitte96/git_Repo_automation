package com.ITLearn.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ITLearn.pages.BaseTest;
import com.ITLearn.pages.DashboardPage;
import com.ITLearn.pages.LoginPage;
import com.ITLearn.pages.SettingPage;
import com.ITLearn.utility.ReadExcelFile;

public class SettingTest extends BaseTest {
String fileName = System.getProperty("user.dir")+"\\TestData\\excelOfEclipse.xlsx";
	
	

	@Test(priority=1)
	public void clickSettings() throws Exception {
		String uname = ReadExcelFile.getCellValue(fileName, "LoginData", 1, 0);
		String passwd = ReadExcelFile.getCellValue(fileName, "LoginData", 1, 1);
		
		LoginPage lp = new LoginPage(driver);
		lp.loginPortal(uname, passwd);
		
		DashboardPage dp = new DashboardPage(driver);
		dp.dashboardOperation();
		
		SettingPage stp = new SettingPage(driver);
		stp.settingsClick();
		stp.fname_Update();
		stp.lname_Update();
		stp.nickName_Update();
		stp.description_update();
		stp.selectNameToDisplay();
		stp.click_Update_Btn();
	
		lp.logout();//add this to end of test
		}
	@Test(priority=1)
	public void verifyUpdadteAndRemoveAvatar() throws Exception {
		String uname = ReadExcelFile.getCellValue(fileName, "LoginData", 1, 0);
		String passwd = ReadExcelFile.getCellValue(fileName, "LoginData", 1, 1);
		
		LoginPage lp = new LoginPage(driver);
		lp.loginPortal(uname, passwd);
		
		DashboardPage dp = new DashboardPage(driver);
		dp.dashboardOperation();
		
		SettingPage stp = new SettingPage(driver);
		stp.settingsClick();
		
		stp.changeAvatar();
		stp.avatarUpdateBtnClick();
		stp.removeUploadedAvatar();
		stp.avatarUpdateBtnClick();
		lp.logout();
	}
	@Test
	public void verifyChangePwd() throws Exception {
		String uname = ReadExcelFile.getCellValue(fileName, "update password", 1, 0);
		String old_passwd = ReadExcelFile.getCellValue(fileName, "update password", 1, 1);
		String new_pwd = ReadExcelFile.getCellValue(fileName, "update password", 1, 2);
		LoginPage lp = new LoginPage(driver);
		lp.loginPortal(uname, old_passwd);
		
		DashboardPage dp = new DashboardPage(driver);
		dp.dashboardOperation();
		
		SettingPage stp = new SettingPage(driver);
		stp.settingsClick();
		stp.changepwd_col_Click();
		stp.enter_current_pwd(old_passwd);
		stp.enter_new_pwd(new_pwd);
		stp.method_retype_new_pwd(new_pwd);
		stp.click_update_pwd_btn();
		String str = ReadExcelFile.getStringData("update password", 1, 3);
	
		Assert.assertEquals(stp.pwdUpdatedTxt.getText(), str);
			
		
		
		stp.enter_current_pwd(new_pwd);
		stp.enter_new_pwd(old_passwd);
		stp.method_retype_new_pwd(old_passwd);
		stp.click_update_pwd_btn();
		Assert.assertEquals(stp.pwdUpdatedTxt.getText(), str);
		lp.logout();
	}

	
		
	
	
}
