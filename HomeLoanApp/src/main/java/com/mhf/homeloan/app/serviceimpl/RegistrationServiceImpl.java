package com.mhf.homeloan.app.serviceimpl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mhf.homeloan.app.model.CustomerRegistration;
import com.mhf.homeloan.app.repository.RegistrationRepository;
import com.mhf.homeloan.app.servicedec.RegistrationServiceDec;


@Service
public class RegistrationServiceImpl implements RegistrationServiceDec {
	@Autowired
	private RegistrationRepository regRepo;

	@Override
	public String saveReg(CustomerRegistration cr) {
		cr.setVerifyStatus("Pending");
		cr.setSanctionStatus("Pending");
		if (regRepo.save(cr) != null) {
			return "Registration Successful";
		} else {
			return "Failed";
		}
	}

	@Override
	public List<CustomerRegistration> viewCustomerRegistration() {
		return regRepo.findAll();
	}

	@Override
	public Optional<CustomerRegistration> CustomerRegistrationDetails(Integer custId) {
		Optional<CustomerRegistration> optionalReg = regRepo.findById(custId);
		return optionalReg;
	}

	@Override
	public void updateRegistration(CustomerRegistration cr) {
		regRepo.save(cr);
	}
}
