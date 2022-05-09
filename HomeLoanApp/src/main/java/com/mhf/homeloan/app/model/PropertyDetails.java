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
public class PropertyDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer propertyId;	
	private String propertyName;	
	private String propertyStatus;
	private Double propEstPrice;

}
