package com.example.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.hrms.business.abstracts.ImageService;
import com.example.hrms.core.adapters.CloudService;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.core.results.SuccessDataResult;
import com.example.hrms.core.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.ImageDao;
import com.example.hrms.entities.concretes.Image;

import lombok.var;
@Service
public class ImageManager implements ImageService{
	private ImageDao imageDao;
	private CloudService cloudService;

	@Autowired
	public ImageManager(ImageDao imageDao, CloudService cloudService) {
		super();
		this.imageDao = imageDao;
		this.cloudService = cloudService;
	}

	@Override
	public DataResult<List<Image>> getAll() {
		return new SuccessDataResult<List<Image>>(this.imageDao.findAll(),true, "Image Listed");
	}
	
	@Override
	public Result add(Image image, MultipartFile multipartFile) {
		var result = this.cloudService.uploadImage(multipartFile).getData();
		image.setImageUrl(result.get("url"));
		this.imageDao.save(image);
		return new SuccessResult("image added");
	}

}
