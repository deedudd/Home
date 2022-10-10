package maven.Home;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class constructExample {

	int i = 10;

	public static void test1() {
		int[] arr = { 2, 4, 1, 3, 2 };
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					arr[i] = arr[j];
				}

			}
			System.out.print(arr[i]);
			
		}
		int k=0;
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i]!=arr[i+1]) {
				arr[k++]=arr[i];
			}
		}
		arr[k++]=arr[arr.length-1];
		for(int i=0;i<k;i++) {
			System.out.println(arr[i]);
		}
		
	}

	public static void test2() {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32 (6)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	
		
		System.out.println("hello");

		WebElement ele = driver.findElement(By.xpath("//a[text()='Latest News']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()",ele);
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test2();
	}

}
