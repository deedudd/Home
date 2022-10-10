package maven.Home;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObject.POLandingPage;
import resources.Base;

public class ValidateNavigationbar extends Base {
	public WebDriver driver;

	@Parameters({ "browsername", "url" })
	@Test
	public void initialize(String browserName, String url) throws IOException {
		// driver = initializer();
		// driver.get(prop.getProperty("url"));
		System.out.println(browserName + url);
	}

	@DataProvider
	public Object[][] getdata() {
		Object[][] data = new Object[1][1];
		data[0][0] = "small";
		return data;
	}

	@Test(dataProvider = "getdata")
	public void dataRequired(String data) {
		System.out.println(data);
	}

	@Test(dependsOnMethods = {"dataRequired",""})
	public void navigationBar() throws IOException {
		driver.get(prop.getProperty("url"));

		System.out.println(driver.getCurrentUrl());
		POLandingPage lp = new POLandingPage(driver);
//	Assert.assertTrue(lp.getNavigation().isDisplayed());
		System.out.println("second done");
	}

	@AfterTest(enabled = false)
	public void tearDown() {

		driver.close();
	}
}
