package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider{
	
	XSSFWorkbook wb;
	
	public ExcelDataProvider() {
		File src=new File("./TestData/data.xlsx");
		try {
			FileInputStream fis=new FileInputStream(src);
		wb	=new XSSFWorkbook(fis);
		}
		 catch (Exception e) {
			
			System.out.println("unable to get excel" +e.getMessage());
		}
}
	
	
public String getStringData(int sheetIndex,int row,int column) {
	String data=wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	return data;
}
public String getStringData(String sheetName,int row,int column) {
	String data=wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	return data;
}

public double getNumericData(String sheetname,int row,int column) {
	return wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();

	
}

}












