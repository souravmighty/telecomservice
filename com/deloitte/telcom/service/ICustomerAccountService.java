package com.deloitte.telcom.service;

import com.deloitte.telcom.entities.CustomerAccount;

public interface ICustomerAccountService {
	
	CustomerAccount findByMobileNo(String mobileNo);
	
	void rechargeAccount(CustomerAccount c,double amount);
	
	void createAccount(String mobileNo, String name, String accountType, double initialBalance);
	

}
