package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.component.FileComponent;
import com.itbank.repository.UploadDAO;
import com.itbankt.model.Ex03DTO;

@Controller
public class Ex03Controller {
	
	@Autowired private FileComponent fileComponent;
	@Autowired private UploadDAO uploadDAO; 
	
	@GetMapping("/ex03")
	public ModelAndView ex03() {
		ModelAndView mav = new ModelAndView();
		List<Ex03DTO> list = uploadDAO.selectAll();
		mav.addObject("list", list);
		return mav;
	}
	
	@PostMapping("/ex03")
	public String ex03(Ex03DTO dto) {
		String fileName = fileComponent.upload(dto.getUpload());
		dto.setFileName(fileName);
		int row = uploadDAO.insert(dto);
		System.out.println(row + "행이 추가되었습니다");
		System.out.println(dto.getTitle());
		return "redirect:/ex03";
	}
	
	
	

}
