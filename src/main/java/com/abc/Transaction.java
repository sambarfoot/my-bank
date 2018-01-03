package com.abc;

import java.util.Calendar;
import java.util.Date;

import com.abc.constants.Constants;

/**
 * @author Samuel.Barfoot
 *
 */
public class Transaction {
    private final double amount;
    private Date transactionDate;
    
    /**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

    public Transaction(double amount) {
        this.amount = amount;
        this.transactionDate = Calendar.getInstance().getTime();
    }

	/**
	 * @return the transaction date
	 */
	public Date getTransactionDate() {
		return transactionDate;
	}
	
	/**
	 * @return true if the transaction took place in the last 10 days and it was a withdrawal
	 */
	public boolean wasWithdrawnFromWithinLast10Days() {
		return amount>0 && transactionDateLessThan10DaysAgo();
    }
	
	/**
	 * @return true if the transaction took place in the last 10 days
	 */
	private boolean transactionDateLessThan10DaysAgo() {
		// date in milliseconds
		long diff = Calendar.getInstance().getTime().getTime() - this.transactionDate.getTime();
		
		return diff <= Constants.TEN_DAYS_IN_MILLISECONDS;
	}
	    
}
