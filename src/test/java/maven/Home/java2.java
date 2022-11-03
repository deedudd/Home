package maven.Home;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Level;
import org.testng.annotations.Test;

import pageObject.POGooglPage;

public class java2 {
	@Test
	public void method1() throws IOException {

		String s = "we love india";
		String TempString = "", str = "";
		String[] arr = s.split(" ");
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1) {
				str = arr[i];
			} else
				str = arr[i].substring(0, 1);
			TempString = TempString + " " + str;

		}

		System.out.println(TempString);

	}

	@Test
	public void method5() {
		String s1 = "deepika is a woman is";
		String[] arr = s1.split(" ");
		String newStr = "";
		List<String> lst = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if (!lst.contains(arr[i])) {
				lst.add(arr[i]);
			}
		}
		for (int i = 0; i < lst.size(); i++)
			newStr = newStr + (lst.get(i) + " ");

		System.out.println(newStr);
	}

	@Test
	public void method2() {
		int row = 0;
		int[][] arr = { { 9, 2 }, { 1, 8 } };
		int big = arr[0][0];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] > big) {
					big = arr[i][j];
					row = i;
				}
			}
		}
		int small = arr[row][0];
		for (int i = 0; i < arr.length; i++) {
			if (small > arr[row][i]) {
				small = arr[row][i];
				// System.out.println(small);
			}
		}
		System.out.println(big);
		System.out.println(small);
	}

	@Test
	public void method6() {

		int r, num = 231;
		int sum = 0;
		while (num > 0) {
			r = num % 10;
			sum = sum * 10 + r;
			num = num / 10;
		}
		System.out.println(sum);
	}

	@Test
	public void primeCheck() {
		int num = 87;
		boolean IsPrime = true;
		if (num % 2 == 0) {
			IsPrime = false;
		}

		for (int i = 3; i < Math.sqrt(num); i += 2) {
			if (num % i == 0) {
				IsPrime = false;
			}
		}
		System.out.println(IsPrime);
	}

	@Test
	public void palindrome() {
		int fact = 1, r, num = 6;
		for (int i = 1; i <= num; i++) {
			fact = fact * i;
		}
		System.out.println(fact);

	}

	@Test
	public void pattern() {
		for (int i = 0; i < 5; i++) {
			for (int k = 0; k <= 5 - i; k++) {
				System.out.print(" ");
			}
			for (int j = 0; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	@Test
	public void bigNumber() {
		int[][] arr = { { 1, 2 }, { 3, 4 } };
		int bigRow = 0, big = arr[0][0];
		for (int i = 0; i < arr[0].length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (big < arr[i][j]) {
					big = arr[i][j];
					bigRow = i;
				}
			}
		}
		System.out.println(bigRow);
		System.out.println(big);
		int small = arr[bigRow][0];
		for (int i = 0; i < arr[bigRow].length; i++) {
			if (small > arr[bigRow][i]) {
				small = arr[bigRow][i];
			}
		}
		System.out.println(small);
	}

	@Test
	public void excelRead() throws IOException {

		String s1 = "ButomAtion",newStr="";
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) >= 'A' && s1.charAt(i) < 'Z') {
				newStr = newStr+s1.charAt(i);
				System.out.println(newStr);
			}

		}
	}

	@Test
	public void nhsJobs() throws IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\deepi\\Downloads\\chromedriver_win32 (9)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.nhsjobs.com/");
		System.out.println("launched page in experiment2");
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\deepi\\eclipse-workspace\\Home\\reports\\nhsJobs.png"));
		
		
	}
	@Test
	public void sele() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32 (6)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		// driver.findElement(By.xpath("//div[@class='FPdoLc
		// lJ9FBc']/center/input[@class='gNO89b']")).click();
		POGooglPage pg = new POGooglPage(driver);
		pg.search().click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@role='presentation' and @name=\"callout\"]")));
		Actions a = new Actions(driver);

		a.moveToElement(driver.findElement(By.xpath("//button[@aria-label='No thanks']"))).click().build().perform();
	}

}
