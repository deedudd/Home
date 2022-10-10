package maven.Home;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class javaPrograms {
	@Test(enabled = false)
	private static void excelReadWrite() throws IOException {
		String path = "C:\\Users\\deepi\\OneDrive\\Desktop\\seleniumPractice.xlsx";
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		Iterator<Row> row = sheet.iterator();
		while (row.hasNext()) {
			Row r = row.next();
			r.createCell(4);
			r.getCell(4).setCellValue("finish");
			Iterator<Cell> cell = r.iterator();
			while (cell.hasNext()) {
				System.out.println(cell.next().getStringCellValue());
			}
		}
		FileOutputStream fos = new FileOutputStream(path);
		wb.write(fos);
		fos.close();
	}

	@Parameters({ "url", "browserName" })
	@Test(enabled=false)
	private void paramMethod(String url, String browserName) {
		System.out.println(url);
		System.out.println(browserName);
	}

	@DataProvider
	private Object[][] dataproviderMethod() {
		Object[][] data = new Object[2][2];
		data[0][0] = "uname1";
		data[0][1] = "pwd1";
		data[1][0] = "uname2";
		data[1][1] = "pwd2";

		return data;

	}
	@Test(dataProvider = "dataproviderMethod",enabled = false)
	private void getdata(String uname,String pwd) {
		System.out.println(uname);
		System.out.println(pwd);
	}

	@Test(enabled = false)
	private void duplicateRemoval() {

		int[] arr = { 2, 4, 1, 3, 1 };
		int k = 0;
		int count=1;
		for(int i=0;i<arr.length;i++) {
			count=1;
			for(int j=0;j<arr.length;j++) {
				if(arr[i]==arr[j]) {
					arr[j]=' ';
					count++;
				}
			}
			if(count>1 && arr[i]!=' ') {
				System.out.println(arr[i]);
			}
		}
				
		Arrays.sort(arr);
			for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] != arr[i + 1]) {
				arr[k++] = arr[i];
			}

			// System.out.println(arr[k-1]);
		}
		arr[k++] = arr[arr.length - 1];
		for (int i = 0; i < k; i++) {
			System.out.println(arr[i]);
		}
	}

	@Test(enabled = false)
	private void sorting() {
		int temp = 0;
		int[] arr = { 3, 2, 6, 4, 1 };
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			// System.out.println(arr[i]);
		}
		System.out.println(arr[arr.length - 3]);
	}

	@Test(enabled = false)
	private void arraySum() {
		int[] arr = { 1, 2, 3, 4 };
		int sum = 3;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if ((arr[i] + arr[j]) == sum) {
					System.out.println(arr[i] + "+" + arr[j] + " is equal to " + sum);
				}
			}
		}
	}

	@Test(enabled = false)
	private void excelSheetRetrieval() throws IOException {
		String path = "C:\\Users\\deepi\\OneDrive\\Desktop\\seleniumPractice.xlsx";
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		Iterator<Row> row = sheet.iterator();

		Row r = row.next();
		Iterator<Cell> cell = r.iterator();

		System.out.println(r.getCell(0).getStringCellValue());
		System.out.println(r.getCell(1).getStringCellValue());
		System.out.println(r.getCell(2).getStringCellValue());
	}
	WebDriver driver;
	@Test
	private void ifDigitPresent() {
		String s="deepika";
		boolean isPresent=false;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)<65) {
				isPresent=true;
			}
		}
		System.out.println("digit ispresent"+isPresent);
	}
	
	@Test(enabled=false)
	private void extentMethod() throws IOException, AWTException, InterruptedException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
		System.out.println(java.time.LocalTime.now());
		
		LocalDateTime now= LocalDateTime.now();
		
		String path = "C:\\Users\\deepi\\eclipse-workspace\\Home\\test-output\\reports\\extentReports.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("report by deepika");
		reporter.config().setDocumentTitle("AutomationResults");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		ExtentTest test = extent.createTest("todays test");
		System.out.println("A small print statement is my todays test");
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://www.google.com");
	
		driver.manage().window().maximize();
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'No thanks')]")));
		//driver.findElement(By.xpath("//button[contains(text(),'No thanks')]")).click();
		
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_N);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_N);
		System.out.println(driver.getWindowHandles().size());
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentid = it.next();
		String childid = it.next();
		driver.switchTo().window(childid);
		System.out.println(driver.getCurrentUrl());
		String screenshotpath="C:\\Users\\deepi\\eclipse-workspace\\Home\\test-output\\screenshot1.png";
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(screenshotpath));
		driver.switchTo().window(parentid);
		String screenshotpath2="C:\\Users\\deepi\\eclipse-workspace\\Home\\test-output\\screensho2t.png";
		File src2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src2, new File(screenshotpath2));
		test.addScreenCaptureFromPath(screenshotpath);
		test.addScreenCaptureFromPath(screenshotpath2);
		extent.flush();
	}

}