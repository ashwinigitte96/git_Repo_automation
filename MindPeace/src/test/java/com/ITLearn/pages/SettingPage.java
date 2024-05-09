package com.ITLearn.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ITLearn.utility.ReadExcelFile;

public class SettingPage extends BaseTest {

	public SettingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	BaseTest bt = new BaseTest();
	
	
	@FindBy(xpath="//ul[@class='tabs learn-press-tabs clearfix border-radius-sm']//li//a")
	WebElement op;
	
	@FindBy(xpath="//a[contains(text(),'Settings') and @href='https://demo.itlearn360.com/user-profile/Demo12/settings/']")
	WebElement scrollTillThisElement;
	
	@FindBy(xpath="//input[@class='regular-text' and @name='first_name']")
	WebElement first_Name;
	
	@FindBy(xpath="//input[@class='regular-text' and @name='last_name']")
	WebElement last_Name;
	
	@FindBy(xpath="//input[@class='regular-text' and @name='nickname']")
	WebElement nick_name;
	
	@FindBy(xpath="//textarea[@id='description']")
	WebElement description;
	
	@FindBy(xpath="//select[@id='display_name']")
	WebElement drp_down_displayName;
	
    @FindBy(xpath="//select[@id='display_name']//option")
    WebElement drp_down_displayName_withOptions;
	
	@FindBy(xpath="//input[@name='submit']")
	WebElement update_Btn;
	
	@FindBy(xpath="//option[@selected='selected']")
	WebElement drp_selectedElement;
	
	@FindBy(xpath="//a[contains(text(),'Avatar')]")
	WebElement avatar_btn;
	
	@FindBy(xpath="//button[contains(text(),'Upload Image')]")
	WebElement uploadImg_btn;
	
	@FindBy(xpath="//input[@id='submit']")
	WebElement avatar_update_btn;
	
	@FindBy(xpath="//button[contains(text(),'Remove')]")
	WebElement removeAvatar_btn;
	
	@FindBy(xpath="//a[@class='lp-cancel-upload dashicons dashicons-no-alt']")
	WebElement cancelUploadCrossBtn;
	
	@FindBy(xpath="//a[contains(text(),'Change Password')]")
	WebElement changepwd_col;
	
	@FindBy(xpath="//input[@placeholder='Enter Current password']")
	WebElement current_pwd;
	
	@FindBy(xpath="//input[@placeholder='Enter New password']")
	WebElement new_pwd;
	
	@FindBy(xpath="//input[@placeholder='Re-type New Password']")
	WebElement retype_new_pwd;
	
	@FindBy(xpath="//input[@class='button button-primary']")
	WebElement update_pwd_btn;
	
	@FindBy(xpath="//p[contains(text(),'Your password updated')]")
	public WebElement pwdUpdatedTxt;
	
	String fileName = System.getProperty("user.dir")+ "\\TestData\\excelOfEclipse.xlsx";
	public String drpValue;
	
	
	
	DashboardPage dp = new DashboardPage(driver);
	
	
	
	public void settingsClick() throws InterruptedException {
	methodscrollTillThisElement(scrollTillThisElement);
}
	public void fname_Update() throws Exception {
		waitUntilElementIsAvailable(first_Name);
		first_Name.click();
		
		String value_fname = ReadExcelFile.getStringData("baicInfo",0,1);
		setValue(first_Name, value_fname);
		waitTime(0);
	}
	
	public void lname_Update() throws Exception {
		waitUntilElementIsAvailable(last_Name);
		last_Name.click();
		String value_lname = ReadExcelFile.getCellValue(fileName,"baicInfo",1,1);
		setValue(last_Name, value_lname);
		waitTime(0);
		
	}
	
	public void nickName_Update() throws Exception {
		waitUntilElementIsAvailable(nick_name);
		nick_name.click();
		String value_nickName = ReadExcelFile.getCellValue(fileName, "baicInfo", 2, 1);
		setValue(nick_name, value_nickName);
		waitTime(0);
	}
	
	public void description_update() throws Exception {
		waitUntilElementIsAvailable(description);
		description.click();
		String value_Description = ReadExcelFile.getCellValue(fileName, "baicInfo", 3, 1);
		setValue(description, value_Description);
		waitTime(0);
		
	}
	
	
	
	public void selectNameToDisplay() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",drp_down_displayName);
        js.executeScript("arguments[0].click();",drp_down_displayName);
        drpValue = ReadExcelFile .getCellValue(fileName, "baicInfo", 5, 0);
        try {
        List<WebElement> ops = driver.findElements(By.xpath("//select[@id='display_name']//option"));
        for(WebElement op:ops) {
        	if(op.getText().equals(drpValue)) {
        		op.click();
        	}
        }
        }catch(Exception e) {
        		System.out.println(e.getMessage());
        	}
        
        
	}
	
	
	
	public void click_Update_Btn() throws Exception {
		
		waitUntilElementIsAvailable(update_Btn);
		update_Btn.click();
		waitTime(5);
	}
	public void  changeAvatar() throws Exception{
		
		String str = System.getProperty("user.dir")+ "\\TestData\\user1 icon.png";
		waitUntilElementIsAvailable(avatar_btn);
		try {
		avatar_btn.click();
		waitTime(3);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		waitUntilElementIsAvailable(uploadImg_btn);
		synchronized (this) {
			
		
		try {
		uploadImg_btn.click();
		this.wait(5);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		Thread.sleep(5000);
		Runtime.getRuntime().exec("C:\\Users\\Lenovo\\Documents\\FileUpload.exe");
		this.wait(5);
		}
		
		
		
	}
	public void avatarUpdateBtnClick() throws Exception {
		waitUntilElementIsAvailable(avatar_update_btn);
		avatar_update_btn.click();
	}
	public void removeUploadedAvatar() throws Exception {
		
		synchronized (this) {
		try{
		
		waitUntilElementIsAvailable(removeAvatar_btn);
		if(removeAvatar_btn.isEnabled()) {
			removeAvatar_btn.click();
			this.wait(2);
		}
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}	}
	}
	
	public void cancelUpload() {
		cancelUploadCrossBtn.click();
	}
	
	public void changepwd_col_Click() throws Exception {
		waitUntilElementIsAvailable(changepwd_col);
		changepwd_col.click();
		Thread.sleep(3000);
	}
	public void enter_current_pwd(String pwd) throws Exception {
		waitUntilElementIsAvailable(current_pwd);
		current_pwd.sendKeys(pwd);
		Thread.sleep(3000);
	}
	
	public void enter_new_pwd(String new_pwdd) throws Exception {
		waitUntilElementIsAvailable(new_pwd);
		try {
		new_pwd.sendKeys(new_pwdd);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		Thread.sleep(3000);
	}
	public void method_retype_new_pwd(String retype) throws Exception {
		waitUntilElementIsAvailable(retype_new_pwd);
		try {
		retype_new_pwd.sendKeys(retype);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	
		Thread.sleep(3000);
	}
		
	public void click_update_pwd_btn() throws Exception {
		waitUntilElementIsAvailable(update_pwd_btn);
		waitUntilElementIsEnabled(update_pwd_btn);
		try {
		update_pwd_btn.click();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		Thread.sleep(3000);
	}
		
	

	

}
