package com.abc.account.types;

import com.abc.Transaction;
import com.abc.account.AccountAbstract;
import java.util.ArrayList;

public class Checking extends AccountAbstract {

	public Checking() {
		 this.transactions = new ArrayList<Transaction>();
	}
	
	@Override
	public double interestEarned() {
		double amount = sumTransactions();
		return amount * 0.001;
    }
	
	@Override
	public String printAccountType() {
		return "Checking Account\n";
	}
	
}
