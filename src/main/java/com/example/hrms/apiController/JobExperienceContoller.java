package com.example.hrms.apiController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.JobExperienceService;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.JobExperience;

@RestController
@RequestMapping("/api/JobExperiences")
public class JobExperienceContoller {
	private JobExperienceService experienceService;

	public JobExperienceContoller(JobExperienceService experienceService) {
		super();
		this.experienceService = experienceService;
	}
	@GetMapping("getByCv_IdOrderByEndDateDesc")
	public DataResult<List<JobExperience>> getByCv_IdOrderByEndDateDesc(int cvId){
		return this.experienceService.getByCv_IdOrderByEndDateDesc(cvId);
	}
	@PostMapping("/add")
	public Result add(@RequestBody JobExperience jobExperience) {
		return this.experienceService.add(jobExperience);
	}
}
