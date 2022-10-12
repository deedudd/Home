package maven.Home;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

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

import org.apache.log4j.Level;
import org.testng.annotations.Test;

import pageObject.POGooglPage;

public class java2 {
	@Test
	public void method1() throws IOException {
	String[] arr = {"a","d"};
	int temp;
	List<String> lst = Arrays.asList(arr);
	System.out.println(lst);

	System.out.println(lst);
	}

	@Test
	public void method5() {
		String s1 = "deepika is a woman is";
		String[] arr = s1.split(" ");
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			cnt = 0;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i].equals(arr[j])) {
					arr[j] = " ";
					cnt++;
				}
			}
			if (cnt > 0 && arr[i] != " ") {
				System.out.println(arr[i]);
			}
		}
	}

	@Test
	public void method2() {
		int x;
		int[] arr = { 1, 2, 5, 7, 1, 2, 1, 7 };
		List<Integer> lst = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			lst.add(arr[i]);
		}
		Set<Integer> st = new HashSet<>();
		st.add(1);
		st.add(2);

		System.out.println(st);
//		List<Integer> lst1 = new ArrayList<>();
//		lst1.addAll(st);
		// System.out.println(lst1);

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
		int sum = 0, r, num = 1234321;
		int num1 = num;
		while (num > 0) {
			r = num % 10;
			sum = sum * 10 + r;
			num = num / 10;
		}
		System.out.println(sum);
		if (sum == num1) {
			System.out.println("palindrome");
		}
	}

	@Test
	public void pattern() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5 - i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k < i; k++) {
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

		String s1 = "ButomAtion";
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) >= 'A' && s1.charAt(i) < 'Z') {
				System.out.println(s1.charAt(i));
			}

		}
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

	@Test
	public void todaytest1() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys("selenium interview questions");

		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@jsname='VlcLAe']//descendant::input[@value='Google Search']")).click();
		driver.findElement(By.xpath("//a[contains(@href,'simplilearn')]/parent::div[@class='yuRUbf']")).click();
		System.out.println(driver.getTitle());

		// driver.close();
	}

	@Test
	public void dupli() {
		char[] c = {'a','b'};
		String[] s1 = {"wrfr","fwer"};
		char[] car = new char[10];
		String[] sar = new String[10];
		
		List<String> lst = new ArrayList<>();
		ArrayList<String> lst2 = new ArrayList<>();
		
		lst.add("deepika");
		lst.add("kishore");
		lst.add(1, "aniket");
		System.out.println(lst.get(1));
		lst2.add("deepika");
		lst2.add("kishore");
		lst2.add(1, "aniket");
		System.out.println(lst2.get(1));
		

		
	}
	@Test
	public void matrix() {
		
		for(int i=0;i<5;i++) {
			for(int k=5-i;k<5;k++) {
				System.out.print(" ");
			}
			for(int j=0;j<5-i;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	@Test
	public void dInt() {

		int[][] arr = {{2,5},{4,7}};
		int[][] arr1 = new int[2][3];
		int row=0;
		int big=arr[0][0];

		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				if(big<arr[i][j]) {
					big=arr[i][j];
					row = i;
				}
			}
			
			
		}
		int small = arr[row][0];
		for(int k=0;k<arr.length;k++) {
			if(small>arr[row][k]) {
				small=arr[row][k];
			}
		}
		System.out.println(big);
		System.out.println(small);
		
		
		
	}
	@Test
	public void prime() {
		
	}
}
