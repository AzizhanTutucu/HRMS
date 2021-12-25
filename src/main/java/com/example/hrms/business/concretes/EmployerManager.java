package com.example.hrms.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.EmployerService;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.ErrorResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.core.results.SuccessDataResult;
import com.example.hrms.core.results.SuccessResult;
import com.example.hrms.core.utilities.abstracts.MailVerificationService;
import com.example.hrms.dataAccess.abstracts.EmployerDao;
import com.example.hrms.entities.concretes.Employer;
import com.example.hrms.entities.concretes.User;
@Service
public class EmployerManager implements EmployerService{
	private EmployerDao employerDao;
	private MailVerificationService mailVerificationService;
	private List<User> list;
	@Autowired
	public EmployerManager(List<User> list,EmployerDao employerDao, MailVerificationService mailVerificationService) {
		super();
		this.employerDao = employerDao;
		this.mailVerificationService=mailVerificationService;
		this.list=list;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),true, "Data listelendi.");
	}

	@Override
	public Result add(Employer employer) {
//		boolean checkMail=checkEmployerMail(employer.getEMail());
//		if(checkMail) {
//			return new ErrorResult(false, "Mail kayıtlı.");
//			
//		}
		if(!this.mailVerificationService.mailVerification(employer.getEMail()).isSuccess()) {
			return new ErrorResult(false, "Emailinizi kontrol ediniz.");
		}
		if(!this.EmployerCheck(employer).isSuccess()) {
			return new ErrorResult(false, "Geçersiz bilgiler var");
		}
		
		this.employerDao.save(employer);
		return new SuccessResult("Kayıt başarılı");
	}
	public Result EmployerCheck(Employer employer) {
		if(employer.getCompanyName()==null) {
			return new ErrorResult(false, "İsim boş bırakılamaz.");
			
		}
		else if (employer.getCompanyPhone()==null) {
			return new ErrorResult(false, "Telefon numarası boş bırakılamaz.");
			
		}
		else if (employer.getWebSıte()==null) {
			return new ErrorResult(false, "Web adresi boş bırakılamaz.");
			
		}
		else if (employer.getEMail()==null) {
			return new ErrorResult(false, "Email boş bırakılamaz.");
			
		}
		else if (employer.getPassword()==null ) {
			return new ErrorResult(false, "Şifre  boş bırakılamaz.");
			
		}
		return new SuccessResult("Kayıt başarılı");
	}
	public boolean checkEmployerMail(String email) {
		for(User employers:this.list ) {
			if(employers.getEMail().equalsIgnoreCase(email)) {
				return true;
			}
			
		}
		return false;
	}

}
