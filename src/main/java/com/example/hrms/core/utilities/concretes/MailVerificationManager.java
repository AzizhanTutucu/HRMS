package com.example.hrms.core.utilities.concretes;

import org.springframework.stereotype.Service;

import com.example.hrms.core.results.Result;
import com.example.hrms.core.results.SuccessResult;
import com.example.hrms.core.utilities.abstracts.MailVerificationService;


@Service
public class MailVerificationManager implements MailVerificationService {

	@Override
	public Result mailVerification(String eMail) {
		return new SuccessResult("Email doğrulandı.");
	}

}
