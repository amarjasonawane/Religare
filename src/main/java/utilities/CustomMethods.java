package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.codoid.products.utils.FilenameUtils;

import base.BaseClass;
import base.FrameworkConstants;
import fabricator.Fabricator;
import io.netty.util.internal.ThreadLocalRandom;

public class CustomMethods extends BaseClass {
	static WebDriver driver = getDriver();
	static WebDriverActions ui = new WebDriverActions();
	static ConfigurationSupport cs = new ConfigurationSupport(FrameworkConstants.getGlobalpropertiespath());
	static String currentDate = cs.getProperty("currentDate");

	public static void login(String uname, String password) throws InterruptedException {
		ConfigurationSupport cs = new ConfigurationSupport(FrameworkConstants.getGlobalpropertiespath());
		WebDriver driver = getDriver();
		driver.get(cs.getProperty("homefin_BLogin"));
		By userName=By.id("TXTusername");
		ui.type(userName, uname);
		driver.findElement(By.id("TXTpwd")).sendKeys(password);
		
		String name = ui.getAttribute(userName, "value");
		Reporter.pass ("User Name is: "+name);
	
		By no1 = By.id("txt1");
		String num1 =ui.getAttribute(no1, "value"); 
		Reporter.pass ("Captcha Text1 is: "+num1);
		
		By no2 = By.id("txt2");
		String num2 =ui.getAttribute(no2, "value");
		Reporter.pass ("Captcha Text2 is: "+num2);
		
		int no3 = Integer.parseInt(num1)+Integer.parseInt(num2);
		Reporter.pass("Addition is:"+no3);
		
		Thread.sleep(2000);
		driver.findElement(By.id("txt3")).sendKeys(Integer.toString(no3));
		Thread.sleep(2000);
		driver.findElement(By.id("CheckSignInBtn1")).click();
		Thread.sleep(2000);

	}
		


	public static void copyDirectory(String sourceDirectoryLocation) throws IOException {
		File sourceDirectory = new File(sourceDirectoryLocation);
		File destinationDirectory = new File(FrameworkConstants.getGlobalpropertiespath());
		FileUtils.copyFile(sourceDirectory, destinationDirectory);
	}

	public static void copyFiles(String sourceDirectoryLocation, String fileName) throws IOException {
		File sourceDirectory = new File(sourceDirectoryLocation);
		File destinationDirectory = new File(FrameworkConstants.getDownloadpath() + "\\" + fileName);
		FileUtils.copyFile(sourceDirectory, destinationDirectory);
	}

	public static String renameFile(String fileName) {
		String serialNumber = new SimpleDateFormat("SSS").format(new Date());
		File oldName = new File(FrameworkConstants.getDownloadpath() + "\\" + fileName);
		String extension = FilenameUtils.getExtension(oldName.toString());
		File newName = new File(
				FilenameUtils.removeExtension(oldName.getName()) + "-" + "LV-001" + serialNumber + "." + extension);
		oldName.renameTo(new File(FrameworkConstants.getDownloadpath() + "\\" + newName));
		return FilenameUtils.removeExtension(newName.getName());

	}

	public static void zipFiles(String dir) {
		File directoryToZip = new File(dir);
		List<File> fileList = new ArrayList<File>();
		getAllFiles(directoryToZip, fileList);
		writeZipFile(directoryToZip, fileList);
	}

