package com.itbank.repository;

import java.util.List;

import com.itbank.model.MusicDTO;

public interface MusicDAO {

	
	List<MusicDTO> selectAll();

}
