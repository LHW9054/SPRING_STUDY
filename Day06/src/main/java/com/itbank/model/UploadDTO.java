package com.itbank.model;

import org.springframework.web.multipart.MultipartFile;

public class UploadDTO {
	
	private int idx;
	private String title;
	private String originalFileName;	// 파일의 원본 이름
	private String storedFileName;		// DB에 저장된 이름
	private MultipartFile upload;		// 제출 파일을 받기 위한 필드
	
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
	public String getOriginalFileName() {
		return originalFileName;
	}
	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}
	public String getStoredFileName() {
		return storedFileName;
	}
	public void setStoredFileName(String storedFileName) {
		this.storedFileName = storedFileName;
	}
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}
}
