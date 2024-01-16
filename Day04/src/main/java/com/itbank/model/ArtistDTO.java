package com.itbank.model;

//ID         NOT NULL NUMBER        
//NAME       NOT NULL VARCHAR2(200) 
//COMPANY             VARCHAR2(200) 
//COUNTRY             VARCHAR2(100) 
//MEMBER     NOT NULL VARCHAR2(200) 
//DEBUT               DATE          
//TYPE       NOT NULL VARCHAR2(100) 
//PROFILEIMG          VARCHAR2(500)

import java.util.Date;

public class ArtistDTO {
	
	private int id;
	private String name;
	private Date debut;
	private String type;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDebut() {
		return debut;
	}
	public void setDebut(Date debut) {
		this.debut = debut;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
