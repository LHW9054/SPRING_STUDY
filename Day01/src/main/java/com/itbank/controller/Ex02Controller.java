package com.itbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.Ex02DTO;

@Controller
public class Ex02Controller {
	
	@GetMapping("/ex02")	// "ex02" 주소로 GET 형태의 요청이 들어오면
	public void ex02() {}	// 별도의 코드를 실행하지 않고, 바로 ex02.jsp를 실행한다
	
	@PostMapping("/ex02")
	public ModelAndView ex02(Ex02DTO dto) {
		// 데이터를 jsp에게 넘기기 위한 Model
		// 어떤 jsp로 포워딩 할지 대상을 지정하는 View
		// 두개의 요소를 합쳐서 반환하기 위한 클래스 ModelAndView
		
		// String viewName을 전달하기 위한 방법
		// 1) 생성자 매개변수로 전달
		// 2) setViewName(viewName) 메서드를 호출하여 전달
		ModelAndView mav = new ModelAndView("ex02-action");	// 조건에 상관없이 항상 같으면 미리 지정합니다
		mav.setViewName("ex02-action");	// 조건에 따라서 중간에 바뀌면 setViewName으로 처리
		
		String adult = dto.getAge() >= 20 ? "성인" : "미성년자";
		
		// request.setAttribute("adult", adult);
		// model.addAttribute("adult", adult);
		mav.addObject("adult", adult);
		mav.addObject("dto", dto);
		
		return mav;
	}
}
