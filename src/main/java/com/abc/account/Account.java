package com.abc.account;

import java.util.List;

import com.abc.Transaction;

public interface Account {
	
	List<Transaction> getTransactions();
	
	void deposit(double amount);
	
	void withdraw(double amount);
	
	double sumTransactions();
	
	double interestEarned();
	
	String printAccountType(); 
}
