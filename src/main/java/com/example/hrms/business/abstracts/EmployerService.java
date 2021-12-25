package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.Employer;

public interface EmployerService {
	DataResult<List<Employer>>getAll();
	
	Result add(Employer employer);

}
