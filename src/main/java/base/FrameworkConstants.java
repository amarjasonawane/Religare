package base;

import java.text.SimpleDateFormat;
import java.util.Date;

import utilities.ConfigurationSupport;

public final class FrameworkConstants {
	
	private FrameworkConstants() {
		
	}
	
	public static String getEdgedriverpath() {
		return EDGEDRIVERPATH;
	}
	
	public static String getChromedriverpath() {
		return CHROMEDRIVERPATH;
	}
	
	public static String getExcelpath() {
		ConfigurationSupport cs=new ConfigurationSupport(getGlobalpropertiespath());
		
		return EXCELPATH + cs.getProperty("testdata") + ".xlsx";
	}
	
	public static String getExtentreportfolderpath() {
		return EXTENTREPORTFOLDERPATH;
	}
	
	public static String getScreenshotPath() {
		ConfigurationSupport cs=new ConfigurationSupport(getGlobalpropertiespath());
		String date=new SimpleDateFormat("yyyy_MM_dd").format(new Date());
		
		return EXTENTREPORTFOLDERPATH + date + "\\" + cs.getProperty("suite") + "\\";
	}
	
	public static String getGlobalpropertiespath() {
		return GLOBALPROPERTIESPATH;
	}
	
	public static int getImplicit() {
		ConfigurationSupport cs=new ConfigurationSupport(getGlobalpropertiespath());
		return Integer.parseInt(cs.getProperty("implicit"));
	}
	
	public static int getExplicit() {
		ConfigurationSupport cs=new ConfigurationSupport(getGlobalpropertiespath());
		return Integer.parseInt(cs.getProperty("explicit"));
	}
	
	public static String getDownloadpath() {
		return DOWNLOADPATH;
	}
	
	public static String getExtentReportFilePath() {
		if(extentReportFilePath.isEmpty()) {
			extentReportFilePath=createReportPath();
		}
		
		return extentReportFilePath;
	}
	
	private static String createReportPath() {
		ConfigurationSupport cs=new ConfigurationSupport(getGlobalpropertiespath());
		String dateName=new SimpleDateFormat("yyyy_MM_dd hh_mm_ss").format(new Date());
		String date=new SimpleDateFormat("yyyy_MM_dd").format(new Date());
		
		return EXTENTREPORTFOLDERPATH + date + "\\" + cs.getProperty("suite") + "\\" + dateName + ".html";
	}
	
	public ConfigurationSupport cs=new ConfigurationSupport(getGlobalpropertiespath());
	
	private static final String EDGEDRIVERPATH=System.getProperty("user.dir")+"\\executables\\msedgedriver.exe";
	private static final String CHROMEDRIVERPATH=System.getProperty("user.dir")+"\\executables\\chromedriver.exe";
	private static String EXCELPATH=System.getProperty("user.dir")+"\\resources\\Testdata\\";
	private static final String EXTENTREPORTFOLDERPATH="C:\\SamplePrj\\Reports";
	private static String extentReportFilePath="";
	private static final String GLOBALPROPERTIESPATH=System.getProperty("user.dir")+"\\configuration files\\global.properties";
	private static final String DOWNLOADPATH=System.getProperty("user.home")+"\\Downloads";
	
	private static final int implicit=10;
	private static final int explicit=10;

}
