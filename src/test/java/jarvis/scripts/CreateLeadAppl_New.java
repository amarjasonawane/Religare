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
import pageObjects.CreateLeadPage_New;
import pageObjects.LoginPage;
import utilities.CustomMethods;
import utilities.ExcelLibrary;
import utilities.Reporter;
import utilities.ScreenRecorderUtil;
import utilities.WebDriverActions;

@Listeners(utilities.Listener.class)
public class CreateLeadAppl_New extends BaseClass {

	WebDriverActions ui;
	ExcelLibrary excel;
	SoftAssert s;
	LoginPage fp;
	CreateLeadPage_New cl;

	@BeforeMethod
	public void Login() throws IOException, AWTException, InterruptedException {
		ScreenRecorderUtil.startRecord("Create Lead Test");
	}

	@Test(priority = 0, enabled = true)
	public void test_createLead_HL_Connector_Convert() throws Exception {
		ui = new WebDriverActions();
		s = new SoftAssert();
		excel = new ExcelLibrary();
		cl = new CreateLeadPage_New();
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

		cl.fillDropdownData();
		Reporter.pass("Contents are filled");

		cl.fillLeadData_Convert(); 
		Reporter.pass("Create Lead data Completed");
		
		String leadId = ui.getText(cl.leadId);
		Reporter.pass("Lead Id is  :" + leadId);
		
		ui.type(cl.searchIdTxt, leadId);
		
		Thread.sleep(2000);
		
		fp.selectTableDrop("Convert");
		
		cl.clickMenu("Submit");
		Thread.sleep(3000);
		
		String alertTxt = ui.getAlertText();
			
		ui.acceptAlert();
		Thread.sleep(2000);
		
		Reporter.pass("Alert Text is  :   "+alertTxt,true);
		
		ScreenRecorderUtil.stopRecord();

	}
	
	@Test(priority = 1, enabled = true)
	public void test_createLead_HL_Connector_NotInterested() throws Exception {
		ui = new WebDriverActions();
		s = new SoftAssert();
		excel = new ExcelLibrary();
		cl = new CreateLeadPage_New();
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

		cl.fillDropdownData();
		Reporter.pass("Contents are filled");

		cl.fillLeadData_Reject(); 
		Reporter.pass("Create Lead data Completed");
		
		String leadId = ui.getText(cl.leadId);
		Reporter.pass("Lead Id is  :" + leadId);
		
		ui.type(cl.searchIdTxt, leadId);
		
		Thread.sleep(2000);
		
		fp.selectTableDrop("Not Interested");
		
		cl.clickMenu("Reject");
		Thread.sleep(3000);
		
		String alertTxt = ui.getAlertText();
		
		ui.acceptAlert();
		Thread.sleep(2000);
		
		Reporter.pass("Alert Text is  :   "+alertTxt,true);
		
		ScreenRecorderUtil.stopRecord();

	}

}
