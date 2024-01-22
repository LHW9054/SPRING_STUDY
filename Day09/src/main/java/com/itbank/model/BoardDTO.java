package com.itbank.model;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

//NOT NULL NUMBER         
//TITLE       NOT NULL VARCHAR2(100)  
//MEMBER2_IDX NOT NULL NUMBER         
//CONTENT     NOT NULL VARCHAR2(4000) 
//FILENAME             VARCHAR2(255)  
//WDATE       NOT NULL DATE           
//VIEWCOUNT            NUMBER 

public class BoardDTO {
	
	private int idx;
	private String title;
	private int member2_idx;
	private String content;
	private String fileName;
	private Date wdate;
	private int viewCount;
	
	private MultipartFile upload;		// 첨부파일
	
	private String member2_userid;		// 조인
	private String member2_username;	// 조인
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getMember2_idx() {
		return member2_idx;
	}
	public void setMember2_idx(int member2_idx) {
		this.member2_idx = member2_idx;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}
	public String getMember2_userid() {
		return member2_userid;
	}
	public void setMember2_userid(String member2_userid) {
		this.member2_userid = member2_userid;
	}
	public String getMember2_username() {
		return member2_username;
	}
	public void setMember2_username(String member2_username) {
		this.member2_username = member2_username;
	}
	
	

}
