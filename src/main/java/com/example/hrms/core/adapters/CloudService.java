package com.example.hrms.core.adapters;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.example.hrms.core.results.DataResult;

public interface CloudService {
	
	DataResult<Map<String, String>> uploadImage(MultipartFile multipartFile); 
}
