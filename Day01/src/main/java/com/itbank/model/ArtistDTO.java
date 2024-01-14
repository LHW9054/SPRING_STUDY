package com.itbank.model;
//ID         NOT NULL NUMBER        
//NAME       NOT NULL VARCHAR2(200) 
//COMPANY             VARCHAR2(200) 
//COUNTRY             VARCHAR2(100) 
//MEMBER     NOT NULL VARCHAR2(200) 
//DEBUT               DATE          
//TYPE       NOT NULL VARCHAR2(100) 
//PROFILEIMG          VARCHAR2(500) 

import java.sql.Date;

public class ArtistDTO {
	
	private int id;
	private String name;
	private String company;
	private String country;
	private String member;
	private Date date;
	private String type;
	private String profileImg;
	
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
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getMember() {
		return member;
	}
	public void setMember(String member) {
		this.member = member;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getProfileImg() {
		return profileImg;
	}
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}
	

}
