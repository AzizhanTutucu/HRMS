package com.example.hrms.business.abstracts;

import java.rmi.RemoteException;
import java.util.List;

import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
	DataResult<List<JobSeeker>>getAll();
	
	Result add(JobSeeker jobSeeker) throws NumberFormatException, RemoteException ;

}
