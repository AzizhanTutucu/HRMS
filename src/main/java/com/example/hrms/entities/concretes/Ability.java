package com.example.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="abilities")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Ability {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ability_id")
	private int id;
	@Column(name="ability_name")
	private String abilityName;
	
	@ManyToOne()
	@JoinColumn(name="cv_id")
	private Cv cv;
}
