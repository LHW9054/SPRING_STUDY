package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.itbank.component.HashComponent;
import com.itbank.model.MemberDTO;
import com.itbank.repository.MemberDAO;

@Controller
public class Ex01Controller {
	
	@Autowired private HashComponent hashComponent;
	@Autowired private MemberDAO memberDAO;
	
	@GetMapping("/ex01")
	public void ex01() {}
	
	@PostMapping("/ex01")
	public String ex01(MemberDTO dto) {
		// 1) 사용자가 입력한 비밀번호를 hash처리하고, 사용된 salt도 dto에 저장해야 한다
		String salt = hashComponent.getRandomSalt();
		String hash = hashComponent.getHash(dto.getUserpw(), salt);
		dto.setSalt(salt);
		dto.setUserpw(hash);
		
		// 2) 처리가 끝난 dto를 dao에게 넘겨서 insert를 수행한다
		int row = 0;
		row = memberDAO.insert(dto);
		System.out.println(row + "행이 추가 되었습니다");
		
		return "redirect:/";
	}

}
