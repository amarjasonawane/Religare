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
	
	public By verifyBtn = By.xpath("(//button[text()='Verify'])[1]");
	
	public By uploadVerifyBtn = By.xpath("(//button[text()='Upload Verify'])[1]");
	
	public By proofDropDown = By.xpath("(//div[contains(@class,'select-wrapper')])[1]/ul/li");
	
	
	
}
