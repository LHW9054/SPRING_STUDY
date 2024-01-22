package com.itbank.component;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileComponent {

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	private String saveDirectory = "C:\\upload";
	
	public FileComponent() {
		File dir = new File(saveDirectory);
		if(dir.exists() == false) {
			dir.mkdir();
		}
	}
	
	public String upload(MultipartFile upload) {
		String fileName = sdf.format(new Date()) + "_" + upload.getOriginalFilename();
		File dest = new File(saveDirectory, fileName);
		try {
			upload.transferTo(dest);
			return fileName;
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}	
		return null;
	}

	public void deleteFile(String fileName) {
		File dest = new File(saveDirectory, fileName);
		if(dest.exists()) {
			dest.delete();
		}
	}
	
	
	
	
	
	
}
