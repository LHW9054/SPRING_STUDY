package com.itbank.controller;

import java.util.HashMap;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itbank.component.MailComponent;

@RestController
@RequestMapping("/ajax")
public class AjaxController {
	
	@Autowired private MailComponent mailComponent;
	private Random ran = new Random();
	
	// 1) 이메일로 임의의 인증번호를 보낸다. 보내진 인증번호는 임시로 세션에 저장한다
	@GetMapping("/checkAuthNumber/{userNumber}")
	public String checkAuthNumber(@PathVariable("userNumber") String userNumber,
									HttpSession session) {
		// 2) 사용가자 확인용으로 입력한 인증번호와 세션에 저장된 인증번호를 비교하여 일치여부를 반환한다
		String sessionNumber = (String) session.getAttribute("authNumber");
		String result = userNumber.equals(sessionNumber) ? "1" : "0";
		return result;
	}
	
	@GetMapping("/sendAuthNumber")
	public String sendAuthNumber(String email, HttpSession session) {
		String authNumber = (ran.nextInt(8999999) + 1000000) + "";
		HashMap<String, String> param = new HashMap<>();
		param.put("receiver", email);
		param.put("subject", "[KGITBANK] 인증번호 입니다");
		param.put("content", authNumber);
		
		int row = mailComponent.sendMimeMessage(param);
		
		String msg = "인증번호가 발송되었습니다";
		if(row != 1) {
			msg = "인증번호 발송에 실패 했습니다";
		}else {
			msg = "인증번호가 발송 되었습니다";
			session.setAttribute("authNumber", authNumber);
			session.setMaxInactiveInterval(180);
		}
		return msg;
	}
	
	

}
