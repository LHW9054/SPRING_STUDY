package com.itbank.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.itbank.component.HashComponent;
import com.itbank.model.MemberDTO;
import com.itbank.repository.MemberDAO;

@Controller
public class Ex02Controller {
	
	@Autowired private MemberDAO memberDAO;
	@Autowired private HashComponent hashComponent;
	
	@GetMapping("/ex02")
	public void ex02() {}
	
	@PostMapping("/ex02")
	public String ex02(MemberDTO param, HttpSession session) {
		
		// 1) DB에서 지정한 id로 MemberDTO login를 불러온다
		MemberDTO login = memberDAO.selectOneByUserid(param.getUserid());
		if(login == null) {
			session.invalidate();
			return "redirect:/ex02";
		}
		// 2) hashComponent를 이용하여 사용자 입력 패스워드를 해시로 변경한다
		String hash = hashComponent.getHash(param.getUserpw(), login.getSalt());
		
		// 3) hash값이 일치하면 session에 login을 추가한다 (일치하지 않으면 추가하지 않는다)
		if(hash.equals(login.getUserpw()) == false) {
			session.invalidate();
			return "redirect:/ex02";
		}
		
		
		return "redirect:/";
	}
	
	
}
