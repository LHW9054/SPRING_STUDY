package com.itbank.service;

import org.springframework.stereotype.Service;

@Service
public class Ex02Service {
	
	private int[] arr = { 4, 8, 2, 7, 6};
	
	public int getNum4() {
		return arr[5];
	}

}
