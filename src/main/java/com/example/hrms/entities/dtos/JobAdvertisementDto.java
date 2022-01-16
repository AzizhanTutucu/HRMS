package com.example.hrms.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto {
	private int id;
	private int openPositions;
	private Date applicationDeadLine;
	private boolean isActive;
	private String companyName;
	private String positionName;
}
