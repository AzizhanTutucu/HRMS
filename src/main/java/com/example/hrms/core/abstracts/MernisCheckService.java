package com.example.hrms.core.abstracts;


import java.rmi.RemoteException;

import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.JobSeeker;

public interface MernisCheckService {
	Result mernisCheck(JobSeeker jobSeeker) throws NumberFormatException, RemoteException   ;
		
	}

