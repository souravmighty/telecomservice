package com.deloitte.telcom.entities;

public class CustomerAccount {
	private String mobileNo;
	private String name;
	private String accountType;
	private double balance;
	
	public CustomerAccount(String mobileNo, String name, String accountType, double balance) {
		super();
		this.mobileNo = mobileNo;
		this.name = name;
		this.accountType = accountType;
		this.balance = balance;
	}
	
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}
	public void addBalance(double balance) {
		this.balance += balance;
	}

	@Override
	public String toString() {
		return "Account Details [Mobile No=" + mobileNo + ", Name=" + name + ", Account Type=" + accountType + ", Balance="
				+ balance + "]";
	}

	@Override
	public int hashCode() {
		return mobileNo.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
		{
			return true;
		}	
		if (obj == null || !(obj instanceof CustomerAccount))
		{
			return false;
		}
		CustomerAccount c=(CustomerAccount)obj;
		return c.getMobileNo().equals(this.mobileNo);
		
	}
	
	

}
