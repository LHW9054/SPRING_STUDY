package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.service.Ex01Service;

@Controller
public class Ex01Controller {
	
		// 예외처리
	@Autowired private Ex01Service ex01Service;
	
	@GetMapping("/ex01")
	public ModelAndView ex01() {
		ModelAndView mav = new ModelAndView();
		int num1 = ex01Service.getNum();
		mav.addObject("num1", num1);
		
		int num2 = ex01Service.getNum2();
		mav.addObject("num2", num2);
		
		return mav;
	}
	
	// 현재 컨트롤러 내부에서 발생하는 예외
	// 서비스, 컴포넌트, DAO 등에서 발생하는 예외를 컨트롤러로 넘겨서
	// 컨트롤러에서 취합하여 특정 타입의 예외를 처리하는 함수를 별도로 준비한다
	@ExceptionHandler(NumberFormatException.class)
	// 어노테이션은 예외처리 함수임을 명시한다
	// 괄호안에는 어떤 타입의 예외처리가 발생했을 경우 처리하는 함수인지 명시한다
	// 이벤트 함수처럼, 특정 타입의 예외가 발생하면 해당 함수를 호출하여 실행한다
	public ModelAndView num1Exception(NumberFormatException e) {
		// 반환형은 자유롭게 설정 할수 있으며, 응답을 만들어내는 형식이면 된다
		// 매개변수는 받지않을수도 있고, 받는다면 예외상황을 분류하거나 시스템에 로그를 남기는 용도로 사용할수 있다
		ModelAndView mav = new ModelAndView("number-exception");
		mav.addObject("msg", e.getMessage());
		return mav;
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView npe() {
		ModelAndView mav = new ModelAndView("number-exception");
		mav.addObject("msg", "알수없는 문제가 발생했습니다");
		return mav;
	}
	
	

}
