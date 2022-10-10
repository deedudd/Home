package maven.Home;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.internal.Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class java3 {
	@Test
	public void method1() {
		int[] arr = { 1, 2, 3, 4 };
		int even=0,odd=0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]%2 == 0) 
				even++;
			else
				odd++;
		}
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32 (6)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement ele = driver.findElement(By.id("dropdown-class-example"));
		Select drop = new Select(ele);
		drop.selectByIndex(1);
		drop.selectByIndex(2);
		List<WebElement> lst1 = drop.getOptions();
		for(int i=0;i<lst1.size();i++) {
			System.out.println(lst1.get(i).getText());
		}
		System.out.println(drop.getFirstSelectedOption().getText());
		System.out.println(drop.getAllSelectedOptions().get(0).getText());
	}
	@Test
	public void method2() throws AWTException {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32 (6)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in");
		WebElement ele = driver.findElement(By.xpath("//span[text()='Account & Lists']"));
		Actions a = new Actions(driver);
		
//		Robot r = new Robot();
//		r.keyPress(KeyEvent.VK_CONTROL);
//		r.keyPress(KeyEvent.VK_T);
//		r.keyRelease(KeyEvent.VK_CONTROL);
//		r.keyRelease(KeyEvent.VK_T);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('twotabsearchtextbox').value='hello';");
		
		
	}
	@Test(enabled=false)
	public void method3() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32 (6)\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		FirefoxOptions foptions = new FirefoxOptions();
		foptions.setCapability(CapabilityType.BROWSER_NAME, "firefox");
		options.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),foptions);
		driver.get("https://www.amazon.in");
		 driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),options);
		driver.get("https://www.amazon.in");
		System.out.println("another node");
	}
	@Test
	public void fram() throws IOException {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32 (6)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com");
//		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='/frame_top']")));
//		System.out.println(driver.findElements(By.tagName("frame")).size());
//		
//		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='/frame_left']")));
//		
//		System.out.println(driver.findElement(By.xpath("//html/body")).getText());
//			
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\deepi\\eclipse-workspace\\Home\\reports\\fram.png"));
	}
	WebDriver driver;
	
	
	@Test(dataProvider = "getData",groups="smoke")
	public void screen(String urlName) throws IOException {
	
		System.out.println(urlName);
	
	}
	
	@DataProvider
	public Object[] getData() {
		Object[] data= new Object[1];
		data[0]="two";
		
		return data;
	
		
	}
	@Test
	public void extrep() throws IOException {
		String path="C:\\Users\\deepi\\eclipse-workspace\\Home\\reports\\exteep.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("MyReport");
		reporter.config().setDocumentTitle("MyDocTitle");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("username", "testname");
		
		extent.createTest("sampleTest");
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32 (6)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com");
		String Screenshotpath= "C:\\Users\\deepi\\eclipse-workspace\\Home\\reports\\extRep.png";
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(Screenshotpath));
		ThreadLocal<ExtentTest> extenttest = new ThreadLocal<>();
		ExtentTest test = extent.createTest("sample2Test");
		extenttest.set(test);
		test.addScreenCaptureFromPath(Screenshotpath);
		extent.flush();
		
		
	}
	@Test
	public void method4() throws IOException {
	
	}
	
}
