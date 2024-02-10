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
	
	@BeforeMethod
	public void Login() throws IOException, AWTException, InterruptedException {
		ScreenRecorderUtil.startRecord("SampleTest");
	}

	@Test(priority = 0, enabled = true)
	public void test_Login() throws Exception {
		ui = new WebDriverActions();
		s = new SoftAssert();
		// excel=new ExcelLibrary();
		fp = new LoginPage();

		CustomMethods.login("eslsales1","themepass");
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
		
		ScreenRecorderUtil.stopRecord();

	}
	
	@Test(priority = 0, enabled = true)
	public void test_CreateApplication() throws Exception {
		ui = new WebDriverActions();
		s = new SoftAssert();
		// excel=new ExcelLibrary();
		fp = new LoginPage();
	}

}
