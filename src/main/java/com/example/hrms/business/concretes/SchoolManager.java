package com.example.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.SchoolService;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.core.results.SuccessDataResult;
import com.example.hrms.core.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.SchoolDao;
import com.example.hrms.entities.concretes.School;
@Service
public class SchoolManager implements SchoolService{
	
	private SchoolDao schoolDao;
	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}

	@Override
	public DataResult<List<School>> getByCv_IdOrderByGraduateDateDesc(int cvId) {
		return new SuccessDataResult<List<School>>(this.schoolDao.getByCv_IdOrderByGraduateDateDesc(cvId),true, "School listed.");
	}

	@Override
	public Result add(School school) {
		this.schoolDao.save(school);
		return new SuccessResult("School added");
	}

}
