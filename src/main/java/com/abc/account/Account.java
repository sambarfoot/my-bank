package com.abc.account;

import java.util.List;

import com.abc.Transaction;

public interface Account {
	
	List<Transaction> getTransactions();
	
	void deposit(double amount);
	
	void withdraw(double amount);
	
	void transfer(Account account, double amount);
	
	double interestEarned();
	
	double sumTransactions();
	
	String printAccountType(); 
}
