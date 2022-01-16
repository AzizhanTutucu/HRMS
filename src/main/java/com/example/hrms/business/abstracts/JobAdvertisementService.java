package com.example.hrms.business.abstracts;

import java.util.List;


import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.JobAdvertisement;
import com.example.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementService {
	DataResult<List<JobAdvertisement>> getAll();
	
	Result add(JobAdvertisement jobAdvertisement);
	
	DataResult<List<JobAdvertisement>>  getByIsActiveTrue();
	
	DataResult<List<JobAdvertisement>>  getByOrderByApplicationDeadLineAsc();
	
	DataResult<List<JobAdvertisement>> getByEmployer_CompanyNameAndIsActiveTrue( String companyName);

	DataResult<List<JobAdvertisementDto>> getJobAdvertisementDtoWithEmployerDetails();
}
