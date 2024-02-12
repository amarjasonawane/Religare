package jarvis.scripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;
import base.FrameworkConstants;
import pageObjects.CreateApplPage;
import pageObjects.LoginPage;
import utilities.CustomMethods;
import utilities.ExcelLibrary;
import utilities.Reporter;
import utilities.ScreenRecorderUtil;
import utilities.WebDriverActions;

@Listeners(utilities.Listener.class)
public class LoginToApp extends BaseClass {

	WebDriverActions ui;
	ExcelLibrary excel;
	SoftAssert s;
	LoginPage fp;
	CreateApplPage cap;
	
	@BeforeMethod
	public void Login() throws IOException, AWTException, InterruptedException {
		ScreenRecorderUtil.startRecord("LoginTest");
	}

	@Test(priority = 0, enabled = true)
	public void test_Login() throws Exception {
		ui = new WebDriverActions();
		s = new SoftAssert();
		excel=new ExcelLibrary();
		fp = new LoginPage();

		CustomMethods.login(excel.getCellData("Login", 1, 1),excel.getCellData("Login", 1, 2));
		Reporter.pass(ui.getText(fp.unameLbl));

		ui.click(fp.loginBtn);
		Thread.sleep(10000);

		ui.click(fp.submitBtn);
		Thread.sleep(1000);

		ui.JSclick(fp.plusSign);
		Thread.sleep(1000);

		ui.JSclick(fp.individualBtn);
		Thread.sleep(1000);
		Reporter.pass("Individual Button is clicked");

		fp.selectDrop("Product Type");
		Thread.sleep(1000);
		Reporter.pass("Product Type is selected");

		fp.selectDrop1("Scheme");
		Thread.sleep(1000);
		Reporter.pass("Scheme is selected");

		fp.selectDrop("Branch");
		Thread.sleep(1000);
		Reporter.pass("Branch is selected");

		fp.selectDrop("Sourced By");
		Thread.sleep(1000);
		Reporter.pass("Sourced By is selected");

		fp.selectDrop1("Source Name");
		Thread.sleep(1000);
		Reporter.pass("Source Name is selected");

		ui.JSclick(fp.doneBtn);
		Reporter.pass("Done button is clicked");
		Thread.sleep(1000);
		
		ScreenRecorderUtil.stopRecord();

	}
	
	@Test(priority = 1, enabled = true, dependsOnMethods="test_Login")
	public void test_CreateApplication() throws Exception {
		ui = new WebDriverActions();
		s = new SoftAssert();
		excel=new ExcelLibrary();
		cap = new CreateApplPage();
		
		ui.type(cap.panField, excel.getCellData("Login", 1, 4));
		Reporter.pass("Pan Number is entered");
		
		ui.JSclick(cap.verifyBtn);
		Reporter.pass("Verify button is clicked");
		Thread.sleep(1000);
		
		ui.JSclick(cap.panAdvProBtn);
		Reporter.pass("PAN Advanced Profile is clicked");
		Thread.sleep(1000);
		
		ui.JSclick(cap.panSubmitBtn);
		Reporter.pass("Submit BUtton is clicked");
		
		Thread.sleep(3000);
	//	WebDriverActions.refreshPage(getDriver());

	
	  ui.JSclick(cap.panAdvSubmitBtn);
	  Reporter.pass("Advanced Profile Submit Button is clicked");
	  
	  Thread.sleep(3000); 
	//  WebDriverActions.refreshPage(getDriver());
	  
	  Reporter.pass("Verified Button Text :  "+ui.getAttribute(cap.verifyBtnTxt, "value"));
	  
	  Reporter.pass("Verified Button Text :  "+ui.getText(cap.verifyBtnTxt));
	 	
	  s.assertEquals(ui.getText(cap.verifyBtnTxt), "Verified");
	  
	  String path =System.getProperty("user.dir") + "\\TestData" + "\\" + "FCM_EnvironmentalDiferences.xlsx" ;
	  ui.uploadFCMFile(cap.uploadBtn, path);
	  
	  ui.ElementsClick1(cap.proofDropDown);
	  
	  ui.type(cap.aadharField, excel.getCellData("Login", 1, 5));
	  Reporter.pass("Aadhar Number is entered");
	  
	  ui.JSclick(cap.aadharVerifyBtn);
	  
	  ui.ElementsClick(cap.karzaDropDown);
	  
	  s.assertAll();
		
	}

}
