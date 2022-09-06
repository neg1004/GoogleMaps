package sru.edu.luczak.GoogleMaps;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sru.edu.luczak.GoogleMaps.controller.PickupPointController;

@SpringBootApplication
public class GoogleMapsApplication {

	public static void main(String[] args) throws SQLException, IOException {
		SpringApplication.run(GoogleMapsApplication.class, args);
		PickupPointController excel = new PickupPointController();
		excel.main(args);
		
	}
}