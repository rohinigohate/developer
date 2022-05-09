package com.mhf.homeloan.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CustDoc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer docId;
	@Lob
	private byte[] addressProof;
	@Lob
	private byte[] bankStatement;
	@Lob
	private byte[] itr;
	@Lob
	private byte[] photo;
	@Lob
	private byte[] blankCheck;
	@Lob
	private byte[] thumb;
	@Lob
	private byte[] salarySlip;
	@Lob
	private byte[] signature;
	@Lob
	private byte[] aadharCard;
	@Lob
	private byte[] panCard;

}
