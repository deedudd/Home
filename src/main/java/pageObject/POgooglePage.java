package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POgooglePage {
	public WebDriver driver;
	public POgooglePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	By username = By.xpath("");
	
	public WebElement username() {
	return driver.findElement(username);
	}
	@FindBy(xpath="")
	WebElement gmail;
	
	public WebElement gmail() {
		return gmail;
	}
}
