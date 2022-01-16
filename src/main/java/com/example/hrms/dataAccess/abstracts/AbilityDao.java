package com.example.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrms.entities.concretes.Ability;

public interface AbilityDao extends JpaRepository<Ability, Integer>{

}
