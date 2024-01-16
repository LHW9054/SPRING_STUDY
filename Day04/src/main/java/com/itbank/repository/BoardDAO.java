package com.itbank.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Controller;

import com.itbank.model.BoardDTO;

@Controller
public interface BoardDAO {

	@Select("select * from board order by idx")
	List<BoardDTO> selectAll();

	@Select("select * from board where idx=#{idx}")
	BoardDTO oneselectList(int idx);
	
	//update board set title=#{title}, writer=#{writer}, content=#{content} where idx=#{idx}
	//update board SET title = #{title}, writer = #{writer}, content = #{content} WHERE idx = #{idx} when userpw = #{userpw};
	@Update("update board set title=#{title}, writer=#{writer}, content=#{content} where idx=#{idx}")
	int modify(BoardDTO dto);
	
	@Delete("delete board where idx=#{idx}")
	int delete(int idx);

	@Insert("insert into board (title, writer, content) values (#{title}, #{writer}, #{content})")
	int insert(BoardDTO dto);
	
}
