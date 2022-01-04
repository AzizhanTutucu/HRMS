package com.example.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "job_positions")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","jobAdvertisements"})
public class JobPosition {
	
	@Id
	@GeneratedValue
	@Column(name="job_position_id")
	private int positionId;
	@Column(name="position")
	private String positionName;
	
	public JobPosition() {
		
	}

	public JobPosition(int positionId, String positionName) {
		super();
		this.positionId = positionId;
		this.positionName = positionName;
	}

	public int getId() {
		return positionId;
	}

	public void setId(int id) {
		this.positionId = id;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	@OneToMany(mappedBy = "jobPosition")
	private List<JobAdvertisement> jobAdvertisements;

}
