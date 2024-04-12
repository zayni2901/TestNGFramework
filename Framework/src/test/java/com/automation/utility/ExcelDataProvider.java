package com.automation.utility;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	
	public ExcelDataProvider() {
		
		File src = new File("./TestData/TestData.xlsx");
		
		try {
			FileInputStream fis = new  FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} 
		catch (Exception e) 
		{
			System.out.println("Unable to read Excel file "+e.getMessage());
			
			
		}
		
	}
public String getStringData(int SheetIndex, int row, int column) {
		
		return wb.getSheetAt(SheetIndex).getRow(row).getCell(column).getStringCellValue();
	}
	
	public String getStringData(String Sheetname, int row, int column) {
		
		return wb.getSheet(Sheetname).getRow(row).getCell(column).getStringCellValue();
	}
	
public double getNumericData(String Sheetname, int row, int column) {
		
		return wb.getSheet(Sheetname).getRow(row).getCell(column).getNumericCellValue();
	}

}
