package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.Cv;
import com.example.hrms.entities.dtos.CvDto;

public interface CvService {

	DataResult<List<Cv>> getAll();
	Result add (Cv cv);
	DataResult<List<Cv>> getByJobSeeker_Id(int id);
	DataResult<List<CvDto>> getCvDtoWithJobSeekerDetails();
}
