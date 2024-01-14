package com.itbank.repository;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.itbank.model.ArtistDTO;

public interface Ex03DAO {

	@Select("select * from artist order by id")
	List<ArtistDTO> selectList();

	







}
