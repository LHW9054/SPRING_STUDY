package com.itbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.component.HashComponent;
import com.itbank.model.MemberDTO;
import com.itbank.repository.MemberDAO;

@Service
public class MemberService {
	
	@Autowired private HashComponent hashComponent;
	@Autowired private MemberDAO memberDAO;
	
	
	public int join(MemberDTO dto) {
		// 새로운 salt와 hash처리를 진행한후 dao로 넘겨준다
		String salt = hashComponent.getRandomSalt();
		String hash = hashComponent.getHash(dto.getUserpw(), salt);
		dto.setUserpw(hash);
		dto.setSalt(salt);
		return memberDAO.insertMember(dto);
	}


	public MemberDTO login(MemberDTO dto) {
		MemberDTO login = memberDAO.selectOneById(dto.getUserid());
		if(login != null) {
			String dbpw = login.getUserpw();
//			String userpw = login.getSalt() + dto.getUserpw();
			String userpw = hashComponent.getHash(dto.getUserpw(), login.getSalt());
			if(dbpw.equals(userpw)) {	// DB에 저장된 해쉬와, 사용자 입력값 기반의 해시가 일치하면
				return login;
			}
		}
		return null;
	}

}
