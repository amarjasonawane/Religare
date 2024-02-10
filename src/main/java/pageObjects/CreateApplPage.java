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
	
	public By unameLbl = By.xpath("(//label[@class='active'])[1]");
	
	public By loginBtn = By.xpath("//button[@id='MAilSMSMobIotp' and text()='LOGIN']");
	
	public By submitBtn = By.xpath("//input[@type='submit']");
	
	public void selectDrop(String varText) throws Exception {
		By dynamicMenu = By.xpath("//label[contains(text(),'" +varText+"')]/preceding-sibling::div/ul/li");
	//	ui.JSclick(dynamicMenu);
		Thread.sleep(1000);
		ui.ElementsClick(dynamicMenu);
	}
	
	public void selectDrop1(String varText) throws Exception {
		By dynamicMenu = By.xpath("//label[contains(text(),'" +varText+"')]/preceding-sibling::div/ul/li");
	//	ui.JSclick(dynamicMenu);
		Thread.sleep(1000);
		ui.ElementsClick1(dynamicMenu);
	}
	
}
