package com.deloitte.telcom.exceptions;

public class CustomerAccountNotFoundException extends RuntimeException{
	
	public CustomerAccountNotFoundException(String msg) {
		super(msg);
	}

}
