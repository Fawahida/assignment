package com.cg.service;

import com.cg.beans.Account;
import com.cg.exceptions.Insufficient_Balance_Exception;
import com.cg.exceptions.Insufficient_Opening_Balance;
import com.cg.exceptions.Invalid_Account_Number_Exception;

public interface Service_interface 
{
	public Account creatAccount(int AccountNumber, String Name, double Amount) throws Invalid_Account_Number_Exception, Insufficient_Opening_Balance;
	public Account depositAmount(int AccountNumber, int value) throws Invalid_Account_Number_Exception ; 
	public Account withdrawAmount(int AccountNumber, int value ) throws Invalid_Account_Number_Exception, Insufficient_Balance_Exception ;
	public Account fundTransfer(int from, int to , int value ) throws Invalid_Account_Number_Exception,Insufficient_Balance_Exception ;

}
