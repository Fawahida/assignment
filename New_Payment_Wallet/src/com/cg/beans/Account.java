package com.cg.beans;

public class Account {
	
	private int AccountNumber;
	private String Name;
	private double Amount;
	


	public Account(int accountNumber, String name, double amount) {
		super();
		this.AccountNumber = accountNumber;
		this.Name = name;
		this.Amount = amount;
	}

	public int getAccountNumber() {
		return AccountNumber;
	}
	
	public void setAccountNumber(int accountNumber) {
		AccountNumber = accountNumber;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
	
	public double getAmount() {
		return Amount;
	}
	
	public void setAmount(double amount) {
		this.Amount = amount;
	}

	@Override
	public String toString() {
		return "Account [AccountNumber=" + AccountNumber + ", Name=" + Name + ", Amount=" + Amount + "]";
	}





	
	
	

}
