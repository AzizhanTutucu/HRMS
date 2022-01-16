package com.example.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.CvService;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.core.results.SuccessDataResult;
import com.example.hrms.core.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.CvDao;
import com.example.hrms.entities.concretes.Cv;
import com.example.hrms.entities.dtos.CvDto;

@Service
public class CvManager implements CvService{
	
	private CvDao cvDao;
	
	@Autowired
	public CvManager(CvDao cvDao) {
		super();
		this.cvDao = cvDao;
	}

	@Override
	public DataResult<List<Cv>> getAll() {
		return new SuccessDataResult<List<Cv>>(this.cvDao.findAll(),true, "Cv Listelendi");
	}

	@Override
	public Result add(Cv cv) {
		this.cvDao.save(cv);
		return new SuccessResult("Cv eklendi.");
	}

	@Override
	public DataResult<List<Cv>> getByJobSeeker_Id(int id) {
		return new SuccessDataResult<List<Cv>>(this.cvDao.getByJobSeeker_Id(id),true, "Cv listelendi");
	}

	@Override
	public DataResult<List<CvDto>> getCvDtoWithJobSeekerDetails() {
		return new SuccessDataResult<List<CvDto>>(this.cvDao.getCvDtoWithJobSeekerDetails());
	}

}
