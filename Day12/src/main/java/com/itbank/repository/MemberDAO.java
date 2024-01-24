package com.itbank.repository;


import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.itbank.model.MemberDTO;

public interface MemberDAO {

	@Select("select * from member6 where userid = #{userid}")
	MemberDTO selectOneByUserid(String wuserid);

	@Insert("insert into member6 values (#{userid}, #{userpw}, #{username}, #{gender})")
	int insert(MemberDTO dto);

	@Select("select * from member6 order by userid")
	List<MemberDTO> selectList();

}
