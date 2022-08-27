package com.example.demo.mysql;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.lang.NonNull;

import com.example.demo.DemoApplication;

@Entity // This tells Hibernate to make a table out of this class
public class user {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private long id;

  private String roadName;

  private String pickuppointName;
  
  private int studentCount;
  
  private long longitude;
  
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
    return pickuppointName;
  }

  public void setPickupPointName(String pickuppointName) {
    this.pickuppointName = pickuppointName;
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
		//apache POI (Spreadhsheets)
		//Contoller (look into)
		


