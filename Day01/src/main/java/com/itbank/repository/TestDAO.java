package com.itbank.repository;

import org.apache.ibatis.annotations.Select;

// java interface의 특징)
// 생성자를 이용한 객체생성이 불가능 하다
// 모든 필드에 public static final 속성이 자동으로 지정된다
// 모든 메서드에 public abstract 속성이 자동으로 지정된다


public interface TestDAO {
	
	@Select("select banner from v$version")
	public String getVersion();
}
