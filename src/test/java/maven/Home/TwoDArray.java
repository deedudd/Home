package maven.Home;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObject.POgooglePage;
import resources.Base;

public class TwoDArray extends Base {
	public WebDriver driver;

	@Test
	private void dbconn() throws SQLException {
	Connection con = DriverManager.getConnection(null);
	Statement s = 	con.createStatement();
	ResultSet rs   = s.executeQuery("");
	System.out.println(rs.toString());
 
	}

	@Test
	public void goo() throws IOException {
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\deepi\\Downloads\\chromedriver_win32 (5)\\chromedriver.exe");
		driver = initializer();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();

		POgooglePage gp = new POgooglePage(driver);
		gp.gmail().click();
		// driver.findElement(By.xpath("//a[@class='gb_d' and
		// @data-pid='23']")).click();
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,100)");
	}

	@Parameters({ "url", "browsername" })
	@Test
	private void excelretrieval(String url, String browsername) throws IOException {
		String path ="C:\\Users\\deepi\\OneDrive\\Desktop\\seleniumPractice.xlsx";
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		Iterator<Row> row = sheet.iterator();
		
		while(row.hasNext()) {
			Row r = row.next();
			Iterator<Cell> cell = r.iterator();
			System.out.println();
			while(cell.hasNext()) {
			System.out.print(cell.next()+"   ");
		}
		}
		
	}

	@Test
	private void smallest() {
		int[][] arr = { { 4, 3, 6 }, { 1, 4, 5 } };
		int big = arr[0][0];
		int row = 0;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				if(big<arr[i][j]) {
					big=arr[i][j];
					row=i;
				}
			}
		}
		int small=arr[row][0];
		for(int i=0;i<arr.length;i++) {
			if(small>arr[row][i]) {
				small=arr[row][i];
			}
		}
		System.out.println(small);
	}

	@Test
	private void pyramid() {
		for(int i=0;i<5;i++) {
			for(int j=0;j<5-(i);j++) {
				System.out.print(" ");
			}
			for(int k=0;k<i;k++) {
				System.out.print("* ");
			}
			
			System.out.println();
		}
	}

	@Test

	private void primeCheck() {
		int num = 12;
		boolean isPrime = true;
		if (num % 2 == 0) {
			isPrime = false;
		}
		for (int i = 3; i < Math.sqrt(num); i += 2) {
			if (num % i == 0) {
				isPrime = false;
			}
		}
		System.out.println(isPrime);
	}

	@Test
	private void palindrome() {
		int num = 98765976, r, sum = 0;
		while (num > 0) {
			r = num % 10;
			sum = sum * 10 + r;
			num = num / 10;
		}
		System.out.println(sum);

		String s = "qwerty", nstr = "";
		for (int i = 0; i < s.length(); i++) {
			nstr = s.charAt(i) + nstr;
		}
		System.out.println(nstr);

		String s1 = "Brocky123";
		int j=s1.charAt(0);
		String str = Integer.toString(j);
		int str2 = Integer.parseInt(str);
		System.out.println(str2+ "is str");
		System.out.println(j);
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) < 100 && s1.charAt(i) > 95) {
				System.out.print(s1.charAt(i));
			}
		}
	}

	@Test
	private void dup() {
		char[] arr = { 'a', 's', 'f', 's', 'a' };
		int cnt = 1;
		for (int i = 0; i < arr.length; i++) {
			cnt = 1;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					arr[j] = ' ';
					cnt++;

				}
			}
			if (arr[i] != ' ' && cnt > 1) {
				System.out.println(arr[i]);
			}
		}
	}

	@Test
	private void arrSort() {
		int[] arr = { 2, 1, 4, 3, 6 };
		int temp;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;

				}
			}
			System.out.println(arr[i]);
		}
		System.out.println(Arrays.toString(arr));
	}

	@Test
	private void dupremoval() {
		int[] arr = { 2, 3, 1, 2, 4, 3, 2 };
		int k = 0;
		Arrays.sort(arr);
		for (int i = 0; i < arr.length - 1; i++) {

			if (arr[i] != arr[i + 1]) {
				arr[k++] = arr[i];
			}
		}
		arr[k++] = arr[arr.length - 1];
		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < k; i++) {
			System.out.println(arr[i]);
		}
	}
}