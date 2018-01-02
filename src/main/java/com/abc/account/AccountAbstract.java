package com.abc.account;

import com.abc.Transaction;

import java.util.List;

public abstract class AccountAbstract implements Account {	

	public List<Transaction> transactions;
	
	public List<Transaction> getTransactions() {
		return this.transactions;
	}
	
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be greater than zero");
        } else {
            transactions.add(new Transaction(amount));
        }
    }

	public void withdraw(double amount) {
	    if (amount <= 0) {
	        throw new IllegalArgumentException("amount must be greater than zero");
	    } else {
	        transactions.add(new Transaction(-amount));
	    }
	}
	
	public double sumTransactions() {
		double amount = 0.0;
        for (Transaction t: transactions)
            amount += t.amount;
        return amount;
    }
	
	

}
