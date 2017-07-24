package constants;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Excel {

	//the format of the excel need to contain column name
	//then can retrieve values by key (column name)
	public static List<HashMap<String, ArrayList<String>>> readWorkBook(String filePath, int sheetNumber) throws Exception {
//		if (filePath.toLowerCase().endsWith("xls")) {
//			return readWorkBookforXLS(filePath, sheetNumber);
//		}
		InputStream ins = new FileInputStream(filePath);
		XSSFWorkbook wb = new XSSFWorkbook(ins);
		XSSFSheet sheet1 = wb.getSheetAt(sheetNumber);
		int rowCount = sheet1.getLastRowNum();
		int firstRowNum = 0;
		List<HashMap<String, ArrayList<String>>> values = new ArrayList<HashMap<String, ArrayList<String>>>();
		//List<HashMap<String, String>> types = new ArrayList<HashMap<String, String>>();
		List<String> head = new ArrayList<String>();
		List<String> types = new ArrayList<String>();
		for (int currentRowNum = firstRowNum; currentRowNum <= rowCount; currentRowNum++) {
			XSSFRow row = sheet1.getRow(currentRowNum);
			HashMap<String, ArrayList<String>> rowValue = new HashMap<String, ArrayList<String>>();
			for (int i = 0; i < sheet1.getRow(0).getLastCellNum(); i++) {
				// get column name values
				if (currentRowNum == 0) {
					head.add(getStrValue(row.getCell(i)));
				} else if (currentRowNum == 1) {
					types.add(getStrValue(row.getCell(i)));
				} else {
					ArrayList<String> typeVal = new ArrayList<String>();
					typeVal.add(types.get(i));
					typeVal.add(getStrValue(row.getCell(i)));
					rowValue.put(head.get(i), typeVal);
				}
			}
			if(currentRowNum > 1) { //will add 1st row value to the list
				values.add(rowValue);
			}
		}
		ins.close();
		return values;
	}

	public static List<HashMap<String, String>> readWorkBookforXLS(String filePath, int sheetNumber) throws Exception {
		InputStream ins = new FileInputStream(filePath);
		org.apache.poi.ss.usermodel.Workbook wb = WorkbookFactory.create(ins);
		org.apache.poi.ss.usermodel.Sheet sheet = wb.getSheetAt(sheetNumber);

		int rowCount = sheet.getLastRowNum();
		int firstRowNum = 0;
		List<HashMap<String, String>> values = new ArrayList<HashMap<String, String>>();
		List<String> head = new ArrayList<String>();
		for (int currentRowNum = firstRowNum; currentRowNum <= rowCount; currentRowNum++) {
			Row row = sheet.getRow(currentRowNum);
			HashMap<String, String> rowValue = new HashMap<String, String>();
			for (int i = 0; i < sheet.getRow(0).getLastCellNum(); i++) {
				// get column name values
				if (currentRowNum == 0) {
					head.add(getStrValueXLS(row.getCell(i)));
				} else {
					rowValue.put(head.get(i), getStrValueXLS(row.getCell(i)));
				}
			}
			if(currentRowNum > 0) { //dont add 1st row value
				values.add(rowValue);
			}
		}
		ins.close();
		return values;
	}

	public static String getStrValue(XSSFCell cell) {
		String strval = null;
		if (cell==null) {
			return "";
		}
		if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
			strval = String.valueOf((int) cell.getNumericCellValue());
		} else {
			strval = cell.getStringCellValue();
		}
		if (null == strval || "NULL".equalsIgnoreCase(strval)) {
			strval = "";
		}
		char nbsp = 0x00a0;
		return StringUtils.trim(strval.replace(nbsp, ' '));
	}

	public static String getStrValueXLS(Cell cell) {
		String strval = null;
		if (cell==null) {
			return "";
		}
		if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
			strval = String.valueOf((int) cell.getNumericCellValue());
		} else {
			strval = cell.getStringCellValue();
		}
		if (null == strval || "NULL".equalsIgnoreCase(strval)) {
			strval = "";
		}
		char nbsp = 0x00a0;
		return StringUtils.trim(strval.replace(nbsp, ' '));
	}
}
	

