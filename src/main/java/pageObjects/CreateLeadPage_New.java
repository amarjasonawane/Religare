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

public class CreateLeadPage_New {

	WebDriverActions ui = new WebDriverActions();

	ExcelLibrary excel = new ExcelLibrary();

	LoginPage fp = new LoginPage();
	
	public By leadId = By.xpath("//tr[contains(@class,'tbodytr')][1]/td[1]");

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
	
	public By searchIdTxt = By.id("SearchTable2");
	
	public void clickHamMenu(String varText) throws Exception {
		By dynamicMenu = By.xpath("//ul[contains(@class,'custom-scrollbar')]/li/div/a[text()='" + varText + "']");
		ui.JSclick(dynamicMenu);
	}

	public void clickMenu(String varText) throws Exception {
		By dynamicMenu = By.xpath("//a[text()='" + varText + "']");
		ui.JSclick(dynamicMenu);
	}
	
	public void fillDropdownData() throws Exception {
		fp.selectDrop(excel.getCellData("Create_Lead", 0, 3), excel.getCellData("Create_Lead", 1, 3));
		Reporter.pass("Product Type selected is  :   "  +excel.getCellData("Create_Lead", 1, 3));
		Thread.sleep(1000);

		fp.selectDrop(excel.getCellData("Create_Lead", 0, 4), excel.getCellData("Create_Lead", 1, 4));
		Thread.sleep(1000);
		Reporter.pass("Scheme selected is  :   "+excel.getCellData("Create_Lead", 1, 4));

		fp.selectDrop(excel.getCellData("Create_Lead", 0, 5), excel.getCellData("Create_Lead", 1, 5));
		Thread.sleep(1000);
		Reporter.pass("Branch selected is  :   "+excel.getCellData("Create_Lead", 1, 5));

		fp.selectDrop(excel.getCellData("Create_Lead", 0, 6), excel.getCellData("Create_Lead", 1, 6));
		Thread.sleep(1000);
		Reporter.pass("Sourced By selected is  :   "+excel.getCellData("Create_Lead", 1, 6));

		fp.selectDrop(excel.getCellData("Create_Lead", 0, 7), excel.getCellData("Create_Lead", 3, 7));
		Thread.sleep(1000);
		Reporter.pass("Source Name selected is : "+excel.getCellData("Create_Lead", 3, 7),true);

		ui.JSclick(fp.doneBtn);
		Reporter.pass("Done button is clicked");
		Thread.sleep(1000);
	}

	public void fillLeadData_Convert() throws Exception {

			ui.type(amtReqTxt, excel.getCellData("Create_Lead", 1, 9));
			Reporter.pass("Amount required is entered");

			ui.type(panTxt, excel.getCellData("Create_Lead", 1, 10));
			Reporter.pass("PAN no is entered");

			ui.type(fNameTxt, excel.getCellData("Create_Lead", 1, 11));
			Reporter.pass("First Name is entered");

			ui.type(lNameTxt, excel.getCellData("Create_Lead", 1, 12));
			Reporter.pass("Last Name is entered");

			ui.type(dobTxt, excel.getCellData("Create_Lead", 1, 13));
			Reporter.pass("DOB is entered");

			ui.type(mobileTxt, excel.getCellData("Create_Lead", 1, 15));
			Reporter.pass("Mobile no is entered");

			ui.type(stdTxt, excel.getCellData("Create_Lead", 1, 16));
			Reporter.pass("STD is entered");

			ui.type(landLineTxt, excel.getCellData("Create_Lead", 1, 17));
			Reporter.pass("Land Line is entered");

			ui.type(emailTxt, excel.getCellData("Create_Lead", 1, 18));
			Reporter.pass("Email is entered");

			ui.type(addr1Txt, excel.getCellData("Create_Lead", 1, 19));
			Reporter.pass("Address Line 1 is entered");

			ui.type(addr2Txt, excel.getCellData("Create_Lead", 1, 20));
			Reporter.pass("Address Line 2 is entered");

			ui.type(pincodeTxt, excel.getCellData("Create_Lead", 1, 21));
			Reporter.pass("Pin code is entered");

			fp.selectDrop(excel.getCellData("Create_Lead", 0, 24), excel.getCellData("Create_Lead", 1, 24));
			Reporter.pass("Lead Status is selected");

			ui.type(nextCommDateTxt, excel.getCellData("Create_Lead", 1, 25));
			Reporter.pass("Next Commencement Date is entered");

			ui.type(remarkTxt, excel.getCellData("Create_Lead", 1, 26));
			Reporter.pass("Remark is entered");

			ui.type(commentsTxt, excel.getCellData("Create_Lead", 1, 27));
			Reporter.pass("Comment is entered", true);

			ui.JSclick(submitBtn);
			Reporter.pass("Submit Button is clicked");
	
	}

	public void fillLeadData_Reject() throws Exception {

		ui.type(amtReqTxt, excel.getCellData("Create_Lead", 2, 9));
		Reporter.pass("Amount required is entered");

		ui.type(panTxt, excel.getCellData("Create_Lead", 2, 10));
		Reporter.pass("PAN no is entered");

		ui.type(fNameTxt, excel.getCellData("Create_Lead", 2, 11));
		Reporter.pass("First Name is entered");

		ui.type(lNameTxt, excel.getCellData("Create_Lead", 2, 12));
		Reporter.pass("Last Name is entered");

		ui.type(dobTxt, excel.getCellData("Create_Lead", 2, 13));
		Reporter.pass("DOB is entered");

		ui.type(mobileTxt, excel.getCellData("Create_Lead", 2, 15));
		Reporter.pass("Mobile no is entered");

		ui.type(stdTxt, excel.getCellData("Create_Lead", 2, 16));
		Reporter.pass("STD is entered");

		ui.type(landLineTxt, excel.getCellData("Create_Lead", 2, 17));
		Reporter.pass("Land Line is entered");

		ui.type(emailTxt, excel.getCellData("Create_Lead", 2, 18));
		Reporter.pass("Email is entered");

		ui.type(addr1Txt, excel.getCellData("Create_Lead", 2, 19));
		Reporter.pass("Address Line 1 is entered");

		ui.type(addr2Txt, excel.getCellData("Create_Lead", 2, 20));
		Reporter.pass("Address Line 2 is entered");

		ui.type(pincodeTxt, excel.getCellData("Create_Lead", 2, 21));
		Reporter.pass("Pin code is entered");

		fp.selectDrop(excel.getCellData("Create_Lead", 0, 24), excel.getCellData("Create_Lead", 2, 24));
		Reporter.pass("Lead Status is selected");

		ui.type(nextCommDateTxt, excel.getCellData("Create_Lead", 2, 25));
		Reporter.pass("Next Commencement Date is entered");

		ui.type(remarkTxt, excel.getCellData("Create_Lead", 2, 26));
		Reporter.pass("Remark is entered");

		ui.type(commentsTxt, excel.getCellData("Create_Lead", 1, 27));
		Reporter.pass("Comment is entered", true);

		ui.JSclick(submitBtn);
		Reporter.pass("Submit Button is clicked");

}

}
