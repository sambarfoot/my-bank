package com.abc.account.types;

import com.abc.Transaction;
import com.abc.account.AccountAbstract;
import java.util.ArrayList;

public class Savings extends AccountAbstract {

	public Savings() {
		 this.transactions = new ArrayList<Transaction>();
	}
	
	@Override
	public double interestEarned() {
		double amount = sumTransactions();
		if (amount <= 1000)
            return amount * 0.001;
        else
            return 1 + ((amount-1000) * 0.002);
    }

	@Override
	public String printAccountType() {
		return "Savings Account\n";
	}
}
