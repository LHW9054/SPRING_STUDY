package com.itbankt.model;

import org.springframework.web.multipart.MultipartFile;

public class Ex03DTO {
	private int idx;
	private String title;			// 입력된 파라이터를 그대로 DB에 저장

	private String fileName;		// 업로드 이후 만들어진 파일의 이름을 DB에 [저장]
	private MultipartFile upload;	// [입력]받은 파일을 받기 위한 필드
	
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
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}
	
	
}
