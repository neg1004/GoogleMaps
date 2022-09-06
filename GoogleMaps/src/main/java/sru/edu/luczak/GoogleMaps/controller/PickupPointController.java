package sru.edu.luczak.GoogleMaps.controller;

import java.io.*;
import java.sql.*;
import java.util.*;
 
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.boot.SpringApplication;


//import java.util.Date;     //Use if date is needed

public class PickupPointController {
	
	public static void main(String[] args) throws SQLException, IOException {
		
		//Connect to the Database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pickuppoints?useSSL=false&serverTimezone=UTC", "root", "root");
		Statement stmt = con.createStatement();
		
		//Create a new table in the database
		String sql = "create table pickupPoint (Id varchar(6), Student_Count int, Pickup_Point varchar(50), Road_Name varchar(50), Longitude decimal(20,0), Latitude decimal(20, 0))";
		
		DatabaseMetaData dbm = con.getMetaData();
		// check if "pickupPoint" table is in the database
		ResultSet tables = dbm.getTables(null, null, "pickupPoint", null);
		
		if(tables.next() == false)
		{
			//If table does not exist in the database create it.
			stmt.execute(sql);
		} else {
			//Otherwise just print out that it already exists
			//eventually this will also update the database instead of importing copies
			System.out.println("Table already exists");
		}
	    
	    
	    //Excel
	    String excelFilePath = "C:\\Users\\Luke Laptop\\OneDrive\\Desktop\\School_Stuff\\SRU_FinalYear\\CPSC-488\\Project\\PickupPointInfo.xlsx";
	    FileInputStream inputStream = new FileInputStream(excelFilePath);
	    XSSFWorkbook workbook=new XSSFWorkbook(excelFilePath);
	    XSSFSheet sheet = workbook.getSheet("Sheet1");
	    
	    int rows=sheet.getLastRowNum();
	    
	    //Add data from the excel sheet into the database
	    for(int r=1; r<=rows;r++)
	    {
	    	XSSFRow row=sheet.getRow(r);
	    	String id = row.getCell(0).getStringCellValue();
	    	int studentCount = (int) row.getCell(1).getNumericCellValue();
	    	String pickupPointName = row.getCell(2).getStringCellValue();
	    	String roadName = row.getCell(3).getStringCellValue();
	    	float longitude = (float) row.getCell(4).getNumericCellValue();
	    	float latitude = (float) row.getCell(5).getNumericCellValue();
	    	
	    	sql="INSERT INTO pickuppoint values('"+id+"', '"+studentCount+"', '"+pickupPointName+"', '"+roadName+"', '"+longitude+"', '"+latitude+"')";
	    	stmt.execute(sql);
	    	stmt.execute("commit");
	    }
	    
	    workbook.close();
	    inputStream.close();
	    con.close();
	    
	    System.out.println("Done");	
    } 
}

