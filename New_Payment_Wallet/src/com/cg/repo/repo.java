package com.cg.repo;

import java.util.HashMap;
import java.util.Map;

import com.cg.beans.Account;
import com.cg.exceptions.Invalid_Account_Number_Exception;


public class repo implements repo_interfaces
{
	
	private HashMap<Integer,Account> accountList;

	public repo(HashMap<Integer,Account> accountList) {
		this.accountList = accountList;
	}
	@Override
	public Account save(Account account) {
		accountList.put(account.getAccountNumber(),account);
		return account;
	}

	@Override
	public Account findByAccountNumber(int accountNumber) throws Invalid_Account_Number_Exception {
		Account acc = null;
		for(Integer ac : accountList.keySet()) {
			if(ac == accountNumber) {
				acc = accountList.get(ac);
//				System.out.println(acc);
			}
		}
		if(acc == null) {
			throw new Invalid_Account_Number_Exception("Account does not exist!");
		}
		return acc;
	}

	
}
