package com.itbank.util;

public enum ResultType {
	XML("xml"),		// 기울어진 글씨 + 긁은 글씨
	JSON("json");	// static + final
	
	private String resultType;
	
	private ResultType(String resultType){
		this.resultType = resultType;
	}

	public String getResultType() {
		return resultType;
	}
}
