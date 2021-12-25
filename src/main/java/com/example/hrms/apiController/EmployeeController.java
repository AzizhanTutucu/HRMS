package com.example.hrms.apiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.EmployeeService;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.Employee;

@RestController
@RequestMapping("/api/employess")
public class EmployeeController {
	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	@GetMapping("/getall")
	DataResult<List<Employee>>getAll(){
		return this.employeeService.getAll();
	}
	@PostMapping("/add")
	Result add (Employee employee) {
		return this.employeeService.add(employee);
	}

}
