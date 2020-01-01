package com.deloitte.telcom.ui;

import java.util.Scanner;

import com.deloitte.telcom.dao.CustomerAccountDaoImpl;
import com.deloitte.telcom.entities.CustomerAccount;
import com.deloitte.telcom.exceptions.CustomerAccountNotFoundException;
import com.deloitte.telcom.exceptions.IncorrectMobileNoException;
import com.deloitte.telcom.exceptions.MobileNumberAlreadyExistsException;
import com.deloitte.telcom.service.CustomerAccountServiceImpl;
import com.deloitte.telcom.service.ICustomerAccountService;

public class TelcomUi {
	
	ICustomerAccountService service=new CustomerAccountServiceImpl(new CustomerAccountDaoImpl());
	
	public static void main(String[] args) {
		TelcomUi ui=new TelcomUi();
		ui.runUi();
	}

	private void runUi() {
		
		
		while(true) {
		try {
			System.out.println("\n*****MENU*****");
			System.out.println("1. Account Balance Enquiry.");
			System.out.println("2. Recharge Account.");
			System.out.println("3. Create New Account.");
			System.out.println("4. Exit.");
			System.out.println("Enter your choice:");
			int choice;
			Scanner sc=new Scanner(System.in);
			choice=sc.nextInt();
			
			if(choice==1)
			{
				System.out.println("Enter mobile no:");
				String mobileNo=sc.next();
				CustomerAccount c=service.findByMobileNo(mobileNo);
				System.out.println("Balance:"+c.getBalance());
			}
			else if(choice==2)
			{
				System.out.println("Enter mobile no:");
				String mobileNo=sc.next();
				CustomerAccount c=service.findByMobileNo(mobileNo);
				System.out.println("Enter amount:");
				double amount=sc.nextDouble();
				service.rechargeAccount(c, amount);
				System.out.println(c);
			}
			else if(choice==3)
			{
				System.out.println("Enter your mobile no:");
				String mobileNo=sc.next();
				System.out.println("Enter your name:");
				String name=sc.next();
				System.out.println("Choose account type(prepaid/postpaid):");
				String accountType=sc.next();
				System.out.println("Enter initial balance:");
				double initialBalance=sc.nextDouble();
				service.createAccount(mobileNo, name, accountType, initialBalance);
				System.out.println("New account created successfully.");
				System.out.println(service.findByMobileNo(mobileNo));
			}
			else if(choice==4)
			{
				System.out.println("Do you want to exit? Press 'y' to confirm");
				if(sc.next().equals("y"))
					break;
				
			}
			else {
				System.out.println("Please enter a valid choice.");
			}
		}catch(IncorrectMobileNoException e) {
			System.out.println("Please enter a valid mobile number.");
		}
		catch(CustomerAccountNotFoundException e) {
			System.out.println("Customer account not found for given mobile number.");
		}
		catch(MobileNumberAlreadyExistsException e)
		{
			System.out.println("Mobile number already in use.Try choosing another number.");
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			System.out.println("Something went wrong.");
		}
		}
		
	}

}
