package com.example.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.Image;

public interface ImageService {
	DataResult<List<Image>> getAll();
	
	Result add (Image image , MultipartFile multipartFile);
}
