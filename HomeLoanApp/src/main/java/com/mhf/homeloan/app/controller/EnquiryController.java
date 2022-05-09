package com.mhf.homeloan.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mhf.homeloan.app.exception.CustomerNotFoundException;
import com.mhf.homeloan.app.model.Enquiry;
import com.mhf.homeloan.app.servicedec.EnquiryServiceDec;

@CrossOrigin("*")
@RestController
public class EnquiryController {

	@Autowired
	private EnquiryServiceDec enquiryService;

	@PostMapping("/saveEnquiry")
	public ResponseEntity<String> saveEnquiry(@RequestBody Enquiry enquiry) {
		String msg = enquiryService.saveEnqiry(enquiry);
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}

	//For All Customer
	@GetMapping("/viewEnquiries")
	public ResponseEntity<List<Enquiry>> viewEnquiries() {
		List<Enquiry> enquiryList = enquiryService.viewEnquiries();
		return new ResponseEntity<List<Enquiry>>(enquiryList, HttpStatus.OK);
	}

	//For single Customer
	@GetMapping("/enquiryDetails/{custId}")
	public ResponseEntity<Enquiry> enquiryDetails(@PathVariable Integer custId) {
		Optional<Enquiry> enquiryObj = enquiryService.enquiryDetails(custId);
		if (enquiryObj.isPresent()) {
			return new ResponseEntity(enquiryObj, HttpStatus.OK);
		} else {
			throw new CustomerNotFoundException("Customer not found");
		}
	}

}
