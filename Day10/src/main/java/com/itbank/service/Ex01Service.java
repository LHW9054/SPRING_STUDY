package com.itbank.service;

import org.springframework.stereotype.Service;

@Service
public class Ex01Service {

	public int getNum() {
//		int num = 1234;
		int num;
//		try {
//			num = Integer.parseInt("1234a");
//		} catch (NumberFormatException e) {
//			return -1;
//		}
		num = Integer.parseInt("1234");
		return num;
	}

	public int getNum2() {
		String s1 = null;
		String s2 = "a";
//		return Integer.parseInt("300000000000");
		return s1.compareTo(s2);
	}

}
