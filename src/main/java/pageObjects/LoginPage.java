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

public class LoginPage {
	
	WebDriverActions ui=new WebDriverActions();
	
	public By plusSign = By.xpath("//a[@id='LCR']");
	
	public By individualBtn = By.id("Indvdl");
	
	public By nonindividualBtn = By.id("NonIndvdl");
	
	public By doneBtn = By.xpath("//button[@id='InitWFI']");
	
	public By unameLbl = By.xpath("(//label[@class='active'])[1]");
	
	public By loginBtn = By.xpath("//button[@id='MAilSMSMobIotp' and text()='LOGIN']");
	
	public By submitBtn = By.xpath("//input[@type='submit']");
	
	public void selectDrop(String varText) throws Exception {
		By dynamicMenu = By.xpath("//label[contains(text(),'" +varText+"')]/preceding-sibling::div/ul/li");
	//	ui.JSclick(dynamicMenu);
		Thread.sleep(1000);
		ui.ElementsClick(dynamicMenu,2);
	}
	
	public void selectDrop1(String varText) throws Exception {
		By dynamicMenu = By.xpath("//label[contains(text(),'" +varText+"')]/preceding-sibling::div/ul/li");
	//	ui.JSclick(dynamicMenu);
		Thread.sleep(1000);
		ui.ElementsClick(dynamicMenu,1);
	}
	
}
