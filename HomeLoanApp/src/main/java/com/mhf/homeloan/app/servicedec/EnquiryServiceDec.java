package com.mhf.homeloan.app.servicedec;

import java.util.List;
import java.util.Optional;

import com.mhf.homeloan.app.model.Enquiry;

public interface EnquiryServiceDec {

	String saveEnqiry(Enquiry enquiry);
	List<Enquiry> viewEnquiries();
	Optional<Enquiry> enquiryDetails(Integer custId);
	
}
