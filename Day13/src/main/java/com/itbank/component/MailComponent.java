package com.itbank.component;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.itbank.model.Ex02DTO;
import com.itbank.model.ex01DTO;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Component
public class MailComponent {
	
	private final String host = "smtp.naver.com";
	private final int port = 465;
	private String serverID = "lho90554";	// 메일 계정 아이디
	private String serverPW = "pcg5sc772n";	// 메일 계정 비밀번호
	
	private Properties props;
	
	// classpath 에서 특정 파일 불러오기
	// src/main/java
	// src/main/resources
	@Value("classpath:mailForm.html")
	private Resource mailForm;
	
	private String tag = "";
	
	public MailComponent() throws FileNotFoundException, IOException{
		// 파일 내용 불러와서 태그에 넣어두기
		props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.trust", host);
	}
	
	public int senSimpleMail(ex01DTO dto) {
		
		int row = 0;
		
		Session mailSession = Session.getDefaultInstance(props, new Authenticator() {
			String un = serverID;
			String pw = serverPW;
			
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(un, pw);
			}
		});
		
		mailSession.setDebug(true);	// 메일 발송시 진행 상황을 콘솔창에 출력하도록 설정한다
		
		Message message = new MimeMessage(mailSession);
		try {
			message.setFrom(new InternetAddress(serverID + "@naver.com"));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(dto.getReceiver()));
			message.setSubject("텍스트 메일 제목입니다");
			message.setText(dto.getBody()); // 단순 텍스트를 보낼때는 setText()
			Transport.send(message);
			return 1;
			
		} catch (MessagingException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int sendMimeMessage(Ex02DTO dto) {
		Session mailSession = Session.getDefaultInstance(props, new Authenticator() {
			String un = serverID;
			String pw = serverPW;
			
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(un, pw);
			}
		});
		
		mailSession.setDebug(true);
		
		Message message = new MimeMessage(mailSession);
		
		try {
			Scanner sc = new Scanner(mailForm.getFile());
			while(sc.hasNextLine()) {
				tag += sc.nextLine();
			}
			sc.close();
			
			message.setFrom(new InternetAddress(serverID + "@naver.com"));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(dto.getReceiver()));
			message.setSubject(dto.getSubject());
			message.setContent(
					String.format(tag, dto.getContent()),
					"text/html; charset=utf-8");
			Transport.send(message);
			
		} catch (MessagingException | IOException e) {
			e.printStackTrace();
			return 0;
		}
		return 0;
	}
	

}
