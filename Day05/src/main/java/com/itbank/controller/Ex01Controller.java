package com.itbank.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

@Controller
public class Ex01Controller {

	
	
	@GetMapping("/ex01")
	public void ex01(){}
	
	@PostMapping("/ex01")
	public String ex01(MultipartRequest request) throws IllegalStateException, IOException {
		String saveDirectory = "C:\\upload";
		File dir = new File(saveDirectory);
		
		if(dir.exists() == false) {
			dir.mkdir();
		}
		MultipartFile f = request.getFile("upload");					// 사용자가 제출한 파일
		File dest = new File(saveDirectory, f.getOriginalFilename());	// 서버에서 만든 파일 객체(비어있음)
		f.transferTo(dest);	// 사용자가 올린 파일을 지정한 위치로 전송한다
		
		System.out.println("input의 이름 : " + f.getName());
		System.out.println("원본 파일 이름  : " + f.getOriginalFilename());
		System.out.println("파일의 컨텐트 타입 (형식)  : " + f.getContentType());
		System.out.println("파일크기 : " + f.getSize());
		System.out.println();
		return "redirect:/ex01";
	}
	
}
