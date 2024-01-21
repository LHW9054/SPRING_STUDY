package com.itbank.repository;

import java.util.List;

//import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.itbank.model.MemberDTO;


@Repository
public interface MemberDAO {

	@Select("select * from member2 where userid=#{userid}")
	MemberDTO selectOneByUserid(String userid);

//	@Insert("insert into member2 (userid, userpw, email, username, salt)"
//			+ "values (#{userid}, #{userpw}, #{email}, #{username}, #{salt})")
	int insertMember(MemberDTO dto);

	
	List<MemberDTO> selectAll();


	
}
