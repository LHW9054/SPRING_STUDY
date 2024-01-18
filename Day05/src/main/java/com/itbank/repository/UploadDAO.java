package com.itbank.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.itbankt.model.Ex03DTO;

public interface UploadDAO {

	@Insert("insert into upload1 (title,fileName) values (#{title}, #{fileName})")
	int insert(Ex03DTO dto);

	@Select("select * from upload1 order by idx")
	List<Ex03DTO> selectAll();

}
