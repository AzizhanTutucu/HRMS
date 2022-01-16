package com.example.hrms.apiController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.SocialAdressService;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.SocialAdress;

@RestController
@RequestMapping("/api/socialAdresses")
public class SocialAdressController {
	private SocialAdressService socialAdressService;

	public SocialAdressController(SocialAdressService socialAdressService) {
		super();
		this.socialAdressService = socialAdressService;
	}
	@PostMapping("/add")
	public Result add(@RequestBody SocialAdress socialAdress) {
		return this.socialAdressService.add(socialAdress);
	}

}
