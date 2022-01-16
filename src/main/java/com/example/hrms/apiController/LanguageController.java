package com.example.hrms.apiController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.LanguageService;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {
	private LanguageService languageService;

	public LanguageController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	@PostMapping("/add")
	public Result add(@RequestBody Language language) {
		return this.languageService.add(language);
	}

}
