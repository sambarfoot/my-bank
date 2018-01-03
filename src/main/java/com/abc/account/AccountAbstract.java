package com.abc.account;

import com.abc.Transaction;
import com.abc.constants.Constants;

import static java.lang.Math.abs;

import java.util.ArrayList;
import java.util.List;

public abstract class AccountAbstract implements Account {	

	private List<Transaction> transactions;
	private int balance;
	
	public AccountAbstract() {
		transactions = new ArrayList<Transaction>();
	}
	
	@Override
	public List<Transaction> getTransactions() {
		return this.transactions;
	}

	@Override
	public int getBalance() {
		return this.balance;
	}

	@Override
    public void deposit(double amount) {
        validateAmount(amount);
        
        transactions.add(new Transaction(amount));
        this.balance+=amount;
    }

	@Override
	public void withdraw(double amount) {
	    validateAmount(amount);
	    
    	if (this.balance < amount) 
    		throw new IllegalArgumentException(Constants.ERROR_INSUFFICIENT_FUNDS);
    	
    	transactions.add(new Transaction(-amount));
    	this.balance-=amount;
	    
	}
	
	private void validateAmount(double amount) {
		if (amount <= 0)
	        throw new IllegalArgumentException(Constants.ERROR_AMOUNT_LESS_ZERO);
		if (amount%0.01 < 0)
	    	throw new IllegalArgumentException(Constants.ERROR_AMOUNT_NOT_TWO_DP);
	}
	
	@Override
	public void transfer(Account account, double amount) {
		this.withdraw(amount);
		account.deposit(amount);
	}
	
	@Override
	public String statementForAccount() {
        String s = printAccountType();

        for (Transaction t : getTransactions()) {
            s += "  " + (t.getAmount() < 0 ? "withdrawal" : "deposit") + " " + toDollars(t.getAmount()) + "\n";
        }
        s += "Total " + toDollars(balance);
        return s;
    }

	/**
	 * @return formats a double to dollars string
	 */
    private String toDollars(double d){
        return String.format("$%,.2f", abs(d));
    }
	
    /**
	 * @return true if an amount has been withdrawn in the last 10 days
	 */
	protected boolean hadWithdrawalInTheLast10Days() {
		for (Transaction t: transactions)
			if(t.wasWithdrawnFromWithinLast10Days())
				return true;
		return false;
	}
	
	/**
	 * @return calculated compound interest
	 */
	protected double calculateCompoundInterest(double amount, double rate) {
		return (amount * Math.pow((1 + rate/Constants.DAYS_IN_YEAR),Constants.DAYS_IN_YEAR)) - amount;
	}
}
