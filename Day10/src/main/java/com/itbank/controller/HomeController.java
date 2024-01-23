package com.itbank.controller;

import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home");
		
		String javaVersion = System.getenv("JAVA_HOME");
		String springVersion = SpringVersion.getVersion();
		
		mav.addObject("javaVersion", javaVersion);
		mav.addObject("springVersion", springVersion);
		return mav;
	}

}
