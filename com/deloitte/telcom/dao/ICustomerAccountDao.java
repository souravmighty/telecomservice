package com.deloitte.telcom.dao;

import com.deloitte.telcom.entities.CustomerAccount;

public interface ICustomerAccountDao {
	
	CustomerAccount findByMobileNo(String mobileNo);
	
	void rechargeAccount(CustomerAccount c,double amount);

	
	void createAccount(CustomerAccount c);

}
