package com.howtodoinjava.service;

import java.io.ByteArrayOutputStream;

import org.springframework.web.multipart.MultipartFile;

import com.howtodoinjava.model.UserProfile;

public interface AWSS3Service {

	void uploadFile(MultipartFile multipartFile,UserProfile profile)  throws Exception;
	
	void uploadGenericFile(MultipartFile multipartFile)  throws Exception;
	
	public ByteArrayOutputStream downloadFile(String keyName,UserProfile profile);
	
	
}
