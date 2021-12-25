package com.example.hrms.core.utilities.abstracts;

import com.example.hrms.core.results.Result;


public interface MailVerificationService {
	Result mailVerification(String eMail);

}
