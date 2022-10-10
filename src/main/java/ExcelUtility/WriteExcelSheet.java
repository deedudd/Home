package ExcelUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import resources.Base;

public class WriteExcelSheet extends Base {

	public static void writeExcelData(int rowNo, int colNo, String Result) throws IOException {
		String path = prop.getProperty("filePath");
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		sheet.getRow(rowNo).createCell(colNo).setCellValue(Result);
		 FileOutputStream fos = new FileOutputStream(path); 
		   wb.write(fos); 
		   fos.flush(); 
		   fos.close(); 
		}
	}