	public static void getAllFiles(File dir, List<File> fileList) {
		try {
			File[] files = dir.listFiles();
			for (File file : files) {
				fileList.add(file);
				if (file.isDirectory()) {
					System.out.println("directory:" + file.getCanonicalPath());
					getAllFiles(file, fileList);
				} else {
					System.out.println("     file:" + file.getCanonicalPath());
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void writeZipFile(File directoryToZip, List<File> fileList) {
		try {
			FileOutputStream fos = new FileOutputStream(
					FrameworkConstants.getDownloadpath() + "//" + directoryToZip.getName() + ".zip");
			ZipOutputStream zos = new ZipOutputStream(fos);

			for (File file : fileList) {
				if (!file.isDirectory()) {
					addToZip(directoryToZip, file, zos);
				}
			}

			zos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void addToZip(File directoryToZip, File file, ZipOutputStream zos) throws IOException {
		FileInputStream fis=new FileInputStream(file);
		String zipFilePath=file.getCanonicalPath().substring(directoryToZip.getCanonicalPath().length() +1,file.getCanonicalPath().length());
		System.out.println("writing '"+ zipFilePath +"' to zip file");
		ZipEntry zipEntry=new ZipEntry(zipFilePath);
		zos.putNextEntry(zipEntry);
		
		byte[]bytes=new byte[1024];
		int length;
		while((length = fis.read(bytes)) >=0) {
			zos.write(bytes, 0, length);
		}
		
		zos.closeEntry();
		fis.close();
		
	}
	
	public static void deleteDownload() throws IOException {
		FileUtils.deleteDirectory(new File(FrameworkConstants.getDownloadpath()));
	}
	
	
	public static String renameZipTo(String oldName, String newName) {
		String serialNumber = new SimpleDateFormat("SSS").format(new Date());
		File oldFile = new File(FrameworkConstants.getDownloadpath() + "\\" + oldName);
		String extension = FilenameUtils.getExtension(oldFile.toString());
		oldFile.renameTo(new File(FrameworkConstants.getDownloadpath() + "\\" + newName +"-" + currentDate + "-"
				+ "LV010" + serialNumber + "-" + "INW" + "." +extension));
		
		return new File(FrameworkConstants.getDownloadpath() + "\\" + newName +"-" + currentDate + "-"
				+ "LV010" + serialNumber + "-" + "INW" + "." +extension).getAbsolutePath();
	}

	public static String renameTo(String oldName, String newName) {
		
		File oldFile = new File(FrameworkConstants.getDownloadpath() + "\\" + oldName);
		String extension = FilenameUtils.getExtension(oldFile.toString());
		oldFile.renameTo(new File(FrameworkConstants.getDownloadpath() + "\\" + newName + "." +extension));
		return new File(FrameworkConstants.getDownloadpath() + "\\" + newName +"." +extension).getAbsolutePath();
	}
	
	public static void overwriteTxtFileline(String filePath, String oldLine, String newLine) throws IOException {
		
		Scanner sc=new Scanner(new File(filePath));
		StringBuffer buffer=new StringBuffer();
		while(sc.hasNextLine()) {
			buffer.append(sc.nextLine() + System.lineSeparator());
		}
		
		String fileContents=buffer.toString();
		sc.close();
		
		fileContents=fileContents.replaceAll(oldLine, newLine);
		FileWriter writer=new FileWriter(filePath);
		System.out.println("");
		writer.append(fileContents);
		writer.close();
	}
	
	public static String readCellData(String path, int vRow, int vColumn) {
		String value=null;
		Workbook wb=null;
		try {
			FileInputStream fis=new FileInputStream(path);
			wb=new XSSFWorkbook(fis);
			fis.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Sheet sheet=wb.getSheetAt(0);
		Row row=sheet.getRow(vRow);
		Cell cell=row.getCell(vColumn);
		value=cell.getStringCellValue();
		return value;
		
	}
	
	
	public static String ReadXMLElement(String path, String tagName) throws ParserConfigurationException, SAXException, IOException {
		String output="";
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc=builder.parse(new File(path));
		System.out.println(doc);
		
		doc.getDocumentElement().normalize();
		System.out.println("Root element of the doc is : "+ doc.getDocumentElement().getNodeName());
		
		NodeList list=doc.getElementsByTagName(tagName);
		int totalSupplierPartID=list.getLength();
		System.out.println("Total no of Tagname"+totalSupplierPartID);
		
		for(int i=0;i<list.getLength();i++) {
			System.out.println(list.getLength());
			Node childNode=list.item(i);
			System.out.println("Tag Name :"+childNode.getTextContent());
			output=childNode.getTextContent();
			System.out.println(output);
		}
		return output;
		
	}
	
	public static String randomPRef() {
		String uuid = UUID.randomUUID().toString().replace("-", "").substring(3, 13);
		return uuid;
	}

	public static String randomBRef() {
		String uuid = UUID.randomUUID().toString().replace("-", "").substring(3, 10);
		return "BAT" + uuid;
	}

	public static String randomName() {
		return Fabricator.contact().fullName(false, false);
	}

	public static String randomEmailId() {
		return Fabricator.contact().eMail();
	}

	public static String randomAcctNum() {
		return new SimpleDateFormat("SSSHHmmmDDssMM").format(new Date());
	}

	public static String randomMobileNum() {
		return Fabricator.contact().phoneNumber();
	}

	public static String randomAddress1() {
		return Fabricator.contact().apartmentNumber() + "  " + Fabricator.contact().streetName();
	}

	public static String randomAddress2() {
		return Fabricator.contact().city();
	}

	public static String randomAddress3() {
		return Fabricator.contact().state() + "  " + Fabricator.contact().postcode();
	}

	public static String randomImpsAmt() {
		return Integer.toString(ThreadLocalRandom.current().nextInt(1, 50000));
	}

	public static String randomNeftAmt() {
		return Integer.toString(ThreadLocalRandom.current().nextInt(100000, 400000));
	}

	public static String randomRtgsAmt() {
		return Integer.toString(ThreadLocalRandom.current().nextInt(200000, 500000));
	}

	public static String randomIftAmt() {
		return Integer.toString(ThreadLocalRandom.current().nextInt(50000, 500000));
	}

	public static String randomString() {
		return Fabricator.words().word();
	}

	// returns true if data is set successfully else false
	public static boolean setCellData(String path, int colNum, int rowNum, String data) {
		try {
			FileInputStream fis = new FileInputStream(path);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);

			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow row = sheet.getRow(0);

			sheet.autoSizeColumn(colNum);
			row = sheet.getRow(0);
			if (row == null)
				row = sheet.createRow(rowNum);

			XSSFCell cell = row.getCell(colNum);
			if (cell == null)
				cell = row.createCell(colNum);

			cell.setCellValue(data);

			FileOutputStream fileOut = new FileOutputStream(path);

			workbook.write(fileOut);

			fis.close();
			fileOut.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static boolean readAndAssert(String fileName, String textToFind) throws IOException, InterruptedException {

		File file = new File(System.getProperty("user.home") + "//Downloads//" + fileName);
	//	File file=new File("C:\\Users\\12943\\git\\ExpleoFramework\\resources\\" +fileName);
		PDDocument document = Loader.loadPDF(file);
		PDFTextStripper pdfStripper = new PDFTextStripper();
		String Pdftext = pdfStripper.getText(document);
		if (Pdftext.contains(textToFind)) {
			Thread.sleep(2000);
			Reporter.pass("pdf contains :" + textToFind);
			return true;
		}

		document.close();
		return (false);
	}

	public static boolean isFileDownloaded(String fileName) {
		boolean flag = false;
		File dir = new File(FrameworkConstants.getDownloadpath());
		File[] dirContents = dir.listFiles();

		for (int i = 0; i < dirContents.length; i++) {
			if (dirContents[i].getName().contains(fileName)) {
				flag = true;
			}
		}
		return flag;
	}

	public static long getFileSize(String fileName) {
		File dir = new File(FrameworkConstants.getDownloadpath());
		File[] dirContents = dir.listFiles();
		long size = 0;

		for (int i = 0; i < dirContents.length; i++) {
			if (dirContents[i].getName().contains(fileName)) {
				size = dirContents[i].length() / 1024;
			}
		}
		return size;
	}

	public static void deleteFile(String fileName) {
		File dir = new File(FrameworkConstants.getDownloadpath());
		File[] dirContents = dir.listFiles();

		for (int i = 0; i < dirContents.length; i++) {
			if (dirContents[i].getName().contains(fileName)) {
				dirContents[i].delete();
			}
		}

	}

	public static void readCSVFile(String file, int row) throws IOException {

		FileReader fr = null;
		BufferedReader br = null;
		fr = new FileReader(file);
		br = new BufferedReader(fr);
		String line = null;
		ArrayList<Object> myList = new ArrayList<Object>();
		line = br.readLine();

		while (line != null) {
			myList.add(line);
			line = br.readLine();
		}

		FileWriter fileName;
		fileName = new FileWriter(System.getProperty("user.dir") + "\\resources" + "\\" + "Special Return File.txt");
		String str1;
		LocalDate ld = LocalDate.now();
		String s = ld.toString();
		for (int i = 1; i <= row; i++) {
			String str = myList.get(i).toString();
			str1 = str.substring(169, 181);
			str1 += "|Testing Purpose|" + s;
			fileName.write(str1 + "\n");
			Reporter.pass("" + str1);
		}
		fileName.close();
	}

	public static String DateExtraction(String location) {
		String regex = "(0?[1-9] | [12][0-9]|3[01])[/|-](0?[1-9]|1[0-2])[/|-][0-9]{4}";
		String str = "";
		String str1 = "";
		Pattern pattern = Pattern.compile(regex);
		String line;
		int flag = 0;
		LocalDate dateObj = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String strDate = dateObj.format(formatter);
		try {
			BufferedReader lineReader = new BufferedReader(new FileReader(location));
			while ((line = lineReader.readLine()) != null) {
				Matcher matchPattern = pattern.matcher(line);
				while (matchPattern.find()) {
					str = matchPattern.group();
					str1 = str1.replace(str, strDate);
					System.out.println(matchPattern.group());
					flag = 1;
				}
			}

			if (flag == 0) {
				System.out.println("The file does not contain dates");
			}
			lineReader.close();
		} catch (IOException e) {
			System.out.print("Error :" + e.getMessage());
		}
		return str;
	}

}
