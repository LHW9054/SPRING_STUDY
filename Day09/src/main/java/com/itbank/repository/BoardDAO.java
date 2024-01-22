package com.itbank.repository;

import java.util.List;

import com.itbank.model.BoardDTO;

public interface BoardDAO {

	int insertBoard(BoardDTO dto);

	int selectMaxIdx();

	List<BoardDTO> selectAll();

	BoardDTO selectOne(int idx);

	String selectFileName(int idx);

	int delete(int idx);

}
