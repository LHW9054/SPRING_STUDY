package com.itbank.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.itbank.component.FileComponent;
import com.itbank.model.Ex03DTO;
import com.itbank.model.UploadDTO;
import com.itbank.repository.UploadDAO;

@Controller
public class Ex03 {
	
	@Autowired private UploadDAO uploadDAO;
	@Autowired private FileComponent fileComponent;
	
	@GetMapping("/ex03")
	public void ex03() {}
	
	@PostMapping("/ex03")
	public String ex03(Ex03DTO dto) {
		System.out.println("title : " + dto.getTitle());
		dto.getUpload().forEach(f -> System.out.println(f.getOriginalFilename()));
		System.out.println();
		int row = 0;
		for(MultipartFile f : dto.getUpload()) {
			String storedFileName = fileComponent.upload(f);
			UploadDTO ob = new UploadDTO();
			ob.setTitle(dto.getTitle());
			ob.setOriginalFileName(f.getOriginalFilename());
			ob.setStoredFileName(storedFileName);
			System.out.println(storedFileName);
			row += uploadDAO.insert(ob);
		}
		System.out.println(row + "행이 추가되었습니다");
		return "redirect:/ex03";
	}
	
	
	
	
}
