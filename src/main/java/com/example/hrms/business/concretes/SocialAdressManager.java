package com.example.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.SocialAdressService;
import com.example.hrms.core.results.Result;
import com.example.hrms.core.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.SocialAdressDao;
import com.example.hrms.entities.concretes.SocialAdress;

@Service
public class SocialAdressManager implements SocialAdressService{
	private SocialAdressDao socialAdressDao;

	@Autowired
	public SocialAdressManager(SocialAdressDao socialAdressDao) {
		super();
		this.socialAdressDao = socialAdressDao;
	}

	@Override
	public Result add(SocialAdress socialAdress) {
		this.socialAdressDao.save(socialAdress);
		return new SuccessResult("Social Adress Added");
	}

}
