package com.example.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.JobPositionService;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.ErrorResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.core.results.SuccessDataResult;
import com.example.hrms.core.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.JobPositionDao;
import com.example.hrms.entities.concretes.JobPosition;



@Service
public class JobPositionManager implements JobPositionService{
	
	private JobPositionDao jobPositionDao;

	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(),false, "Data listelendi");
	}

	@Override
	public Result add(JobPosition jobPosition) {
		boolean constainsJob = isJobTitleExist(jobPositionDao.findAll(), jobPosition.getPositionName());
		if(constainsJob) {
			return new ErrorResult(false, "Pozisyon bulunuyor.");
		}
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("Pozisyon eklendi.");

	}
	public boolean isJobTitleExist(List<JobPosition> list, String checkValue) {
		for (JobPosition jobPositions: list) {
			if(jobPositions.getPositionName().equalsIgnoreCase(checkValue)) {
				return true;
			}
		}
		return false;
		
	}
	
}
