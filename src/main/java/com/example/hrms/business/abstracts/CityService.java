package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.City;

public interface CityService {
	Result add (City city);
	DataResult<List<City>> getAll();
}
