package com.mhf.homeloan.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mhf.homeloan.app.model.CustomerRegistration;

public interface RegistrationRepository extends JpaRepository<CustomerRegistration, Integer>{

}
