package com.example.demo.mysql;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.demo.DemoApplication;

@Entity // This tells Hibernate to make a table out of this class
public class database {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  private String name;

  private String email;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}

		//JPA (Java - based database)
		//Hibernate (Works with JPA)
		//JDBC (????)
		//MySQL (Works with ^)
		//javax libraries - Done
		//apache POI (Spreadhsheets)
		//Contoller (look into)
		


