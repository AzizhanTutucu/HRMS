package com.example.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Cvs")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","schools","jobExperiences","languages","socialAdresses","abilities","images"})
public class Cv {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cv_id")
	private int id;
	@Column(name="cover_letter")
	private String coverLetter;

	@OneToMany(mappedBy = "cv")
	private List<School> schools;
	
	@OneToMany(mappedBy = "cv")
	private List<JobExperience> jobExperiences;
	
	@OneToMany(mappedBy = "cv")
	private List<Language> languages;
	
	@OneToMany(mappedBy = "cv")
	private List<SocialAdress> socialAdresses;
	
	@OneToMany(mappedBy = "cv")
	private List<Ability> abilities;
	
	@OneToMany(mappedBy="cv")
	private List<Image> images;
	
	@ManyToOne()
	@JoinColumn(name="job_seeker_id")
	private JobSeeker jobSeeker;
}
