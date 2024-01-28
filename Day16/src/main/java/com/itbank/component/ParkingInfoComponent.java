package com.itbank.component;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.itbank.util.ResultType;

@Component
public class ParkingInfoComponent {
	
	private String serviceKey = "RQ1ckzESkp8xVq0CBtgPoDjwFz7IFHbf%2F3vPT0Yq74jPYfWPHnsEJItbxlRkyFajXIkDrVFVKPtDvBp2IQiMVg%3D%3D";

	public String getString() throws IOException{
		return getString(ResultType.JSON);
	}
	
	public String getString(ResultType resultType) throws IOException{
		String jsonData = "";
		
		// 주소 및 파라미터 지정
		String urlString = "https://apis.data.go.kr/6260000/BusanPblcPrkngInfoService/getPblcPrkngInfo";
		urlString += "?";
		
		HashMap<String, String> params = new HashMap<>();
		params.put("serviceKey", serviceKey);
		params.put("pageNo", "1");
		params.put("numOfRows", "10");
		params.put("resultType", resultType.getResultType());
		
		for(String key : params.keySet()) {
			String value = params.get(key);
			urlString += key + "=" + value + "&";
		}
		
		System.out.println(urlString);
		
		// 2) Http연결 만들기
		URL url = new URL(urlString); //throws IOException
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("content-type", "application/json;charset=utf-8");
		
		int statusCode = conn.getResponseCode();	// 200, 301, 404, 500...
		
		Scanner sc = null;
		if(200 <= statusCode && statusCode < 300) {	// 정상이면	
			sc = new Scanner(conn.getInputStream());
			while(sc.hasNextLine()) {
				jsonData += sc.nextLine() + "\r\n";
			}
		}else {
			sc = new Scanner(conn.getErrorStream());
			while(sc.hasNextLine()) {
				System.err.println(sc.nextLine());
			}
		}
		conn.disconnect();// 백엔드에서 열었던 HTTP연결을 닫는다
		sc.close();
		return jsonData;
	}

}
