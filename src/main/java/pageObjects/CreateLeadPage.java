package pageObjects;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.joda.time.DateTime;

import org.openqa.selenium.By;

import com.codoid.products.utils.FilenameUtils;

import base.FrameworkConstants;
import utilities.ConfigurationSupport;
import utilities.CustomMethods;
import utilities.ExcelLibrary;
import utilities.Reporter;
import utilities.WebDriverActions;

public class CreateLeadPage {

	WebDriverActions ui = new WebDriverActions();

	ExcelLibrary excel = new ExcelLibrary();

	LoginPage fp = new LoginPage();

	public By hamBurgerMenu = By.xpath("//a[contains(@class,'button-collapse')]");

	public By amtReqTxt = By.id("TEST_AMOUNTREQUIREMENT");

	public By panTxt = By.id("TEST_PAN");

	public By fNameTxt = By.id("TEST_FIRSTNAME");

	public By lNameTxt = By.id("TEST_SECONDNAME");

	public By dobTxt = By.id("TEST_DOB");

	public By ageTxt = By.id("TEST_AGE");

	public By mobileTxt = By.id("TEST_MOBNO");

	public By stdTxt = By.id("TEST_STDC");

	public By landLineTxt = By.id("TEST_LNDLINENO");

	public By emailTxt = By.id("TEST_EMAILID");

	public By addr1Txt = By.id("TEST_ADDRESSLINE1");

	public By addr2Txt = By.id("TEST_ADDRESSLINE2");

	public By pincodeTxt = By.id("TEST_PINCODE");

	public By cityTxt = By.id("TEST_CITY");

	public By stateTxt = By.id("TEST_STATE");

	public By leadDropdown = By.xpath("(//ul[contains(@id,'select-options-')])[1]");

	public By nextCommDateTxt = By.id("TEST_NCOMDOB");

	public By remarkTxt = By.id("TEST_MOBREMARK");

	public By commentsTxt = By.id("MNGD_DESC");

	public By submitBtn = By.id("Submit");

	public void clickHamMenu(String varText) throws Exception {
		By dynamicMenu = By.xpath("//ul[contains(@class,'custom-scrollbar')]/li/div/a[text()='" + varText + "']");
		ui.JSclick(dynamicMenu);
	}

	public void clickMenu(String varText) throws Exception {
		By dynamicMenu = By.xpath("//a[text()='" + varText + "']");
		ui.JSclick(dynamicMenu);
	}

	public void fillLeadData() throws Exception {

			ui.type(amtReqTxt, excel.getCellData("Create_Lead", 3, 2));
			Reporter.pass("Amount required is entered");

			ui.type(panTxt, excel.getCellData("Create_Lead", 4, 2));
			Reporter.pass("PAN no is entered");

			ui.type(fNameTxt, excel.getCellData("Create_Lead", 5, 2));
			Reporter.pass("First Name is entered");

			ui.type(lNameTxt, excel.getCellData("Create_Lead", 6, 2));
			Reporter.pass("Last Name is entered");

			ui.type(dobTxt, excel.getCellData("Create_Lead", 7, 2));
			Reporter.pass("DOB is entered");

			ui.type(mobileTxt, excel.getCellData("Create_Lead", 9, 2));
			Reporter.pass("Mobile no is entered");

			ui.type(stdTxt, excel.getCellData("Create_Lead", 10, 2));
			Reporter.pass("STD is entered");

			ui.type(landLineTxt, excel.getCellData("Create_Lead", 11, 2));
			Reporter.pass("Land Line is entered");

			ui.type(emailTxt, excel.getCellData("Create_Lead", 12, 2));
			Reporter.pass("Email is entered");

			ui.type(addr1Txt, excel.getCellData("Create_Lead", 13, 2));
			Reporter.pass("Address Line 1 is entered");

			ui.type(addr2Txt, excel.getCellData("Create_Lead", 14, 2));
			Reporter.pass("Address Line 2 is entered");

			ui.type(pincodeTxt, excel.getCellData("Create_Lead", 15, 2));
			Reporter.pass("Pin code is entered");

			fp.selectDrop(excel.getCellData("Create_Lead", 18, 1), excel.getCellData("Create_Lead", 18, 2));
			Reporter.pass("Lead Status is selected");

			ui.type(nextCommDateTxt, excel.getCellData("Create_Lead", 19, 2));
			Reporter.pass("Next Commencement Date is entered");

			ui.type(remarkTxt, excel.getCellData("Create_Lead", 20, 2));
			Reporter.pass("Remark is entered");

			ui.type(commentsTxt, excel.getCellData("Create_Lead", 21, 2));
			Reporter.pass("Comment is entered");

			ui.JSclick(submitBtn);
			Reporter.pass("Submit Button is clicked");
	
	}

}
