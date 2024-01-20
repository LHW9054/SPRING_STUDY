package com.itbank.component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;

import org.springframework.stereotype.Component;

@Component
public class HashComponent {
	
	public String getRandomSalt() {
		String salt = null;
		SecureRandom ran = new SecureRandom();	// 보안에 활용할수 있는 수준의 랜덤
		byte[] arr = new byte[16];
		ran.nextBytes(arr);
		salt = new String(Base64.getEncoder().encode(arr));
		return salt;
	}

	
	public String getHash(String source, String salt) {	// 원본 문자열, salt
		HashMap<String, String> map = new HashMap<>();
		String hash = null;					// 해시값을 담을 문자열
		MessageDigest md = null;			// 해시 알고리즘을 처리할 객체
		try {
			md = MessageDigest.getInstance("SHA-512");	// 해시알고리즘 : SHA-512
			
			//원본 소스를 추가하기전, salt도 같이 추가한다
//			salt = getSalt();
			md.update(salt.getBytes());
			
			md.update(source.getBytes());	// 원본 소스를 바이트 형태로 추가
			hash = String.format("%0128X", new BigInteger(1, md.digest()));
			// 원본소스를 SHA512형식을 적용한 해시로 숫자를 추출하고,
			// 추출된 숫자를 128wkfldml 16진수 문자열로 만들기

			map.put("salt", salt);
			map.put("hash", hash);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return hash;
	}
	
	
}
