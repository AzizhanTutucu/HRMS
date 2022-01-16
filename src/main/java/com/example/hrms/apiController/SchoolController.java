package com.example.hrms.apiController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.SchoolService;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.School;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {
	private SchoolService schoolService;

	public SchoolController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}
	@GetMapping("getByCv_IdOrderByGraduateDateDesc")
	public DataResult<List<School>> getByCv_IdOrderByGraduateDateDesc(int cvId) {
		return this.schoolService.getByCv_IdOrderByGraduateDateDesc(cvId);
	}
	@PostMapping("/add")
	public Result add (@RequestBody School school) {
		return this.schoolService.add(school);
	}
}
