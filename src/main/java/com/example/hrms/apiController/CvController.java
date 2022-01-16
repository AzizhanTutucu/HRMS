package com.example.hrms.apiController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.CvService;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.Cv;
import com.example.hrms.entities.dtos.CvDto;

@RestController
@RequestMapping("/api/cvs")
public class CvController {
	private CvService cvService;

	public CvController(CvService cvService) {
		super();
		this.cvService = cvService;
	}
	@GetMapping("/getAll")
	public DataResult<List<Cv>> getAll(){
		return this.cvService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody Cv cv) {
		return this.cvService.add(cv);
	}
	@GetMapping("/getByJobSeeker_Id")
	public DataResult<List<Cv>> getByJobSeeker_Id(int id){
		return this.cvService.getByJobSeeker_Id(id);
	}
	@GetMapping("/getCvDtoWithJobSeekerDetails")
	public DataResult<List<CvDto>> getCvDtoWithJobSeekerDetails(){
		return this.cvService.getCvDtoWithJobSeekerDetails();
	}
}
