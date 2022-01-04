package com.example.hrms.apiController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.JobAdvertisementService;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementController {
	private JobAdvertisementService jobAdvertisementService;

	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	@GetMapping("/getByIsActiveTrue")
	public DataResult<List<JobAdvertisement>>  getByIsActiveTrue(){
		return this.jobAdvertisementService.getByIsActiveTrue();
	}
	@GetMapping("/findAllByORderByApplicationDeadLineAsc")
	public DataResult<List<JobAdvertisement>>  findAllByORderByApplicationDeadLineAsc( ){
		return this.jobAdvertisementService.findAllByOrderByApplicationDeadLineAsc();
	}
	@GetMapping("/getByIsActiveAndEmloyer_CompanyName")
	public DataResult<List<JobAdvertisement>> getByEmloyer_CompanyNameAndIsActiveTrue(@RequestParam String companyName){
		return this.jobAdvertisementService.getByEmployer_CompanyNameAndIsActiveTrue(companyName);
	}

}
