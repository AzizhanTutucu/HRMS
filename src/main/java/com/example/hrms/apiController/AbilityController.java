package com.example.hrms.apiController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.AbilityService;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.Ability;

@RestController
@RequestMapping("/api/Abilities")
public class AbilityController {
	private AbilityService abilityService;

	public AbilityController(AbilityService abilityService) {
		super();
		this.abilityService = abilityService;
	}
	@PostMapping("/api")
	public Result add(@RequestBody Ability ability) {
		return this.abilityService.add(ability);
	}
}
