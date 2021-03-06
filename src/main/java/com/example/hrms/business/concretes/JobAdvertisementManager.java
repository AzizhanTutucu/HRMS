package com.example.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.JobAdvertisementService;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.core.results.SuccessDataResult;
import com.example.hrms.core.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.JobAdvertisementDao;
import com.example.hrms.entities.concretes.JobAdvertisement;
import com.example.hrms.entities.dtos.JobAdvertisementDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{
	
	//private EmployerDao employerDao;
	private JobAdvertisementDao jobAdvertisementDao;
	//private CityDao cityDao;

	@Autowired
	public JobAdvertisementManager( JobAdvertisementDao jobAdvertisementDao) {
		super();
		//this.employerDao = employerDao;
		this.jobAdvertisementDao = jobAdvertisementDao;
		//this.cityDao=cityDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),true, "data listelendi.");
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş ilanı eklendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrue() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveTrue(),true, "Data listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByOrderByApplicationDeadLineAsc() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByOrderByApplicationDeadLineAsc(),true, "Data listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByEmployer_CompanyNameAndIsActiveTrue(String companyName) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByEmployer_CompanyNameAndIsActiveTrue(companyName ),true, "Data listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getJobAdvertisementDtoWithEmployerDetails() {
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getJobAdvertisementDtoWithEmployerDetails(),true, "Data Listelendi");
	}

}
