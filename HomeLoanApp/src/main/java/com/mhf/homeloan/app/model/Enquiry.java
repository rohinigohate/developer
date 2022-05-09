package com.mhf.homeloan.app.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Enquiry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer custId;
	private String custName;
	private Long custMobNo;
	private String custEmail;
	private String propArea;
	private String propCity;
	private String custPAN;
	private Long custAadhaar;
	private Double custAnnualIncome;
	private Integer custCIBIL;
	private Double eligibleAmount;
	private String eligibility;
}
