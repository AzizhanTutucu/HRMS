package com.example.hrms.core.adapters;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.ErrorDataResult;
import com.example.hrms.core.results.SuccessDataResult;
@Service
public class CloudManager implements CloudService{
	private Cloudinary cloudinary;
	
	public CloudManager() {
		Map<String, String> valuesMap = new HashMap<>();
        valuesMap.put("cloud_name","myhrms" );
        valuesMap.put("api_key", "324984587852848" );
        valuesMap.put("api_secret","GLsRXyw8zbJosB04xIyrvK1-to4" );
        cloudinary = new Cloudinary(valuesMap);
	}
	
	@Override
	public DataResult<Map<String, String>> uploadImage(MultipartFile multipartFile) {
		File file;
		try {
			file = convert (multipartFile);
			@SuppressWarnings("unchecked")
			Map<String, String> result =cloudinary.uploader().upload(file,ObjectUtils.emptyMap());
			return new SuccessDataResult<>(result);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ErrorDataResult<>("File yüklenemedi.");
	}
	 private File convert(MultipartFile multipartFile) throws IOException {
	        File file = new File(multipartFile.getOriginalFilename());
	        FileOutputStream stream = new FileOutputStream(file);
	        stream.write(multipartFile.getBytes());
	        stream.close();

	        return file;
	    }

}
