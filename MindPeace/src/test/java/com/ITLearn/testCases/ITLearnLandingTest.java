package com.ITLearn.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ITLearn.pages.BaseTest;
import com.ITLearn.pages.ITLearnLandingPage;
import com.ITLearn.utility.ReadExcelFile;


public class ITLearnLandingTest extends BaseTest {
	ITLearnLandingPage ITLP;

	String fileName = System.getProperty("user.dir") + "\\TestData\\excelOfEclipse.xlsx";

	@Test
	public void verifyITLearnLogo() throws Exception {
		ITLP = new ITLearnLandingPage(driver);
		String logoText = ReadExcelFile.getCellValue(fileName, "SearchCourse", 1, 1);
		
		ITLP.isLogoDisplayed();
		String logo_Text = ITLP.getTextOnLogo();
		Assert.assertEquals(logo_Text, logoText);

	}
	
	@Test
	public void verify_All_CourcesBtn() throws Exception {
		ITLP = new ITLearnLandingPage(driver);
		ITLP.isAllCourcesBtnDisplayed();
		
		String allCourcesBtnTextExp = ReadExcelFile.getCellValue(fileName, "SearchCourse", 2, 1);
		 String allCourcesBtnTextActual= ITLP.allCourcesBtnText();
		Assert.assertEquals(allCourcesBtnTextExp, allCourcesBtnTextActual);
	}
}
