package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.ArtistDTO;
import com.itbank.repository.ArtistDAO;

@Controller
public class Ex01Controller {
	
	@Autowired private ArtistDAO artistDAO;
	
	@GetMapping("/ex01")		// 주소(요청주소, 브라우저에 찍히는 글자)
	public ModelAndView list() {
									//viewName(서버 내부의 jsp이름및 경로)
		ModelAndView mav = new ModelAndView("/ex01/list");
		List<ArtistDTO> list = artistDAO.selectAll();
		mav.addObject("list", list);
		return mav;
	}
	
	@GetMapping("/ex01/view")			// 쿼리 스티링 파라미터는 @RequestParam을 사용한다
	public ModelAndView view(int id) {	// @대부분 @RequestParam은 생략 가능하다
		ModelAndView mav = new ModelAndView("ex01/view");
		ArtistDTO dto = artistDAO.selectOne(id);
		mav.addObject("dto", dto);
		return mav;
	}
}
