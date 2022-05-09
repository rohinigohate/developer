package com.mhf.homeloan.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CustomerRegistration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer custId;
	private String custName;
	private String custEmail;
	private Long custMobNo;
	private Long custAlternateNo;
	private String custDOB;
	private String custGender;
	private String custMaritalStatus;
	private Integer custCibilScore;
	private String verifyStatus;
	private String sanctionStatus;

	@OneToOne(cascade = CascadeType.ALL)
	private CustCurrentAddress custCurAddr;

	@OneToOne(cascade = CascadeType.ALL)
	private CustPermanentAddress custPerAddr;

	@OneToOne(cascade = CascadeType.ALL)
	private CustGurantor custGuarant;

	@OneToOne(cascade = CascadeType.ALL)
	private CustProfessionDetails custProfDet;

	@OneToOne(cascade = CascadeType.ALL)
	private BankDetails bankDet;

	@OneToOne(cascade = CascadeType.ALL)
	private CustDoc custDoc;

	@OneToOne(cascade = CascadeType.ALL)
	private CustPreviousLoan custPrLoan;

	@OneToOne(cascade = CascadeType.ALL)
	private PropertyDetails propDetails;
}
