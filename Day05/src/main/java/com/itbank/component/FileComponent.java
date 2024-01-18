package com.itbank.component;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileComponent {
	
	private String saveDirectory = "C:\\upload";
	
	public FileComponent() {
		File dir = new File(saveDirectory);
		if(dir.exists() == false) {
			dir.mkdir();
		}
	}
	
	public String upload(MultipartFile f) {
		String fileName = null;
		String originalFileName = f.getOriginalFilename();
		String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
		String storedFileName = UUID.randomUUID().toString().replace("-", "");
		storedFileName += ext;
		File dest = new File(saveDirectory, storedFileName);
		try {
			f.transferTo(dest);
			fileName = dest.getName(); 	
			} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return fileName;
	}
	
	
	

}
