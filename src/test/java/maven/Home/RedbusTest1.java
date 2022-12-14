package maven.Home;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.PORedbusLandingPage;
import resources.Base;

public class RedbusTest1 extends Base {
	public WebDriver driver;

	@Test
	public void drop() throws IOException {
		driver = initializer();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		Select drop = new Select(dropdown);
		drop.selectByValue("option2");
		drop.selectByIndex(0);
		System.out.println(drop.getFirstSelectedOption().getText());
		
	}
	
	@Test(enabled=false)
	public void dropdown() throws IOException {
		//driver = initializer();
		driver.get(prop.getProperty("url1"));
		PORedbusLandingPage rbl = new PORedbusLandingPage(driver);
		rbl.fromStation().sendKeys("hyd");

		for (int i = 0; i < rbl.froStationList().size(); i++) {
			if (rbl.froStationList().get(i).getText().contentEquals("Kukatpally, Hyderabad")) {
				rbl.froStationList().get(i).click();
			}
		}
		rbl.toStation().sendKeys("Madhavaram, Chennai");
		Actions a = new Actions(driver);
		a.keyDown(Keys.ENTER).build().perform();
		rbl.date().click();
		int k = 0;
		System.out.println(driver.findElement(By.xpath("//td[@class='monthTitle']")).getText());
		while (true) {
			if (driver.findElement(By.xpath("//td[@class='monthTitle']")).getText().equalsIgnoreCase("Jun 2022")) {
				driver.findElement(By.xpath("//td[text()=\"5\"]")).click();
				break;
			}
			driver.findElement(By.xpath("//td[@class=\"next\"]")).click();
			k++;
			if (k > 12) {
				break;
			}
		}
		rbl.searchBuses().click();
		List<WebElement> lstOfBuses = driver.findElements(By.cssSelector("div.clearfix.bus-item"));
		if(lstOfBuses.size()==0) {
			Assert.assertEquals(driver.findElement(By.xpath("//h3[contains(text(),'Oops! No buses found.')]")).getText(),"Oops! No buses found.");
		}
		driver.navigate().back();
		String color = driver.findElement(By.xpath("//a[@id='redBus']")).getCssValue("color");
		String bg = driver.findElement(By.xpath("//a[@id='redBus']")).getCssValue("backgroundcolor");
		System.out.println(color);
		System.out.println(bg);
	}
}
