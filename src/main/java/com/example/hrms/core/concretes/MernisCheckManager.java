package com.example.hrms.core.concretes;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import com.example.hrms.core.abstracts.MernisCheckService;
import com.example.hrms.core.results.ErrorResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.core.results.SuccessDataResult;
import com.example.hrms.entities.concretes.JobSeeker;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisCheckManager implements MernisCheckService{

	@Override
	public Result mernisCheck(JobSeeker jobSeeker)  {
		KPSPublicSoapProxy kpsPublicSoapProxy= new KPSPublicSoapProxy();
		
		
		try {
			boolean validation = kpsPublicSoapProxy.TCKimlikNoDogrula
					(Long.parseLong(jobSeeker.getNationalId()), jobSeeker.getFirstName(), jobSeeker.getLastName()
							, jobSeeker.getBirthDate());
			if(validation==false) {
				return new ErrorResult(false, "Mernis doğrulaması başarısız. Bilgilerinizi kontrol ediniz.");
			}
		} catch (NumberFormatException | RemoteException e) {
						e.printStackTrace();
		}
		return new SuccessDataResult<JobSeeker>(jobSeeker,true, "Kayıt başarılı");
		
		
	}

}
