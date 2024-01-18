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
public class Ex04Controller {
	
	@Autowired private UploadDAO uploadDAO;
	@Autowired private FileComponent filecomponent;
	
	@GetMapping("/ex04")
	public void ex04() {}

	@PostMapping("/ex04")
	public String ex04(Ex03DTO dto) {
		for(MultipartFile f : dto.getUpload()) {
			System.out.println(f.getName() + " : " + f.getOriginalFilename());
			String storedFileName = filecomponent.upload(f);
			UploadDTO ob = new UploadDTO();
			ob.setTitle(dto.getTitle());
			ob.setOriginalFileName(f.getOriginalFilename());
			ob.setStoredFileName(storedFileName);
			uploadDAO.insert(ob);
		}
		return "redirect:/";
	}

}
