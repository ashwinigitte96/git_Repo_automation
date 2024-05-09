package com.ITLearn.utility;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	public static FileInputStream inputStream;
	public static XSSFWorkbook workbook;
	public static XSSFSheet excelsheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	
	public static String getCellValue(String fileName, String sheetName,int rowNo,int cellNo) {
		try {
			inputStream = new FileInputStream(fileName);
			workbook = new XSSFWorkbook(inputStream);
			excelsheet = workbook.getSheet(sheetName);
			cell = workbook.getSheet(sheetName).getRow(rowNo).getCell(cellNo);
			workbook.close();
			return cell.getStringCellValue();
		}catch(Exception e) {
			System.out.println("can not read excel" + e.getMessage());
			return "";
		}
	}
	public static int getRowCount(String fileName, String sheetName) {
		try {
			inputStream = new FileInputStream(fileName);
			
			workbook = new XSSFWorkbook(inputStream);
			excelsheet = workbook.getSheet(sheetName);
			
			int ttlRows = excelsheet.getLastRowNum() + 1;
			workbook.close();
			return ttlRows;
		} catch(Exception e) {
			return 0;
		}
	}
	public static int getCellCount(String fileName, String sheetName) {
		try {
			inputStream = new FileInputStream(fileName);
			
			workbook = new XSSFWorkbook(inputStream);
			excelsheet = workbook.getSheet(sheetName);
			int ttlCell = excelsheet.getRow(0).getLastCellNum()	;	
			workbook.close();
			return ttlCell;
			} catch(Exception e) {
				return 0;
			}
	}
	
	public String getStringData(int SheetIndex, int row, int column) {
		return workbook.getSheetAt(SheetIndex).getRow(row).getCell(column).getStringCellValue();
		
	}
	public static String getStringData(String sheetName, int row, int column) {
		return workbook.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}
	public static double getNumericData(String sheetName,int row ,int column) {
		return workbook.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();	
		}
}
