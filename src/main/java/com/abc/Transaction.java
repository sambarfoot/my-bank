package com.abc;

import java.util.Calendar;
import java.util.Date;

public class Transaction {
    public final double amount;

    private Date transactionDate;

    public Transaction(double amount) {
        this.amount = amount;
        this.setTransactionDate(Calendar.getInstance().getTime());
    }

	/**
	 * @return the transactionDate
	 */
	public Date getTransactionDate() {
		return transactionDate;
	}

	/**
	 * @param transactionDate the transactionDate to set
	 */
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	public boolean wasLessThan10Days() {
		return amount>0 && transactionGreaterThan10DaysAgo();
    }
	
	private boolean transactionGreaterThan10DaysAgo() {
		// date in milliseconds
		long diff = Calendar.getInstance().getTime().getTime() - this.transactionDate.getTime();
		return diff >= (10 * 24 * 60 * 60 * 1000);
	}
	    
}
