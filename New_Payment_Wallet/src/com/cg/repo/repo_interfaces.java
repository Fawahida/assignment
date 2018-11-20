package com.cg.repo;

import com.cg.beans.Account;
import com.cg.exceptions.Invalid_Account_Number_Exception;

public interface repo_interfaces 
{
	
		public Account save(Account account) ;
		
		public Account findByAccountNumber( int accountNumber) throws Invalid_Account_Number_Exception;

	

}
