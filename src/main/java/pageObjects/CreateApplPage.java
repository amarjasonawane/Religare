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
import utilities.WebDriverActions;

public class CreateApplPage {
	
	WebDriverActions ui=new WebDriverActions();
	
	public By panField = By.xpath("//input[@id='CBSI_PAN']");
	
	public By aadharField = By.xpath("//input[@id='CBSI_AADHAR']");
	
	public By verifyBtn = By.xpath("(//button[text()='Verify'])[1]");
	
	public By aadharVerifyBtn = By.xpath("(//button[text()='Verify'])[4]");
	
	public By verifyBtnTxt = By.xpath("//button[text()='Verified']");
	
	public By uploadVerifyBtn = By.xpath("(//button[text()='Upload Verify'])[1]");
	
	public By proofDropDown = By.xpath("(//div[contains(@class,'select-wrapper')])[1]/ul/li");
	
	public By karzaDropDown = By.xpath("(//div[contains(@class,'select-wrapper')])[2]/ul/li");
	
	public By panAdvSubmitBtn = By.xpath("//button[@id='KarzaPopup']");
	
	public By panAdvProBtn = By.xpath("//div/input[@id='PANADPROFILE']");
	
	public By panAuthBtn = By.xpath("//div/input[@id='PANAUTH']");
	
	public By panStatChkBtn = By.xpath("//div/input[@id='PANSTATUSCHK']");
	
	public By panSubmitBtn = By.xpath("//div/button[@id='PANPopup']");
	
	public By uploadBtn = By.xpath("(//a/input[@type='file'])[1]");
	
	public By titleSelectDropDown = By.xpath("(//input[contains(@class,'select-dropdown')])[7]");
	
	public By proofIdenDropDown =By.xpath("(//input[contains(@class,'select-dropdown')])[9]");
	
	public By firstNameTxt = By.xpath("//input[@id='CBSI_CUSFISNAM']");
	
	public By middleNameTxt = By.xpath("//input[@id='CBSI_CUSMIDNAM']");
	
	public By lastNameTxt = By.xpath("//input[@id='CBSI_CUSLSTNAM']");
	
	public By fatherNameTxt = By.xpath("//input[@id='CBSI_FATHRNAM']");
	
	public By motherNameTxt = By.xpath("//input[@id='CBSI_MOTHERNAME']");
	
	public By ageTxt = By.xpath("//input[@id='CBSI_AGE']");
	
	public By categoryDropDown = By.xpath("(//input[contains(@class,'select-dropdown')])[10]");
	
	public By religionDropDown = By.xpath("(//input[contains(@class,'select-dropdown')])[11]");
	
	public By countryDropDown = By.xpath("(//input[contains(@class,'select-dropdown')])[12]");
	
	public By indianNatilityRadio = By.xpath("//div[contains(@class,'custom-control')]/input[@id='NatIndian']");
	
	public By nriNationalityRadio = By.xpath("//div[contains(@class,'custom-control')]/input[@id='NatNRI']");
	
	public By spouceNameTxt = By.xpath("//input[@id='CBSI_SPOUSNAME']");
	
	public By maritalDropDown = By.xpath("(//input[contains(@class,'select-dropdown')])[13]");
	
	public By profileDropDown = By.xpath("(//input[contains(@class,'select-dropdown')])[14]");
	
	public By qualifiDropDown = By.xpath("(//input[contains(@class,'select-dropdown')])[17]");
	
	public By assessmentMethodDropDown = By.xpath("(//input[contains(@class,'select-dropdown')])[18]");
	
	public By noofDepeTxt = By.xpath("//input[@id='CBSI_NOOFDEPEND']");
	
	public By ucicTxt = By.xpath("//input[@id='CBSI_LMSCUS']");
	
	public By grpIdTxt = By.xpath("//input[@id='CBSI_GROUPTAG']");
}
