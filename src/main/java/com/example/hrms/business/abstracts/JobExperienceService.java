package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.JobExperience;

public interface JobExperienceService {
	DataResult<List<JobExperience>> getByCv_IdOrderByEndDateDesc(int cvId);
	
	Result add (JobExperience jobExperience);
}
