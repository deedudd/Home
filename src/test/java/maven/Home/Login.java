package maven.Home;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageObject.POLandingPage;
import pageObject.POSignInPage;
import resources.Base;

public class Login extends Base {

	@Test
	
public void HomePageNavigation(String phNo) throws IOException, InterruptedException {
	//driver=initializer();
	driver.get(prop.getProperty("url1"));
	POLandingPage lp = new POLandingPage(driver);
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	lp.signinredbus().click();
	
	  Actions a = new Actions(driver); 
	 a.moveToElement(lp.signup()).click().build().perform(); 
	 Thread.sleep(3000); 
	
	 
	 int siz = (driver.findElements(By.tagName("iframe")).size());
	 System.out.println(siz);
	 driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.modalIframe")));

	 lp.googlelink().click(); 
Set<String> wins= driver.getWindowHandles();
Iterator<String> it = wins.iterator();
String parentid = it.next();
driver.switchTo().window(it.next());
driver.findElement(By.xpath("//div[contains(text(),'deepikamaddula85@gmail.com')]")).click();
System.out.println(driver.getWindowHandles().size());
driver.switchTo().window(parentid);
driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.modalIframe")));
driver.findElement(By.cssSelector("input#mobileNo")).sendKeys(phNo);
driver.findElement(By.cssSelector("button#sendOTP")).click();
driver.switchTo().defaultContent();
driver.findElement(By.cssSelector("div[class='modalCloseSmall'] i[class='icon-close']")).click();

lp.signinredbus().click();
a.moveToElement(driver.findElement(By.cssSelector("li#signOutLink"))).click().build().perform();

	}
	public static void main(String[] args) throws IOException, InterruptedException {
		Login l= new Login();
		l.HomePageNavigation("9000837200");
	}
}
