package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.itbank.component.MailComponent;
import com.itbank.model.Ex02DTO;

@Controller
public class Ex02Controller {
	
	@Autowired private MailComponent mailComponent;
	
	@GetMapping("/ex02")
	public void ex02() {}
	
	@PostMapping("/ex02")
	public String ex02(Ex02DTO dto) {
		System.out.println(dto);
		int row = mailComponent.sendMimeMessage(dto);
		System.out.println(row == 1? "전송성공" : "전송실패");
		return "redirect:/";
	}
	
	
	
}
