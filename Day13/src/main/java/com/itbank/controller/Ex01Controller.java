package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.itbank.component.MailComponent;
import com.itbank.model.ex01DTO;

@Controller
public class Ex01Controller {
	
	@Autowired private MailComponent mailComponent;
	
	@GetMapping("/ex01")
	public void ex01() {}
	
	@PostMapping("/ex01")
	public String ex01(ex01DTO dto) {
		System.out.println(dto.getReceiver());
		System.out.println(dto.getBody());
		System.out.println();
		
		int row = mailComponent.senSimpleMail(dto);
		System.out.println(row == 1 ? "전송선공" : "전송실패");
		
		return "redirect:/";
	}

}
