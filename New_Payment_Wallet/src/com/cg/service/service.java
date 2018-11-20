package com.cg.service;

import com.cg.beans.Account;
import com.cg.exceptions.Insufficient_Balance_Exception;
import com.cg.exceptions.Insufficient_Opening_Balance;
import com.cg.exceptions.Invalid_Account_Number_Exception;
import com.cg.repo.repo_interfaces;

public class service implements Service_interface
{
	private repo_interfaces repository;
	
	public service (repo_interfaces repository)
	{
		super();
		this.repository = repository;
	}

	@Override
	public Account creatAccount(int AccountNumber, String Name, double Amount)
			throws Invalid_Account_Number_Exception, Insufficient_Opening_Balance {
		
		String acountStr = String.valueOf(AccountNumber);
		
		if(acountStr == null || acountStr.length() < 4 || acountStr.equals(""))
		{
			throw new Invalid_Account_Number_Exception("Please ensure that valid account number is entered");
		}

		if(Amount < 0)
		{
			throw new Insufficient_Opening_Balance("Insufficient ammount for opening account!");
		}
		Account acc = new Account(AccountNumber, Name, Amount);
		repository.save(acc);
		return acc;
	}

	@Override
	public Account depositAmount(int AccountNumber, int value) throws Invalid_Account_Number_Exception {
		String acountStr = String.valueOf(AccountNumber);
		if(acountStr == null || acountStr.length() < 4 || acountStr.equals(""))
		{
			throw new Invalid_Account_Number_Exception("Please ensure that valid account number is entered");
		}

		Account acc = repository.findByAccountNumber(AccountNumber);
		acc.setAmount(acc.getAmount() + value);
		return acc;

	}

	@Override
	public Account withdrawAmount(int AccountNumber, int value)
			throws Invalid_Account_Number_Exception, Insufficient_Balance_Exception {
		String acountStr = String.valueOf(AccountNumber);
		if(acountStr == null || acountStr.length() < 4 || acountStr.equals(""))
		{
			throw new Invalid_Account_Number_Exception("Please ensure that valid account number is entered");
		}
	
		Account acc = repository.findByAccountNumber(AccountNumber);
		if(acc.getAmount() < value) {
			throw new Insufficient_Balance_Exception("Insufficient Balance to do withdrawal");
		}
		acc.setAmount(acc.getAmount() - value);
		return acc;

	}

	@Override
	public Account fundTransfer(int from, int to, int value)
			throws Invalid_Account_Number_Exception, Insufficient_Balance_Exception {
		String acountFromStr = String.valueOf(from);
		String acountToStr = String.valueOf(to);
		if(acountFromStr == null || acountFromStr.length() < 4 || acountFromStr.equals("")) {
			throw new Invalid_Account_Number_Exception("Please ensure that Sender's account number is valid");
		}
		if(acountToStr == null || acountToStr.length() < 4 || acountToStr.equals("")) {
			throw new Invalid_Account_Number_Exception("Please ensure that recepient's account number is valid");
		}

		Account accFrom = repository.findByAccountNumber(from);
		Account accTo = repository.findByAccountNumber(to);
		if(accFrom.getAmount() < value) {
			throw new Insufficient_Balance_Exception("Insufficient Balance to do transfer");
		}

		accFrom.setAmount(accFrom.getAmount() - value);
		accTo.setAmount(accTo.getAmount() + value);
		System.out.println(accTo.toString());
		return accFrom;
	}


}
