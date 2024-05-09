package com.ITLearn.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ITLearn.pages.BaseTest;
import com.ITLearn.pages.LoginPage;
import com.ITLearn.pages.SearchPage;
import com.ITLearn.utility.ReadExcelFile;

public class SearchTest extends BaseTest{
	LoginPage lp;
	SearchPage sp ;
	
	
	String fileName = System.getProperty("user.dir")+"\\TestData\\excelOfEclipse.xlsx";
	
	@Test(priority = 2)
	public void verifySearchTestCourse() throws InterruptedException {
		
		 lp = new LoginPage(driver);
		String userEmail = ReadExcelFile.getCellValue(fileName,"LoginData", 1, 0);
		 String passwd = ReadExcelFile.getCellValue(fileName,"LoginData", 1, 1);
		 lp.loginPortal(userEmail, passwd);
		 
		sp = new SearchPage(driver);
		 String course_Name = ReadExcelFile.getCellValue(fileName,"SearchCourse", 0, 0);
		 sp.searchCourse(course_Name);	
	}
	
	
	@Test(priority = 3)
	public void verifyGet_url_courseResult() {
		sp = new SearchPage(driver);
		String actual_url = sp.get_url_courseResult();
		String exp_url = ReadExcelFile.getCellValue(fileName,"AllUrls", 1, 0);
		//Assert.assertEquals(actual_url, "http://demo.itlearn360.com/self-paced-courses/?search_course=HTML+For+Beginners");
		Assert.assertEquals(actual_url, exp_url);
		
	}
	

}
