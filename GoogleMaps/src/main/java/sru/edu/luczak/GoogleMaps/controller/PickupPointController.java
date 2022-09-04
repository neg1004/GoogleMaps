package sru.edu.luczak.GoogleMaps.controller;

import java.io.*;
import java.sql.*;
import java.util.*;
 
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

//import java.util.Date;     //Use if date is needed

public class PickupPointController {
	
	public static void main(String[] args) throws SQLException, IOException {
		
		//Connect to the database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pickuppoints?useSSL=false&serverTimezone=UTC", "root", "root");
		Statement stmt = con.createStatement();
		
		//Create a new table in the database
		String sql = "create table pickupPoint (Id varchar(6), Student_Count int, Road_Name varchar(50), Longitude decimal(4,0), Latitude decimal(4, 0))";
        stmt.execute(sql);
        
        //Excel
        String excelFilePath = ".\\Users\\Luke Laptop\\OneDrive\\Desktop\\School_Stuff\\SRU_FinalYear\\CPSC-488\\Project\\PickupPointInfo.xlsx";
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        XSSFWorkbook workbook=new XSSFWorkbook(excelFilePath);
        XSSFSheet sheet = workbook.getSheet("Pickup Points");
        
        int rows=sheet.getLastRowNum();
        
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
		
/*      //https://www.codejava.net/coding/java-code-example-to-import-data-from-excel-to-database
 *      String jdbcURL = "jdbc:mysql://localhost:3306/pickuppoints?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "root";
 
        String excelFilePath = "C:\\Users\\Luke Laptop\\OneDrive\\Desktop\\School_Stuff\\SRU_FinalYear\\CPSC-488\\Project\\PickupPointInfo.xlsx";
 
        int batchSize = 20;
 
        Connection connection = null;
 
        try {
            long start = System.currentTimeMillis();
             
            FileInputStream inputStream = new FileInputStream(excelFilePath);
 
            Workbook workbook = new XSSFWorkbook(inputStream);
 
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = firstSheet.iterator();
 
            connection = DriverManager.getConnection(jdbcURL, username, password);
            connection.setAutoCommit(false);
  
            String sql = "INSERT INTO pickuppoint (id, studentCount, pickupPointName, roadName,  longitude, latitude) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);    
             
            int count = 0;
             
            rowIterator.next(); // skip the header rows
             
            while (rowIterator.hasNext()) {
                Row nextRow = rowIterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();
 
                while (cellIterator.hasNext()) {
                    Cell nextCell = cellIterator.next();
 
                    int columnIndex = nextCell.getColumnIndex();
 
                    switch (columnIndex) {
                    case 0:
                        String id = nextCell.getStringCellValue();
                        statement.setString(1, id);
                        break;
                    case 1:
                        int studentCount = (int) nextCell.getNumericCellValue();
                        statement.setInt(2, studentCount);
                    case 2:
                        String pickupPointName = nextCell.getStringCellValue();
                        statement.setString(3, pickupPointName);
                    case 3:
                    	String roadName = nextCell.getStringCellValue();
                    	statement.setString(4, roadName);
                    case 4:
                    	float longitude = (float) nextCell.getNumericCellValue();
                    	statement.setFloat(5, longitude);
                    case 5:
                    	float latitude = (float) nextCell.getNumericCellValue();
                    	statement.setFloat(6, latitude);
                    }
 
                }
                 
                statement.addBatch();
                 
                if (count % batchSize == 0) {
                    statement.executeBatch();
                }              
 
            }
 
            workbook.close();
             
            // execute the remaining queries
            statement.executeBatch();
  
            connection.commit();
            connection.close();
             
            long end = System.currentTimeMillis();
            System.out.printf("Import done in %d ms\n", (end - start));
             
        } catch (IOException ex1) {
            System.out.println("Error reading file");
            ex1.printStackTrace();
        } catch (SQLException ex2) {
            System.out.println("Database error");
            ex2.printStackTrace();
        }
 */
    } 
}

