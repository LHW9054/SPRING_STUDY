package com.itbank.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itbankt.model.BoardDTO;

public interface BoardDAO {

	@Select("select * from board3 order by idx desc")
	List<BoardDTO> selectAll();

	@Insert("insert into board3 (title, writer, content, pw)"
			+ "values (#{title}, #{writer}, #{content}, #{pw})")
	int insert(BoardDTO dto);

	@Select("select * from board3 where idx = #{idx}")
	BoardDTO selectOne(int idx);

	@Delete("delete board3 where idx = #{idx} and pw = #{pw}")
	int delete(BoardDTO dto);

	@Select("select * from board3 where idx = #{idx} and pw = #{pw}")
	BoardDTO selectOneByIdxAndPw(BoardDTO param);

	@Update("update board3 set "
			+ "title=#{title}, writer=#{writer}, "
			+ "content=#{content}"
			+ "where idx=#{idx}")
	int update(BoardDTO dto);


}
