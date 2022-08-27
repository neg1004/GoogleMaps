package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
@SpringBootApplication

public class DemoApplication {

	
	public static void main(String[] args) throws IOException {
		SpringApplication.run(DemoApplication.class, args);
		
		String filePath = "C:/Users/Luke Laptop/Downloads/PickupPointInfo.xlsx";
		FileInputStream file = new FileInputStream(new File(filePath));
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		Iterator iterator = sheet.iterator();
		
		while(iterator.hasNext())
		{
			XSSFRow row=(XSSFRow) iterator.next();
			
			Iterator cellIterator = row.cellIterator();
			
			while (cellIterator.hasNext())
			{
				XSSFCell cell = (XSSFCell) cellIterator.next();
				
				switch(cell.getCellType())
				{
				case STRING: System.out.print(cell.getStringCellValue()); break;
				case NUMERIC: System.out.print(cell.getNumericCellValue()); break;
				case BOOLEAN: System.out.print(cell.getBooleanCellValue()); break;
				}
				System.out.print(" ");
			}
			
			System.out.println();
		}
	}
}
