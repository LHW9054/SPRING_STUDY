package com.itbank.model;

//IDX      NOT NULL NUMBER        
//USERID   NOT NULL VARCHAR2(100) 
//USERPW   NOT NULL VARCHAR2(300) 
//SALT     NOT NULL VARCHAR2(100) 
//USERNAME NOT NULL VARCHAR2(100) 
//EMAIL    NOT NULL VARCHAR2(100)

public class MemberDTO {
	
	private int idx;
	private String userid;
	private String userpw;
	private String salt;
	private String username;
	private String email;
	
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
