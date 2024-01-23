package com.itbank.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Ex03Controller {
	
	@GetMapping("/login")
	public void login() {}
	
	@PostMapping("/login")
	public String login(@RequestParam HashMap<String, String> param, HttpSession session) {
		System.out.println("userid : " + param.get("userid"));
		System.out.println("userpw : " + param.get("userpw"));
		session.setAttribute("login", param);
		return "redirect:/";
	}
	
	
	
	@GetMapping("/board")
	public void board() {}
	
	@GetMapping("/sitemap")
	public void sitemap() {}
	
	@GetMapping("/mypage")
	public void mypage() {
		System.out.println("==> mypage <==");
	}

}
