package com.itbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		return "home";
		// 요청주소 "/" 와 viewName "home" 이 서로 다르기 때문에 명시하여 반환한다
	}

}
