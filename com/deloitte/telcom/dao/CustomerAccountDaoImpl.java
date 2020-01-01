package com.deloitte.telcom.dao;

import java.util.*;

import com.deloitte.telcom.entities.CustomerAccount;
import com.deloitte.telcom.exceptions.CustomerAccountNotFoundException;

public class CustomerAccountDaoImpl implements ICustomerAccountDao{
	
	Map<String,CustomerAccount> store=new HashMap<>();

	@Override
	public CustomerAccount findByMobileNo(String mobileNo) {
		CustomerAccount c=store.get(mobileNo);
		if(c==null)
		{
			throw new CustomerAccountNotFoundException("Account not found for mobile no="+mobileNo);
		}
		return c;
	}

	@Override
	public void rechargeAccount(CustomerAccount c, double amount) {
		
		c.addBalance(amount);
		
	}

	@Override
	public void createAccount(CustomerAccount c) {
		store.put(c.getMobileNo(), c);
		
	}

}
