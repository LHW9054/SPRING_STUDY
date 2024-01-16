package com.itbank.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.repository.TestDAO;

@Controller
public class HomeController {
	// 포워딩으로 이동할 목적지(jsp) 설정
	@Autowired private TestDAO testDAO;
	
	// 목적지에 보낼 화물 (data) 가져오기
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home");
		String version = testDAO.getVersion();
		Date sysdate = testDAO.getSysdate();
		List<String> tableList = testDAO.getTableInfo();
		
		// 목적지로 이동하는 트럭(mav)에 데이터 적재하기
		mav.addObject("version", version);
		mav.addObject("sysdate", sysdate);
		mav.addObject("tableList", tableList);
		
		//출발
		return mav;
	}

}
