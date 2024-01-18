package com.itbank.repository;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Controller;

@Controller
public interface TestDAO {
	
	@Select("select * from v$version")
	String getVersion();
	

}
