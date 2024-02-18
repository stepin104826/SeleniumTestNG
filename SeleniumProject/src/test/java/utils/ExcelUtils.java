package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	static String project_path;
	static XSSFWorkbook workbook; 
	static XSSFSheet sheet;
	
	public ExcelUtils(String excel_path, String sheet_name) {
		try {
			String project_path = System.getProperty("user.dir");
			workbook = new XSSFWorkbook(project_path+ excel_path);
			sheet = workbook.getSheet(sheet_name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int getRowCount() {
		int row_num = 0;
		try {
			
			row_num = sheet.getPhysicalNumberOfRows();
//			System.out.println(row_num);
		}
		catch(Exception ex) {
			ex.getMessage();
		}
		return row_num;
	}
	
	public static int getColCount() {
		int col_num = 0;
		try {
			
			col_num = sheet.getRow(1).getPhysicalNumberOfCells();
//			System.out.println(row_num);
		}
		catch(Exception ex) {
			ex.getMessage();
		}
		return col_num;
	}
	
	public static String getStringCellValue(int row_num, int col_num) {
		String cell_val="";
		try {
			cell_val = sheet.getRow(row_num).getCell(col_num).getStringCellValue();	
//			System.out.println(cell_val);
		}
		catch(Exception ex) {
			ex.getMessage();
		}
		return cell_val;
	}
	
	public static String getNumCellValue(int row_num, int col_num) {
		double cell_val = 0;
		try {
			cell_val = sheet.getRow(row_num).getCell(col_num).getNumericCellValue();
		}
		catch(Exception e) {
			e.getMessage();
		}
		String str = cell_val+"";
		return str;
	}
}
