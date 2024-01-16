package com.itbank.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.MemberDTO;
import com.itbank.repository.MemberDAO;

@Controller
@RequestMapping("/ex03")
public class Ex03Controller {
	
	@Autowired private MemberDAO memberDAO;
	
	@GetMapping
	public String ex03() {
		return "/ex03/login";
	}
	
	@PostMapping("/post1")
	public ModelAndView post1(String userid, String userpw) {
		ModelAndView mav = new ModelAndView("ex03/result");
		
//		<매개변수가 2개라서 실행 안됨>
//		MemberDTO login = memberDAO.login1(userid, userpw);
//		마이바티스 함수를 호출할 때는 매개변수를 2개이상 전달하지 않는다
		HashMap<String, String>map = new HashMap<>();
		map.put("userid", userid);
		map.put("userpw", userpw);
		MemberDTO login = memberDAO.login2(map);
		mav.addObject("login", login);
		return mav;
	}
	
	@PostMapping("/post2")
	public ModelAndView post2(@RequestParam HashMap<String, String> map) {
		ModelAndView mav = new ModelAndView("ex03/result");
		MemberDTO login = memberDAO.login2(map);
		mav.addObject("login", login);
		return mav;
	}
	
	@PostMapping("/post3")
	public ModelAndView post3(MemberDTO dto) {
		ModelAndView mav = new ModelAndView("ex03/result");
		MemberDTO login = memberDAO.login3(dto);
		mav.addObject("login", login);
		return mav;
	}

}
