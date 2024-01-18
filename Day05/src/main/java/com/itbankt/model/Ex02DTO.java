package com.itbankt.model;

import org.springframework.web.multipart.MultipartFile;

public class Ex02DTO {
	
	private String title;
	private MultipartFile upload;	// 사용자 업로드 파일을 저장하기 위한 필드
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}
}
