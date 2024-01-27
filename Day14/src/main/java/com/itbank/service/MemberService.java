package com.itbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.MemberDTO;
import com.itbank.repository.MemberDAO;

@Service
public class MemberService {

	@Autowired private MemberDAO memberDAO;

	public MemberDTO login(MemberDTO dto) {
		MemberDTO login = memberDAO.login(dto);
		return login;
	}

	public int join(MemberDTO dto) {
		return memberDAO.join(dto);
	}
	

}
