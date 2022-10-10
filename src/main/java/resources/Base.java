 package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.Test;

public class Base {
	public static Properties prop;
	public WebDriver driver;
	@Test
	
	public WebDriver initializer() throws IOException {
	String path = "C:\\Users\\deepi\\eclipse-workspace\\Home\\src\\main\\java\\resources\\data.properties";
	FileInputStream fis = new FileInputStream(path);
	prop = new Properties();
	prop.load(fis);
	//ProfilesIni profile = new ProfilesIni();
	
	String browserName = System.getProperty("browser");
	ChromeOptions options = new ChromeOptions();
	//options.setExperimentalOption("excludeSwitches", '')
	//options.addArguments("user-data-dir=C:/Users/deepi/AppData/Local/Google/Chrome/User Data");
	//options.addArguments("profile-directory=Profile 1");
	
	//options.addArguments("--start-maximized");
	if(browserName.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\deepi\\Downloads\\chromedriver_win32 (5)\\chromedriver.exe");
		driver= new ChromeDriver(options);
	}
	else if(browserName.equalsIgnoreCase("firefox")) {
		
	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	return driver;

	
}
public String getScreenShot(String testname, WebDriver driver) throws IOException {
	String path = System.getProperty("user.dir")+"\\reports\\"+testname+"Screenshot"+".png";
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File(path));
	
	return path;
	
}

}
