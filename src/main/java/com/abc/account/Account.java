package com.abc.account;

import java.util.List;

import com.abc.Transaction;

public interface Account {
	
	/**
	 * @return the transactions
	 */
	List<Transaction> getTransactions();
	
	/**
	 * @return the balance
	 */
	int getBalance();
	
	/**
	 * make a deposit to the account
	 */
	void deposit(double amount);
	
	/**
	 * make a withdrawal from the account
	 */
	void withdraw(double amount);
	
	/**
	 * transfer between two account at the bank
	 */
	void transfer(Account account, double amount);
	
	/**
	 * @return a statement for the account, listing all the transactions
	 */
	String statementForAccount();
	
	/**
	 * @return interest earned on the account
	 */
	double interestEarned();
	
	/**
	 * @return account type
	 */
	String printAccountType(); 
}
