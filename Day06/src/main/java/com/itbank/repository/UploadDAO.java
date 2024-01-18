package com.itbank.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.itbank.model.UploadDTO;

public interface UploadDAO {

	@Insert("insert into upload1 (title, originalFileName, storedFileName) values"
			+ "(#{title}, #{originalFileName}, #{storedFileName})")
	int insert(UploadDTO dto);

	@Select("select * from upload1 order by idx")
	List<UploadDTO> selectList();

	@Select("select * from upload1 where idx = #{idx}")
	UploadDTO selectOne(int idx);

	@Delete("delete upload1 where idx = #{idx}")
	int delete(int idx);

}
