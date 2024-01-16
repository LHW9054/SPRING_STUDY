package com.itbank.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface TestDAO {
	
	@Select("select banner from v$version")
	String getVersion();
	
	@Select("select sysdate from dual")
	Date getSysdate();
	
	@Select("select tname from tab")
	List<String> getTableInfo();

}
