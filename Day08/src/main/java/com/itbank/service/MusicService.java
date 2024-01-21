package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.MusicDTO;
import com.itbank.repository.MusicDAO;

@Service
public class MusicService {

	@Autowired private MusicDAO musicDAO;
	
	public List<MusicDTO> selectAll() {
		return musicDAO.selectAll();
	}

}
