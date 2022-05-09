package com.mhf.homeloan.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CustProfessionDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer prId;	
	private String presentEmployer;	
	private String designation;	
	private String currentOccupation;	
	private Integer yoe;

}
