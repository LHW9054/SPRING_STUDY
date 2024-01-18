package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.component.FileComponent;
import com.itbank.model.UploadDTO;
import com.itbank.repository.UploadDAO;

@Controller
public class Ex02Controller {
	
	@Autowired private UploadDAO uploadDAO;
	@Autowired private FileComponent fileComponent;
	
	@GetMapping("/ex02")
	public ModelAndView ex02() {
		ModelAndView mav = new ModelAndView();
		List<UploadDTO> list = uploadDAO.selectList();
		mav.addObject("list", list);
		return mav;
	}
	
	@GetMapping("ex02/delete/{idx}")
	public String delete(@PathVariable("idx") int idx) {
		// 1) idx로 저장된 파일이름을 불러와야 한다
		UploadDTO dto = uploadDAO.selectOne(idx);
		
		// 2) dao에서 delete쿼리를 수행하여 데이터를 삭제한다
		int row = uploadDAO.delete(idx);
		
		// 3) DB에서 삭제되었다면, 저장된 파일이름을 전달해서, 파일 컴포넌트에서 대상 파일을삭제한다
		if(row != 0) {
			fileComponent.delete(dto.getStoredFileName());
		}
		return "redirect:/ex02";
	}
	
	
	
	
}
