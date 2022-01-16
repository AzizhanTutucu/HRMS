package com.example.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.hrms.entities.concretes.Cv;
import com.example.hrms.entities.dtos.CvDto;

public interface CvDao extends JpaRepository<Cv, Integer> {
	
	List<Cv> getByJobSeeker_Id(int id);
	
	@Query("Select new com.example.hrms.entities.dtos.CvDto"
			+ "(c.id, c.coverLetter,js.firstName,js.lastName,sa.githubUrl,sa.linkedinUrl,s.schoolName,s.departmentName,s.educationStartDate,s.isGraduate,s.graduateDate,l.languageName,l.languageLevel,a.abilityName,je.companyName,je.positionName,je.startDate,je.endDate)"
			+ "FROM Cv c INNER join c.jobSeeker js INNER join c.socialAdresses sa INNER join c.schools s INNER join c.languages l INNER join c.abilities a INNER join c.jobExperiences je  ")
	List<CvDto> getCvDtoWithJobSeekerDetails();
	
	
}
