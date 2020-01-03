package com.deloitte.telcom.service;

import java.util.Map;

import javax.security.auth.login.AccountException;

import org.junit.*;

import com.deloitte.telcom.dao.CustomerAccountDaoImpl;
import com.deloitte.telcom.entities.CustomerAccount;
import com.deloitte.telcom.exceptions.IncorrectMobileNoException;

public class CustomerAccountServiceImplTest {
	
	@Test
	public void testCreateAccount_1()
	{
		CustomerAccountServiceImpl service=new CustomerAccountServiceImpl(new CustomerAccountDaoImpl());
		String mobileNo="1234567890";
		double balance=1000;
		String name="satya";
		String accountType="prepaid";
		CustomerAccount account=service.createAccount(mobileNo, name, accountType, balance);
		Assert.assertNotNull(account);
		double resultBalance=account.getBalance();
		Assert.assertEquals(balance, resultBalance,0);
		Assert.assertEquals(name, account.getName());
		Map<String,CustomerAccount>store=service.getDao().getStore();
		CustomerAccount expected=store.get(mobileNo);
		Assert.assertEquals(expected, account);
	}
	
	@Test(expected=IncorrectMobileNoException.class)
	public void testCreateAccount_2()
	{
		CustomerAccountServiceImpl service=new CustomerAccountServiceImpl(new CustomerAccountDaoImpl());
		String mobileNo=null;
		double balance=1000;
		String name="satya";
		String accountType="prepaid";
		CustomerAccount account=service.createAccount(mobileNo, name, accountType, balance);
	}
	
	@Test
	public void testFindByMobileNo_1()
	{
		CustomerAccountServiceImpl service=new CustomerAccountServiceImpl(new CustomerAccountDaoImpl());
		String mobileNo="1234567890";
		double balance=1000;
		String name="satya";
		String accountType="prepaid";
		CustomerAccount account=service.createAccount(mobileNo, name, accountType, balance);
		Map<String,CustomerAccount>store=service.getDao().getStore();
		store.put(mobileNo, account);
		CustomerAccount result=service.findByMobileNo(mobileNo);
		CustomerAccount expected=store.get(mobileNo);
		Assert.assertEquals(expected, result);
	}

}
