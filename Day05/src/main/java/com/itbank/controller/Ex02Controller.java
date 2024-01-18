package com.itbank.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.itbankt.model.Ex02DTO;

@Controller
public class Ex02Controller {
	
	@GetMapping("/ex02")
	public void ex02() {}
	
	@PostMapping("/ex02")
	public String ex02(Ex02DTO dto) throws IllegalStateException, IOException {
		File dir = new File("C:\\upload");	// 파일을 생성할 서버쪽 디렉토리를 지정한다
		if(dir.exists() == false) {			// 만약 업로드 디렉토리가 없으면
			dir.mkdir();					// 생성한다
		}
		File dest = new File(dir, dto.getUpload().getOriginalFilename());
		// 업로드 디렉토리 내부에, 원본 파일이름으로 새로운 파일 객체를 생성한다
		// 이때 실제 파일 생성되는 것은 아니다. (파일을 생성하기 위한 기본 위치정보만 지정되어 있다)
		
		dto.getUpload().transferTo(dest);	// 사용자가 제출한 파일을 지정한 dest로 전송한다 (파일이 생성됨)
		System.out.println("title : " + dto.getTitle());	// 사용자가 제출한 문자열 파라미터
		System.out.println("upload : " + dto.getUpload().getOriginalFilename());// 파일
		System.out.println();
		return "redirect:/ex02";
	}
	
	
	
}
