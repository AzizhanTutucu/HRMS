package com.example.hrms.business.concretes;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.JobSeekerService;
import com.example.hrms.core.abstracts.MernisCheckService;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.ErrorResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.core.results.SuccessDataResult;
import com.example.hrms.core.results.SuccessResult;
import com.example.hrms.core.utilities.abstracts.MailVerificationService;
import com.example.hrms.dataAccess.abstracts.JobSeekerDao;
import com.example.hrms.entities.concretes.JobSeeker;
@Service
public class JobSeekerManager implements JobSeekerService{
	private JobSeekerDao jobSeekerDao;
	private MernisCheckService mernisCheckService;
	private MailVerificationService mailVerificationService;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, MernisCheckService mernisCheckService, MailVerificationService mailVerificationService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.mailVerificationService= mailVerificationService;
		this.mernisCheckService= mernisCheckService;
	}
	

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(),true, "Data listelendi");
	}

	@Override
	public Result add(JobSeeker jobSeeker) throws NumberFormatException, RemoteException {
//		Result isPerson=null;
//		try {
//			isPerson= mernisCheckService.mernisCheck(jobSeeker);
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		if(!isPerson.isSuccess()) {
//			return new ErrorResult(false, "Mernis sorgulaması başarısız.");
//			
//		}
		
		
		if(!this.JobSeekerCheck(jobSeeker).isSuccess()) {
			return new ErrorResult(false, "Geçersiz bilgiler var");
			
		}
		
		if(!this.mailVerificationService.mailVerification(jobSeeker.getEMail()).isSuccess()) {
			return new ErrorResult(false, "Emailinizi kontrol ediniz.");
		}
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult("Kayıt başarılı");
	}
	public Result JobSeekerCheck(JobSeeker jobSeeker) {
		if(jobSeeker.getFirstName()==null) {
			return new ErrorResult(false, "İsim boş bırakılamaz.");
			
		}
		else if (jobSeeker.getLastName()==null) {
			return new ErrorResult(false, "Soyisim boş bırakılamaz.");
			
		}
		else if (jobSeeker.getNationalId()==null) {
			return new ErrorResult(false, "TC no boş bırakılamaz.");
			
		}
		else if (jobSeeker.getBirthDate()<1900 ||jobSeeker.getBirthDate() >LocalDate.now().getYear()) {
			return new ErrorResult(false, "Doğum yılı boş bırakılamaz.");
			
		}
		else if (jobSeeker.getPassword()==null ) {
			return new ErrorResult(false, "Şifre boş bırakılamaz.");
			
		}
		else if (jobSeeker.getEMail()==null) {
			return new ErrorResult(false, "Email boş bırakılamaz.");
		}
		return new SuccessResult("Kayıt başarılı");
	}
	

}
