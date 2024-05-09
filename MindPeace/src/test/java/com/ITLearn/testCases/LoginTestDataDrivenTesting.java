package com.ITLearn.testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ITLearn.pages.BaseTest;
import com.ITLearn.pages.LoginPage;
import com.ITLearn.utility.ReadExcelFile;


public class LoginTestDataDrivenTesting extends BaseTest {
	String fileName=System.getProperty("user.dir")+"\\TestData\\excelOfEclipse.xlsx";

	@Test(priority =1,dataProvider="LoginDataProvider")
	public void VerifyLogin(String userEmail,String userPwd) throws InterruptedException, Exception{
		BaseTest bt = new BaseTest();
		LoginPage lp = new LoginPage(driver);
//		String username ="Demo12";
//		String password ="Test123456$";
		lp.loginPortal(userEmail, userPwd);
	//	lp.logout();
		
		if(userEmail.equals("Demo12") && userPwd.equals("Test123456$")) {
			System.out.println("Test Passed");
			Assert.assertTrue(true);
			lp.logout();
			
		}else {
			bt.captureScreenShot(driver, "VerifyLogin");
			Assert.assertTrue(false);
		}
	}
	

	
	@DataProvider(name="LoginDataProvider")
	public String[][] LoginDataProvider(){
		
		int ttlRows= ReadExcelFile.getRowCount(fileName, "LoginData");
		int ttlColumns= ReadExcelFile.getCellCount(fileName, "LoginData");
		
		String data[][]= new String[ttlRows-1][ttlColumns];
		
		for(int i=1;i<ttlRows;i++)
		{
			for(int j=0;j<ttlColumns;j++)
			{
				data[i-1][j]=ReadExcelFile.getCellValue(fileName, "LoginData", i, j);
			}
		}
		return data;
	}

	
	
}
