package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.BoardDTO;
import com.itbank.repository.BoardDAO;


@Controller
public class BoardController {
	
	@Autowired private BoardDAO dao;
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		List<BoardDTO> list = dao.selectList();
		mav.addObject("list", list);
		return mav;
	}
	
	@GetMapping("/write")
	public void write()	{}
	@PostMapping("/write")
	public String write(BoardDTO dto) {
		int row = dao.insert(dto);
		System.out.println(row + "행 추가되었습니다");
		return "redirect:/list";
	}
	
	@GetMapping("/view/{idx}")
	public ModelAndView view(@PathVariable("idx")int idx) {
		ModelAndView mav = new ModelAndView("view");
		BoardDTO dto = dao.oneselectList(idx);
		mav.addObject("dto", dto);
		return mav;
 	}
	
	@GetMapping("/modify/{idx}")
	public ModelAndView modify(@PathVariable("idx")int idx) {
		ModelAndView mav = new ModelAndView("modify");
		BoardDTO dto = dao.oneselectList(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	@PostMapping("/modify/{idx}")
	public String modify(BoardDTO dto) {
		int row = dao.modify(dto);
		System.out.println(row + "행이 수정 되었습니다");
		return "redirect:/list";
	}
	
	@GetMapping("/delete/{idx}")
	public String delete(@PathVariable("idx")int idx) {
		int row = dao.delete(idx);
		System.out.println(row + "행이 삭제 되었습니다");
		return "redirect:/list";
	}
	
	
	
	
}
