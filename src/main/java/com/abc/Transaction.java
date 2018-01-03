package com.abc;

import java.util.Calendar;
import java.util.Date;

import com.abc.constants.Constants;

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
	
	public boolean wasWithdrawlAndLessThan10Days() {
		return amount>0 && transactionDateLessThan10DaysAgo();
    }
	
	private boolean transactionDateLessThan10DaysAgo() {
		// date in milliseconds
		long diff = Calendar.getInstance().getTime().getTime() - this.transactionDate.getTime();
		
		return diff <= Constants.TEN_DAYS_IN_MILLISECONDS;
	}
	    
}
