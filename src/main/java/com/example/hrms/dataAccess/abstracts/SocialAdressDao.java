package com.example.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrms.entities.concretes.SocialAdress;

public interface SocialAdressDao extends JpaRepository<SocialAdress, Integer>{
	

}
