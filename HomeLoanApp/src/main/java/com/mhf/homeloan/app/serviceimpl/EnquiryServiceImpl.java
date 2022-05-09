package com.mhf.homeloan.app.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mhf.homeloan.app.model.CustomerRegistration;
import com.mhf.homeloan.app.model.Enquiry;
import com.mhf.homeloan.app.repository.EnquiryRepository;
import com.mhf.homeloan.app.repository.RegistrationRepository;
import com.mhf.homeloan.app.servicedec.EnquiryServiceDec;

@Service
public class EnquiryServiceImpl implements EnquiryServiceDec {

	@Autowired
	private EnquiryRepository enquiryRepo;

	@Override
	public String saveEnqiry(Enquiry enquiry) {
		if (enquiryRepo.save(enquiry) != null) {
			return " Data saves successfully";
		} else {
			return "failed";
		}
	}

	@Override
	public List<Enquiry> viewEnquiries() {
		return enquiryRepo.findAll();
	}

	@Override
	public Optional<Enquiry> enquiryDetails(Integer custId) {
		Optional<Enquiry> optionalEnquiry = enquiryRepo.findById(custId);
		return optionalEnquiry;
	}

}
