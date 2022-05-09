package com.mhf.homeloan.app.controller;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.mhf.homeloan.app.exception.CustomerNotFoundException;
import com.mhf.homeloan.app.model.CustDoc;
import com.mhf.homeloan.app.model.CustomerRegistration;
import com.mhf.homeloan.app.servicedec.RegistrationServiceDec;

@CrossOrigin("*")
@RestController
public class RegistrationController {

	@Autowired
	private RegistrationServiceDec regService;

	@PostMapping(value = "/saveApplication", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> saveReg(@RequestPart("cr") String cr,
			@RequestPart(required = true, value = "addressproof") MultipartFile files1,
			@RequestPart(required = true, value = "property_details") MultipartFile files2,
			@RequestPart(required = true, value = "itr") MultipartFile files3,
			@RequestPart(required = true, value = "photo") MultipartFile files4,
			@RequestPart(required = true, value = "bankcheque") MultipartFile files5,
			@RequestPart(required = true, value = "thumb") MultipartFile files6,
			@RequestPart(required = true, value = "salaryslip") MultipartFile files7,
			@RequestPart(required = true, value = "signature") MultipartFile files8,
			@RequestPart(required = true, value = "adharcard") MultipartFile files9,
			@RequestParam(required = true, value = "panCard") MultipartFile files10) throws IOException {
		System.out.println("file " + files10.getName());
		System.out.println(cr);
		CustDoc custDocObj = new CustDoc();
		custDocObj.setAddressProof(files1.getBytes());
		custDocObj.setBankStatement(files2.getBytes());
		custDocObj.setItr(files3.getBytes());
		custDocObj.setPhoto(files4.getBytes());
		custDocObj.setBlankCheck(files5.getBytes());
		custDocObj.setThumb(files6.getBytes());
		custDocObj.setSalarySlip(files7.getBytes());
		custDocObj.setSignature(files8.getBytes());
		custDocObj.setAadharCard(files9.getBytes());
		custDocObj.setPanCard(files10.getBytes());
		Gson gsn = new Gson();
		CustomerRegistration fromJson = gsn.fromJson(cr, CustomerRegistration.class);
		System.out.println(fromJson.getCustEmail());
		fromJson.setCustDoc(custDocObj);
		System.out.println(fromJson.getCustEmail());
		String msg = regService.saveReg(fromJson);
		return new ResponseEntity<>(msg, HttpStatus.CREATED);
	}

	@GetMapping("/viewCustomerRegistration")
	public ResponseEntity<List<CustomerRegistration>> viewCustomerRegistration() {
		List<CustomerRegistration> customerRegistrationList = regService.viewCustomerRegistration();
		return new ResponseEntity<List<CustomerRegistration>>(customerRegistrationList, HttpStatus.OK);
	}

	@GetMapping("/customerRegistrationDetails/{custId}")
	public ResponseEntity<CustomerRegistration> customerRegistrationDetails(@PathVariable Integer custId) {
		Optional<CustomerRegistration> customerRegistrationObj = regService.CustomerRegistrationDetails(custId);
		if (customerRegistrationObj.isPresent()) {
			return new ResponseEntity(customerRegistrationObj, HttpStatus.OK);
		} else {
			throw new CustomerNotFoundException("Customer not found");
		}
	}
	
	@PostMapping("/updateRegistration")
	public void updateRegistration(@RequestBody CustomerRegistration cr) {
		regService.updateRegistration(cr);
	}

}
