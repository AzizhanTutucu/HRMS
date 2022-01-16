package com.example.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.hrms.entities.concretes.JobAdvertisement;
import com.example.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{

	
	List<JobAdvertisement> getByIsActiveTrue();
	
	List<JobAdvertisement> getByEmployer_CompanyNameAndIsActiveTrue(@Param("companyName") String companyName);

	List<JobAdvertisement> getByOrderByApplicationDeadLineAsc();
	
	@Query("Select new  com.example.hrms.entities.dtos.JobAdvertisementDto"
			+ "(ja.id, ja.openPositions, ja.applicationDeadLine, ja.isActive, e.companyName, jp.positionName)"
			+ "FROM JobAdvertisement ja INNEr join ja.employer e INNER join ja.jobPosition jp ")
	List<JobAdvertisementDto> getJobAdvertisementDtoWithEmployerDetails();
}
