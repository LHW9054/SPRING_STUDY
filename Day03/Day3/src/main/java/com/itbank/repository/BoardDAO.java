package com.itbank.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itbank.model.BoardDTO;

public interface BoardDAO {
	
	@Select("select * from board order by idx")
	List<BoardDTO> selectList();

	@Insert("insert into board (title, writer, content) values (#{title}, #{writer}, #{content})")
	int insert(BoardDTO dto);

	@Select("select * from board where idx=#{idx}")
	BoardDTO oneselectList(int idx);

	@Update("update board set title=#{title}, writer=#{writer}, content=#{content} where idx=#{idx}")
	int modify(BoardDTO dto);

	@Delete("delete board where idx=#{idx}")
	int delete(int idx);


	

}
