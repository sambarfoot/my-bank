package com.abc.account;

import com.abc.Transaction;
import com.abc.constants.Constants;

import java.util.ArrayList;
import java.util.List;

public abstract class AccountAbstract implements Account {	

	private List<Transaction> transactions;
	
	public AccountAbstract() {
		transactions = new ArrayList<Transaction>();
	}
	
	@Override
	public List<Transaction> getTransactions() {
		return this.transactions;
	}
	
	@Override
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be greater than zero");
        } else {
            transactions.add(new Transaction(amount));
        }
    }

	@Override
	public void withdraw(double amount) {
	    if (amount <= 0) {
	        throw new IllegalArgumentException("amount must be greater than zero");
	    } else {
	    	if (sumTransactions()-amount < 0) 
	    		throw new IllegalArgumentException("account cannot go overdrawn");
	    	transactions.add(new Transaction(-amount));
	    }
	}
	
	@Override
	public void transfer(Account account, double amount) {
		this.withdraw(amount);
		account.deposit(amount);
	}
	
	@Override
	public double sumTransactions() {
		double amount = 0.0;
        for (Transaction t: transactions)
            amount += t.amount;
        return amount;
    }
	
	protected boolean hadWithdrawlInTheLast10Days() {
		for (Transaction t: transactions)
			if(t.wasWithdrawlAndLessThan10Days())
				return true;
		return false;
	}
	
	protected double calculateCompoundInterest(double amount, double rate) {
		return (amount * Math.pow((1 + rate/Constants.DAYS_IN_YEAR),Constants.DAYS_IN_YEAR)) - amount;
	}
}
