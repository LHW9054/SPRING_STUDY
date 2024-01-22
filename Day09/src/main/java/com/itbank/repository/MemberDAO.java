package com.itbank.repository;

import com.itbank.model.MemberDTO;

public interface MemberDAO {

	int insertMember(MemberDTO dto);

	MemberDTO selectOneById(String userid);


}
