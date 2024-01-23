package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.service.Ex02Service;

@Controller
public class Ex02Controller {
	
	private int[] arr = {4, 8, 2, 7, 6};

	@Autowired private Ex02Service ex02Service;
	
	@GetMapping("/ex02")
	public ModelAndView ex02() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("num1", arr[0]);
		mav.addObject("num2", arr[2]);
		mav.addObject("num3", arr[5]);	// ArrayIndexOutOfBoundsException
		return mav;
	}
	
	
	
	

}
