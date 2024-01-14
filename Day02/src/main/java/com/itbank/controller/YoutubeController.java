package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.YoutubeDTO;

import com.itbank.repository.*;

@Controller
public class YoutubeController {
	
	// 컨트롤러의 함수 반환형을 결정하기
	
	// 1)DB에서 불러온 데이터 혹은 다른 데이터를 JSP에게 넘겨줘야 하는가?
	// yes -> ModelAndView
	
	// 2) 요청 주소와 JSP의 이름이 일치하는가?
	// yes -> void, no -> String
	
	@Autowired private YoutubeDAO dao;
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		List<YoutubeDTO> list = dao.selectList();
		mav.addObject("list", list);
		return mav;
	}
	
	@GetMapping("/add")
	public void add() {}
	
	@PostMapping("/add")
	public String add(YoutubeDTO dto) {
		
		/* dto.movieTag 의 문자열을 수정하는 코드 (service로 이동가능) */
		String movieTag = dto.getMovietag();
		System.out.println(movieTag);
		
		String[] arr = movieTag.split(" ");
		for(int i = 0; i<arr.length; i++) {
			if(arr[i].startsWith("width=")) {
				arr[i] = "width=\"720\"";
			}
			if(arr[i].startsWith("height=")) {
				arr[i] = "height=\"405\"";
			}
		}
		
/////////////////////////////////////////////////////////////
//		String[] arr = movieTag.split(" ");
//		
//		String stra = "width=";
//		String strb = "height=";
//		
//		String str1 = "width=705";
//		String str2 = "height=405";
//		
//		for(int i = 0; i<=arr.length; i++) {
//			if(arr[i].equals(stra) ) {
//				arr[i] = str1;
//			}
//			if(arr[i].equals(strb) ) {
//				arr[i] = str2;
//			}
//		}
/////////////////////////////////////////////////////////////
		
		String newTag = String.join(" ", arr);
		dto.setMovietag(newTag);
		
		/****************************************************/
		
		int row = dao.insert(dto);
		System.out.println(row + "행이 추가되었습니다");
		return "redirect:/list";
	}
	
	@GetMapping("/view/{idx}")
	public ModelAndView view(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("view");
		
		int row = dao.increseViewCount(idx);
		System.out.println(row + "행이 수정되었습니다");
		
		YoutubeDTO dto = dao.selectOne(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@GetMapping("/delete/{idx}")		// <a href="">, location.href 모두 GET메서드 이다
	public String delete(@PathVariable("idx") int idx) {
		int row = dao.delete(idx);
		System.out.println(row + "행이 삭제되었습니다");
		return "redirect:/list";
	}
	

	
	
}
