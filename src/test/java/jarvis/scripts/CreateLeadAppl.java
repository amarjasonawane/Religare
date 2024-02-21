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
import pageObjects.CreateLeadPage;
import pageObjects.LoginPage;
import utilities.CustomMethods;
import utilities.ExcelLibrary;
import utilities.Reporter;
import utilities.ScreenRecorderUtil;
import utilities.WebDriverActions;

@Listeners(utilities.Listener.class)
public class CreateLeadAppl extends BaseClass {

	WebDriverActions ui;
	ExcelLibrary excel;
	SoftAssert s;
	LoginPage fp;
	CreateLeadPage cl;

	@BeforeMethod
	public void Login() throws IOException, AWTException, InterruptedException {
		ScreenRecorderUtil.startRecord("Create Lead Test");
	}

	@Test(priority = 0, enabled = true)
	public void test_createLead_HomeLoan_Connector() throws Exception {
		ui = new WebDriverActions();
		s = new SoftAssert();
		excel = new ExcelLibrary();
		cl = new CreateLeadPage();
		fp = new LoginPage();

		CustomMethods.login(excel.getCellData("Login", 1, 1), excel.getCellData("Login", 1, 2));
		
		ui.click(fp.loginBtn);
		Thread.sleep(10000);

		ui.click(fp.submitBtn);
		Thread.sleep(1000);
		
		ui.JSclick(cl.hamBurgerMenu);
		cl.clickHamMenu("Manage Lead");
		
		cl.clickMenu("Create New Lead");
		
		ui.JSclick(fp.individualBtn);
		
		fp.selectDrop(excel.getCellData("Create_Lead", 0, 4), excel.getCellData("Create_Lead", 1, 4));
		Thread.sleep(1000);
		Reporter.pass("Product Type is selected");
		
		fp.selectDrop(excel.getCellData("Create_Lead", 0, 8), excel.getCellData("Create_Lead", 1, 8));
		Thread.sleep(1000);
		Reporter.pass("Scheme is selected");
		
		fp.selectDrop(excel.getCellData("Create_Lead", 0, 12), excel.getCellData("Create_Lead", 1, 12));
		Thread.sleep(1000);
		Reporter.pass("Branch is selected");
		
		fp.selectDrop(excel.getCellData("Create_Lead", 0, 26), excel.getCellData("Create_Lead", 1, 26));
		Thread.sleep(1000);
		Reporter.pass("Sourced By is selected");
		
		fp.selectDrop(excel.getCellData("Create_Lead", 2, 26), excel.getCellData("Create_Lead", 3, 26));
		Thread.sleep(1000);
		Reporter.pass("Source Name is selected");
		
		ui.JSclick(fp.doneBtn);
		Reporter.pass("Done button is clicked");
		Thread.sleep(1000);
		
		cl.fillLeadData();
		Reporter.pass("Create Lead data Completed");
		
		ScreenRecorderUtil.stopRecord();

	}

	
	
}
