package sru.edu.luczak.GoogleMaps.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.lang.NonNull;
import javax.persistence.Entity;

@Entity
public class PickupPoint {
//From what I understand the domain is where the table in MySQL is created and the columns are named
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NonNull
	private String roadName;
	@NonNull
	private String pickupPointName;
	@NonNull
	private int studentCount;
	@NonNull
	private long longitude;
	@NonNull
	private long latitude;

	  public long getId() {
	    return id;
	  }

	  public void setId(long id) {
	    this.id = id;
	  }

	  public String getRoadName() {
	    return roadName;
	  }

	  public void setRoadName(String roadName) {
	    this.roadName = roadName;
	  }

	  public String getPickupPointName() {
	    return pickupPointName;
	  }

	  public void setPickupPointName(String pickuppointName) {
	    this.pickupPointName = pickuppointName;
	  }
	  
	  public long getStudentCount() {
		return studentCount;
	  }

	  public void setStudentCount(int studentCount) {
		this.studentCount = studentCount;
	  }
	  
	  public long getLongitude() {
		return longitude;
	  }

	  public void setLongitude(long longitude) {
		 this.longitude = longitude;
	  }
	  
	  public long getLatitude() {
		 return latitude;
	  }

	  public void setLatitude(long latitude) {
		 this.latitude = latitude;
	  }
	}

			//JPA (Java - based database)
			//Hibernate (Works with JPA)
			//JDBC (????)
			//MySQL (Works with ^)
			//javax libraries - Done
			//apache POI (Spreadsheets)
			//Controller (look into)
