package com.mhf.homeloan.app.servicedec;


import java.util.List;
import java.util.Optional;

import com.mhf.homeloan.app.model.CustomerRegistration;

public interface RegistrationServiceDec {
	public String saveReg(CustomerRegistration cr);

	public List<CustomerRegistration> viewCustomerRegistration();

	public Optional<CustomerRegistration> CustomerRegistrationDetails(Integer custId);

	public void updateRegistration(CustomerRegistration cr);

//	public List<CustDoc> savedoc(CustDoc d);
}
