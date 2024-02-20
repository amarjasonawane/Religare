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
		excel = new ExcelLibrary();
		fp = new LoginPage();

		CustomMethods.login(excel.getCellData("Login", 1, 1), excel.getCellData("Login", 1, 2));
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

		fp.selectDrop("Product Type","Home Loan");
		fp.selectDrop(excel.getCellData("Create_Lead", 0, 4), excel.getCellData("Create_Lead", 1, 4));
		Thread.sleep(1000);
		Reporter.pass("Product Type is selected");

		fp.selectDrop1("Scheme");
		Thread.sleep(1000);
		Reporter.pass("Scheme is selected");

	//	fp.selectDrop("Branch");
		Thread.sleep(1000);
		Reporter.pass("Branch is selected");

		//fp.selectDrop("Sourced By");
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

	@Test(priority = 1, enabled = true, dependsOnMethods = "test_Login")
	public void test_CreateApplication() throws Exception {
		ui = new WebDriverActions();
		s = new SoftAssert();
		excel = new ExcelLibrary();
		cap = new CreateApplPage();

		ui.type(cap.panField, excel.getCellData("Login", 1, 4));
		Reporter.pass("Pan Number is entered");
		
		ui.JSclick(cap.verifyBtn);
		Reporter.pass("Verify button is clicked");
		
		Thread.sleep(1000);

		ui.JSclick(cap.panAdvProBtn);
		Reporter.pass("PAN Advanced Profile is clicked");
		Thread.sleep(3000);
				
		ui.JSclick(cap.panSubmitBtn);
		Reporter.pass("Submit BUtton is clicked");

		Thread.sleep(3000);
		ui.acceptAlert();
		// WebDriverActions.refreshPage(getDriver());
	
		ui.JSclick(cap.panAdvSubmitBtn);
		Reporter.pass("Advanced Profile Submit Button is clicked");
		Thread.sleep(3000);
		
		// WebDriverActions.refreshPage(getDriver());

		if(ui.getText(cap.verifyBtnTxt).equalsIgnoreCase("Verified")) {
			Reporter.pass("Button Text :  " + ui.getText(cap.verifyBtnTxt));
			s.assertEquals(ui.getText(cap.verifyBtnTxt), "Verified");
		}
		else
			Reporter.pass("Button Text :  " + ui.getText(cap.verifyBtnTxt));

		String path = System.getProperty("user.dir") + "\\Testdata" + "\\" + "PAN_Card.jpg";
		// ui.uploadFCMFile(cap.uploadBtn, path);
		ui.type(cap.uploadBtn, path);
		Thread.sleep(5000);
//	  ui.JSclick(cap.uploadBtn);
//	  Thread.sleep(2000);

		ui.ElementsClick(cap.proofDropDown);

		ui.type(cap.aadharField, excel.getCellData("Login", 1, 5));
		Reporter.pass("Aadhar Number is entered");

		ui.JSclick(cap.aadharVerifyBtn);
		Thread.sleep(3000);

		Reporter.pass("Alert Text is:" + ui.getAlertText());
		Thread.sleep(1000);
		ui.acceptAlert();
		Thread.sleep(3000);

		ui.JSclick(cap.aadharVerifyBtn);
		Thread.sleep(3000);

		ui.acceptAlert();
		Thread.sleep(3000);

		// ui.JSclick(cap.aadharVerifyBtn);
		// Thread.sleep(3000);

//	  ui.click(cap.aadharOtpBtn);

		ui.ElementsClick(cap.karzaDropDown);

		ui.type(cap.consumerNoTxt, "4669");

		ui.ElementsClick(cap.providerDropDown);
		Reporter.pass("Service Provider is entered");
		Thread.sleep(2000);

		s.assertAll();

	}

	@Test(priority = 2, enabled = true, dependsOnMethods = "test_CreateApplication")
	public void test_FillApplication() throws Exception {
		ui = new WebDriverActions();
		s = new SoftAssert();
		excel = new ExcelLibrary();
		cap = new CreateApplPage();

		ui.scrollByVisibilityOfElement(cap.titleSelectDropDown);
		ui.ElementsClick(cap.titleSelectDropDown);
		Reporter.pass("Title is selected");
		Thread.sleep(1000);

		// ui.scrollByVisibilityOfElement(cap.proofIdenDropDown);
		ui.ElementsClick(cap.proofIdenDropDown);
		Reporter.pass("Proof of Identification is selected");
		Thread.sleep(1000);

		ui.type(cap.firstNameTxt, excel.getCellData("Login", 1, 6));
		Reporter.pass("First Name is entered");

		ui.type(cap.middleNameTxt, excel.getCellData("Login", 1, 7));
		Reporter.pass("Middle Name is entered");

		ui.type(cap.lastNameTxt, excel.getCellData("Login", 1, 8));
		Reporter.pass("Last Name is entered");

		ui.type(cap.fatherNameTxt, excel.getCellData("Login", 1, 9));
		Reporter.pass("Father's Name is entered");

		ui.type(cap.motherNameTxt, excel.getCellData("Login", 1, 10));
		Reporter.pass("Mother's Name is entered");

		ui.type(cap.dobTxt, excel.getCellData("Login", 1, 14));
		Reporter.pass("DOB is entered");

		ui.ElementsClick(cap.categoryDropDown);
		Reporter.pass("Category is selected");

		ui.ElementsClick(cap.religionDropDown);
		Reporter.pass("Religion is selected");

		ui.JSclick(cap.indianNatilityRadio);
		Reporter.pass("Indian Nationality is selected");

		ui.ElementsClick(cap.countryDropDown);
		Reporter.pass("Country is selected");

		ui.ElementsClick(cap.maritalDropDown);
		Reporter.pass("Marital status is selected");

		ui.type(cap.spouceNameTxt, excel.getCellData("Login", 1, 11));
		Reporter.pass("Spouse name is entered");

		ui.ElementsClick(cap.profileDropDown);
		Reporter.pass("Profile is selected");

		ui.type(cap.noofDepeTxt, excel.getCellData("Login", 1, 13));
		Reporter.pass("No. of dependents added");

		ui.ElementsClick(cap.qualifiDropDown);
		Reporter.pass("Qualification is selected");

		ui.ElementsClick(cap.assessmentMethodDropDown);
		Reporter.pass("Assessment Method is selected");
		
		//Added save and Next Button
		
		ui.click(cap.saveNxtBtn);
		Reporter.pass("Save and Next Button is clicked");
	}

}
