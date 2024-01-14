package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itbank.repository.TestDAO;

@Controller		// 요청을 전달받아서 응답을 만들어낼 수 있는 컨트롤러 클래스
				// component-scan에 의해서 스피링 빈으로 등록되는 클래스
public class HomeController{
	
	// jsp model-2와 달리, 상속을 사용하지 않기 때문에 함수 작성 자유도가 높다
	// 주소와 함수를 한번에 등록하기 때문에 하나의 컨트롤러에서 여러 함수를 작성할수 있다
	
	// 컨트롤러가 작동하는데 필요한 다른객체가 있으면 자동으로 연결할수 있다 (스프링 빈 등록 되어야함)
	@Autowired
	private TestDAO testDAO;
	
	@RequestMapping("/")	// 주소등록, 메서드 구분없음
	public String home(Model model) {	// request를 꼭 받아야할 필요가 없다
		String version = testDAO.getVersion();
		
//		request.setAttribute("version", version);
		model.addAttribute("version", version);
		return "home";		// 반환하는 문자열은 prefix + viewName + suffix 형식으로 포워딩 된다
	}
	
}