package com.itbank.exception;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.controller.Ex02Controller;

//@ControllerAdvice(assignableTypes = {Ex02Controller.class})
//@ControllerAdvice(value = {"com.itbank.controller", "com.itbank.component"})	
@ControllerAdvice(annotations = Controller.class)
					// 예외처리 함수 (ExceptionHandler)가 모여있는 클래스에 지정한다
					// 범위를 별도로 지정하지 않으면, 프로젝트 전역에서 발생하는 예외를 처리한다
					// 범위를 지정하는 방법
					// 1) assignableTypes : 클래스 정보의 배열을 전달한다
					// 2) value : 특정 패키지 문자열로 전달하여 내부의 컨트롤러에서 발생하는 예외를 처리하게 한다
					// 3) annotations : 단일 어노테이션 정보를 전달한다
public class Ex02ControllerAdvice {
	
	@ExceptionHandler(ArrayIndexOutOfBoundsException.class)
	@ResponseBody   // 이 함수가 반환하는 내용 그 자체가 응답이다 (그러니깐 jsp포워딩하지 마라)
	public String indexException(ArrayIndexOutOfBoundsException e) {
		ModelAndView mav = new ModelAndView();
		String html = "";
		html += "<!DOCTYPE html>"; 
		html += "<html>"; 
		html += "<head></head>";
		html += "<body>";
		html += "<script>";
		html += "	alert('" + e.getMessage() + "')\n";
		html += "	location.href = '/day10'";
		html += "</script>";
		html += "</html>";
		return html;
	}
	

}
