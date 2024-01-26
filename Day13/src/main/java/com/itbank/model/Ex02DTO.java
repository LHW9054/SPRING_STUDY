package com.itbank.model;

public class Ex02DTO {
	
	private String receiver;
	private String subject;
	private String content;
	
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		String str = "";
		str += "받는사람 : %s\n";
		str += "제목 : %s\n";
		str += "내용 : %s\n";
		return String.format(str, receiver, subject, content);
	}
	
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	

}
