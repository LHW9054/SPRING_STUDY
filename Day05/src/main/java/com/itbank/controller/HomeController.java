package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.repository.TestDAO;

@Controller
public class HomeController {
		
	@Autowired private TestDAO testDAO;
	
	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home");
		String version = testDAO.getVersion();
		mav.addObject("version", version);
		return mav;
	}
	
	
	
}
