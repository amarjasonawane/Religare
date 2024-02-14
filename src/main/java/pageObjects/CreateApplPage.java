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
	
	public By consumerNoTxt = By.xpath("//input[@id='CBSI_EBACONS']");
	
	public By providerDropDown = By.xpath("(//div[contains(@class,'select-wrapper')])[5]/ul/li");
	
	public By aadharOtpTxt = By.xpath("//input[@id='AdharMobOTP']");
	
	public By aadharOtpBtn = By.xpath("//button[@id='AdharIotp']");
	
	public By titleSelectDropDown = By.xpath("(//div[contains(@class,'select-wrapper')])[7]/ul/li");
	
	public By proofIdenDropDown =By.xpath("(//div[contains(@class,'select-wrapper')])[9]/ul/li");
	
	public By firstNameTxt = By.xpath("//input[@id='CBSI_CUSFISNAM']");
	
	public By middleNameTxt = By.xpath("//input[@id='CBSI_CUSMIDNAM']");
	
	public By lastNameTxt = By.xpath("//input[@id='CBSI_CUSLSTNAM']");
	
	public By fatherNameTxt = By.xpath("//input[@id='CBSI_FATHRNAM']");
	
	public By motherNameTxt = By.xpath("//input[@id='CBSI_MOTHERNAME']");
	
	public By ageTxt = By.xpath("//input[@id='CBSI_AGE']");
	
	public By dobTxt = By.xpath("//input[@id='CBSI_DOB']");
	
	public By categoryDropDown = By.xpath("(//div[contains(@class,'select-wrapper')])[10]/ul/li");
	
	public By religionDropDown = By.xpath("(//div[contains(@class,'select-wrapper')])[11]/ul/li");
	
	public By countryDropDown = By.xpath("(//div[contains(@class,'select-wrapper')])[12]/ul/li");
	
	public By indianNatilityRadio = By.xpath("//div[contains(@class,'custom-control')]/input[@id='NatIndian']");
	
	public By nriNationalityRadio = By.xpath("//div[contains(@class,'custom-control')]/input[@id='NatNRI']");
	
	public By spouceNameTxt = By.xpath("//input[@id='CBSI_SPOUSNAME']");
	
	public By maritalDropDown = By.xpath("(//div[contains(@class,'select-wrapper')])[13]/ul/li");
	
	public By profileDropDown = By.xpath("(//div[contains(@class,'select-wrapper')])[14]/ul/li");
	
	public By qualifiDropDown = By.xpath("(//div[contains(@class,'select-wrapper')])[17]/ul/li");
	
	public By assessmentMethodDropDown = By.xpath("(//div[contains(@class,'select-wrapper')])[18]/ul/li");
	
	public By noofDepeTxt = By.xpath("//input[@id='CBSI_NOOFDEPEND']");
	
	public By ucicTxt = By.xpath("//input[@id='CBSI_LMSCUS']");
	
	public By grpIdTxt = By.xpath("//input[@id='CBSI_GROUPTAG']");
	
	public By saveBtn = By.xpath("//button[@id='Save1']");
	
	public By saveNxtBtn = By.xpath("(//button[text()='Save & Next'])[1]");
	
}
