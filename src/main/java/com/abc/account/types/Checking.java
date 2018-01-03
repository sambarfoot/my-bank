package com.abc.account.types;

import com.abc.account.AccountAbstract;
import com.abc.constants.Constants;

public class Checking extends AccountAbstract {
		
	@Override
	public double interestEarned() {
		double amount = sumTransactions();
		return calculateCompoundInterest(amount, 0.001);
    }

// old interest calculation
//	public double interestEarned() {
//		double amount = sumTransactions();
//		return amount * 0.001;
//    }
	
	@Override
	public String printAccountType() {
		return "Checking Account\n";
	}
	
}
