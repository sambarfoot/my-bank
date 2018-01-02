package com.abc.account.types;

import com.abc.Transaction;
import com.abc.account.AccountAbstract;
import java.util.ArrayList;

public class MaxiSavings extends AccountAbstract {

	public MaxiSavings() {
		 this.transactions = new ArrayList<Transaction>();
	}
	
	@Override
	public double interestEarned() {
		double amount = sumTransactions();
		if (amount <= 1000)
            return amount * 0.02;
		if (amount <= 2000)
            return 20 + ((amount-1000) * 0.05);
		return 70 + (amount-2000) * 0.1;
    }
	
	@Override
	public String printAccountType() {
		return "Maxi Savings Account\n";
	}
	
}
