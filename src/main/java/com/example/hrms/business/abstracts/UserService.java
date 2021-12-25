package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.User;

public interface UserService {
	
	DataResult<List<User>>getAll();
	
	Result add(User user);

}
