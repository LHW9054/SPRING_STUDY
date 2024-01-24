package com.itbank.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itbank.model.MemberDTO;
import com.itbank.repository.MemberDAO;

@RestController		// 내부의 모든 함수는 @ResponseBody를 자동으로 적용받는다
					// jsp 포워딩 할수 없다

@CrossOrigin		// localhost의 jsp에서 localhost의 서버로 ajax요청을 보내는것은 항상 허용된다
					// localhost의 jsp에서 다른 서버로 ajax요청을 받는것은 허요되지 않는다
					// same-origin(동일 출처 자원 공유 원칙)에 의해, 서버에서 허용해야 다른 도메인에서 자원을 요청할수 있다.
					// CORS (Cross Origin Resource Sharing)

public class AjaxController {
	
	// Servlet-context.xml 에서 annotation-driven 내부에 message-converter를 작성하면
	// produces와 consume에 대한 미디어 타입을 생략할수 있다
	
	// JS에서 파라미터를 묶어서 전달했으면 받을때도, hashmap 혹은 dto형태로 묶어서 받는다
	@PostMapping("/ajax4")
	public String ajax4(@RequestBody HashMap<String, Object> param) {
		System.out.println(param);
		System.out.println("name : " + param.get("name"));
		System.out.println("age : " + param.get("age"));
		
		Object name = param.get("name");
		Object age = param.get("age");
		
		String adult = Integer.parseInt(age.toString()) > 20 ? "성인" : "미성년자";
		
		String value = String.format("%s님의 나이는 %s 살이고", name, age, adult);
		
		return value;
	}
	
	@Autowired private MemberDAO memberDAO;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@GetMapping("/ajax5")	// 아이디중복 체크하기
	public HashMap ajax5(String userid) throws JsonProcessingException {
		MemberDTO dto = memberDAO.selectOneByUserid(userid);
		String msg = dto == null ? "사용가능한 ID입니다" : "이미 사용중인 ID 입니다";
		String color = dto == null ? "blue" : "red";
		
		// 1) 직접 JSON 형식의 문자열 구성하기
//		String result = "{\"msg\" : \"%s\", : \"color\" : \"%s\"}";
//		result = String.format(result, msg, color);
//		System.out.println(result);
		
		// 2) dto혹은 hashmap에 값을 넣은 후 objectMapper를 활용하여 문자열 비교하기
//		HashMap<String, String> map = new HashMap<>();
//		map.put("msg", msg);
//		map.put("color", color);
//		String result = mapper.writeValueAsString(map);	// 예외는 throws
//		System.out.println(result);
		
		// 3) 자바 객체를 그냥 반환하기 
		HashMap<String, String> map = new HashMap<>();
		map.put("msg", msg);
		map.put("color", color);
		return map;
	}
	
	
	@PostMapping("/join")
	public HashMap<String, String> join(@RequestBody MemberDTO dto){
		int row = memberDAO.insert(dto);
		HashMap<String, String> map = new HashMap<>();
		map.put("status", row != 0 ? "가입성공" : "가입실패");
		map.put("color", row != 0 ? "blue" : "red");
		return map;
	}
	
	@GetMapping("/memberList")
	public List<MemberDTO> memberList(){
		return memberDAO.selectList();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
