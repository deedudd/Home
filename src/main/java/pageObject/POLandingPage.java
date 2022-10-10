package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.Base;

public class POLandingPage extends Base {
	public WebDriver driver;
	
	public  POLandingPage(WebDriver driver) {
		this.driver = driver;
	}

	By signin = By.xpath("//span[contains(text(),'Login')]");
	By title = By.xpath("//h2[contains(text(),'Featured Courses')]");
	By navigation = By.cssSelector("ul.nav.navbar-nav.navbar-right");
	
	By signinredbus = By.id("sign-in-icon-down");
	By signupredbus = By.id("signInLink");
	By googlelinkxpath = By.xpath("//iframe[@title='Sign in with Google Button']");
	By selectmode = By.xpath("//body/div[@id='container']/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]");
	By confirm = By.cssSelector("div#confirm_yes");
	
	
	public WebElement signinredbus() {
		return driver.findElement(signinredbus);
		
	}
	
	public WebElement signup() {
		return driver.findElement(signupredbus);
		
	}
	
	public WebElement googlelink() {
		return driver.findElement(googlelinkxpath);
		
	}
	
	public WebElement selectid() {
		return driver.findElement(selectmode);
		
		
	}
	
	public WebElement confirm() {
		return driver.findElement(confirm);
		
	}
	
	
	
	public WebElement getlogin() {
		return driver.findElement(signin);
	}
	public WebElement gettitle() {
		return driver.findElement(title);
	}
	public WebElement getNavigation() {
		return driver.findElement(navigation);
	}
}
