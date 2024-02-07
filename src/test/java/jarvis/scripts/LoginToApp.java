package jarvis.scripts;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;
import base.FrameworkConstants;
import pageObjects.LoginPage;
import utilities.CustomMethods;
import utilities.ExcelLibrary;
import utilities.Reporter;
import utilities.WebDriverActions;

@Listeners(utilities.Listener.class)
public class LoginToApp extends BaseClass {

	WebDriverActions ui;
	ExcelLibrary excel;
	SoftAssert s;

	LoginPage fp;

	@Test(priority = 0, enabled = true)
	public void SampleTest() throws Exception {
		ui = new WebDriverActions();
		s = new SoftAssert();
		// excel=new ExcelLibrary();
		fp = new LoginPage();

		CustomMethods.login("eslsales1", "themepass");

		Reporter.pass(ui.getText(fp.unameLbl));

		ui.click(fp.loginBtn);
		Thread.sleep(10000);

		ui.click(fp.submitBtn);
		Thread.sleep(1000);

	//	getDriver().get(cs.getProperty("url_homefin"));
	//	Thread.sleep(5000);

		ui.JSclick(fp.plusSign);
		Thread.sleep(1000);

		ui.JSclick(fp.individualBtn);
		Thread.sleep(1000);
		Reporter.pass("Individual Button is clicked");

		fp.selectDrop("Product Type");
		Thread.sleep(1000);

		fp.selectDrop("Scheme");
		Thread.sleep(1000);

		fp.selectDrop("Branch");
		Thread.sleep(1000);

		fp.selectDrop("Sourced By");
		Thread.sleep(1000);

		fp.selectDrop("Source Name");
		Thread.sleep(1000);

		ui.click(fp.doneBtn);

	}

}
