package com.example.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.AbilityService;
import com.example.hrms.core.results.Result;
import com.example.hrms.core.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.AbilityDao;
import com.example.hrms.entities.concretes.Ability;

@Service
public class AbilityManager implements AbilityService{
	
	private AbilityDao abilityDao;
	@Autowired
	public AbilityManager(AbilityDao abilityDao) {
		super();
		this.abilityDao = abilityDao;
	}
	@Override
	public Result add(Ability ability) {
		this.abilityDao.save(ability);
		return new SuccessResult("Ability added");
	}

}
