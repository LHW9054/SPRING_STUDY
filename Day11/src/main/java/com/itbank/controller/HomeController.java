package com.itbank.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping(value="/ajax01", produces = "plain/text;charset=utf-8")
	@ResponseBody
	public String ajax01() {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("a hh시 mm분 ss초");
		String data = sdf.format(now);
		return data;
	}
	
	

}
