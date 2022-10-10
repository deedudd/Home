package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POGooglPage {
	public WebDriver driver;
	public POGooglPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath="//div[@class='FPdoLc lJ9FBc']/center/input[@class='gNO89b']")
	WebElement searchXpath;
	
	public WebElement search() {
		return searchXpath;
	}
}
