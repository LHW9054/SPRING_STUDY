package com.itbank.repository;

import com.itbank.model.MemberDTO;

public interface MemberDAO {

	MemberDTO login(MemberDTO dto);

	int join(MemberDTO dto);

}
