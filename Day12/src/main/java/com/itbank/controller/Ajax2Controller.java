package com.itbank.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Ajax2Controller {
	
	private Random ran = new Random();
	
	@GetMapping("/ajax2")
	@ResponseBody // 이함수가 반환하는 값 그자체가 응답이다 (포워딩 하지마라)
	public String ajax2() {
		int num = ran.nextInt(1000);
		String value = String.format("%04d", num);
		System.out.println("클라이언트에게 보낼값 : " + value);
		return value;
	}
	
	// produces : 서버의 함수가 생산하는 값 (반환값)
	// consumes : 서버의 함수가 소비하는 값 (인자값)
	
//	@GetMapping(value="/ajax3", produces="plain/text;charset=utf-8")
	@RequestMapping(value="/ajax3", method=RequestMethod.GET, produces = "plain/text;charset=utf-8")
	@ResponseBody
	public String ajax3(String name, int age) {
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		String isAdult = age >= 20 ? "성인입니다" : "미성년자 입니다";
		
		String value = String.format("%s 님은 %d 살이고, %s", name, age, isAdult);
		System.out.println(value);
		
		return value;
	}

}
