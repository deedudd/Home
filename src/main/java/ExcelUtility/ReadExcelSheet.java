package ExcelUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import resources.Base;

public class ReadExcelSheet extends Base {

	public void readExcelData(int colNo) throws IOException {
		
		//String path = prop.getProperty("filePath");
	
		FileInputStream fis = new FileInputStream("C:\\Users\\deepi\\eclipse-workspace\\DataDriven1\\src\\main\\java\\TestData\\seleniumPractice.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		Iterator<Row> row = sheet.iterator();
	
		while(row.hasNext()) {
			//System.out.println(row.next().getCell(colNo).getStringCellValue());
		
			Row r = row.next();
		Iterator<Cell> cell = r.iterator();
		while(cell.hasNext()) {
			System.out.println(cell.next().getStringCellValue());
		}
		}
	//	System.out.println(sheet.getRow(1).getCell(1).getStringCellValue());
		//Row r = row.next();
		
		/*Row r = row.next();
		ArrayList<String> list = new ArrayList<>();
		while (row.hasNext()) {
				list.add(row.next().getCell(colNo).getStringCellValue());
		}
	return list;*/
	}
public static void main(String[] args) throws IOException {
	ReadExcelSheet rs = new ReadExcelSheet();
	rs.readExcelData(1);
}
}
