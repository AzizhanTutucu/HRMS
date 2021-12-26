package com.example.hrms.core.concretes;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import com.example.hrms.core.abstracts.MernisCheckService;
import com.example.hrms.core.results.ErrorResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.core.results.SuccessResult;
import com.example.hrms.entities.concretes.JobSeeker;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisCheckManager implements MernisCheckService{

	@Override
	public Result mernisCheck(JobSeeker jobSeeker) throws NumberFormatException, RemoteException    {
		KPSPublicSoapProxy kpsPublicSoapProxy= new KPSPublicSoapProxy();
		
		
		boolean result = kpsPublicSoapProxy.TCKimlikNoDogrula(Long.parseLong(jobSeeker.getNationalId()), jobSeeker.getFirstName(), jobSeeker.getLastName(), jobSeeker.getBirthDate());
		if(!result) {
			return new ErrorResult(false);
		}
		return new SuccessResult(true);
	}

}
