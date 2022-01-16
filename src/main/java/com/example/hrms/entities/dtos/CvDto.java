package com.example.hrms.entities.dtos;


import java.util.Date;
import java.util.List;

import com.example.hrms.entities.concretes.Ability;
import com.example.hrms.entities.concretes.Language;
import com.example.hrms.entities.concretes.School;
import com.example.hrms.entities.concretes.SocialAdress;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {
	private int id;
	private String coverLetter; 
	private String firstName;
	private String lastName;
	private String githubUrl;
	private String linkedinUrl;
	private String schoolName;
	private String departmentName;
	private Date educationStartDate;
	private boolean isGraduate;
	private Date graduateDate;
	private String languageName;
	private int languageLevel;
	private String abilityName;
	private String companyName;
	private String positionName;
	private Date startDate;
	private Date endDate;
	
}
