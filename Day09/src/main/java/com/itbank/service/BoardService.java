package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.component.FileComponent;
import com.itbank.model.BoardDTO;
import com.itbank.repository.BoardDAO;

@Service
public class BoardService {
	
	@Autowired private FileComponent fileComponent;
	@Autowired private BoardDAO boardDAO;
	
	public List<BoardDTO> selectAll() {
		return boardDAO.selectAll();
	}
	
	
	public BoardDTO selectOne(int idx) {
		return boardDAO.selectOne(idx);
	}
	
	public int write(BoardDTO dto) {
		int idx = 0;
		
		// 파일 전송하고 파일이름을 dto에 setting하여 insertBoard 실행
		if(dto.getUpload().getSize() != 0) {
			String fileName = fileComponent.upload(dto.getUpload());
			dto.setFileName(fileName);
		}
		
		// 정상적으로 추가되면 selectMaxIdx 실행해서 가장 최근 idx를 불러와서 반환
		int row = boardDAO.insertBoard(dto);
		
		if(row != 0) {
			idx=boardDAO.selectMaxIdx();
		}
		return idx;
	}




	public int delete(int idx) {
		String fileName = boardDAO.selectFileName(idx);
		if(fileName != null) {
			fileComponent.deleteFile(fileName);
		}
		return boardDAO.delete(idx);
	}
	
}
