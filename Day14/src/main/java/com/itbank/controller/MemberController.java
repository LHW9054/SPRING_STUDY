package com.itbank.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.MemberDTO;
import com.itbank.service.MemberService;

@RequestMapping("/member")
@Controller
public class MemberController {
	
	@Autowired private MemberService memberService;
	
	@GetMapping("/join")
	public void join() {}
	
	@PostMapping("/login")
	public ModelAndView login(MemberDTO dto, HttpSession session) {
		ModelAndView mav = new ModelAndView("redirect:/");
		MemberDTO login = memberService.login(dto);
		session.setAttribute("login", login);
		return mav;
	}
	
	@PostMapping("/join")
	public String join(MemberDTO dto) {
		int row = memberService.join(dto);
		System.out.println(row != 0 ? "추가성공" : "추가실패");
		return "redirect:/";
	}

	
	
	
	
	
	

}
