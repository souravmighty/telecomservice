package com.deloitte.telcom.dao;

import java.util.Map;

import com.deloitte.telcom.entities.CustomerAccount;

public interface ICustomerAccountDao {
	
	CustomerAccount findByMobileNo(String mobileNo);
	
	void rechargeAccount(CustomerAccount c,double amount);

	
	CustomerAccount createAccount(String mobileNo, String name, String accountType, double initialBalance);

	Map<String, CustomerAccount> getStore();

}
