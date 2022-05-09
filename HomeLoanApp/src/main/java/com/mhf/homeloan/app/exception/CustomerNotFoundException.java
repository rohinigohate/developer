package com.mhf.homeloan.app.exception;

public class CustomerNotFoundException extends RuntimeException 
{

	public CustomerNotFoundException(String msg) {
		super(msg);
	}
}
