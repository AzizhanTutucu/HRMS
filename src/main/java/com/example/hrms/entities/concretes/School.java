package com.example.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="schools")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class School {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="school_name")
	@NotNull
	@NotBlank
	private String schoolName;
	
	@Column(name="department_name")
	@NotNull
	@NotBlank
	private String departmentName;
	
	@Column(name="education_start_date")
	@NotNull
	@NotBlank
	private Date educationStartDate;
	
	@Column(name="is_graduate")
	private boolean isGraduate;
	
	@Column(name="graduateDate")
	private Date graduateDate;
	
	@ManyToOne()
	@JoinColumn(name="cv_id")
	private Cv cv;

}
