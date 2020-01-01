package com.deloitte.telcom.service;

import com.deloitte.telcom.dao.ICustomerAccountDao;
import com.deloitte.telcom.entities.CustomerAccount;
import com.deloitte.telcom.exceptions.IncorrectMobileNoException;
import com.deloitte.telcom.exceptions.MobileNumberAlreadyExistsException;

public class CustomerAccountServiceImpl implements ICustomerAccountService {
	
	ICustomerAccountDao dao;
	

	public CustomerAccountServiceImpl(ICustomerAccountDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public CustomerAccount findByMobileNo(String mobileNo) {
		if(mobileNo.length()!=10 || mobileNo==null)
		{
			throw new IncorrectMobileNoException("Incorrect Mobile No.");
		}
		return dao.findByMobileNo(mobileNo);
	}

	@Override
	public void rechargeAccount(CustomerAccount c, double amount) {
		dao.rechargeAccount(c, amount);
		
	}

	@Override
	public void createAccount(String mobileNo, String name, String accountType, double initialBalance) {
		CustomerAccount c=new CustomerAccount(mobileNo, name, accountType, initialBalance);
		dao.createAccount(c);
	}
	

}
