package com.abc.account.types;

import com.abc.account.AccountAbstract;
import com.abc.constants.Constants;

public class MaxiSavings extends AccountAbstract {
	
	@Override
	public double interestEarned() {
		
		double amount = sumTransactions();
		
		// was there a withdrawal in the last 10 days interest 0.1
		if (hadWithdrawlInTheLast10Days())
			return calculateCompoundInterest(amount, 0.001);
		return calculateCompoundInterest(amount, 0.05);
    }

// old interest rates
//	public double interestEarned() {
//		double amount = sumTransactions();
//		if (amount <= 1000)
//            return amount * 0.02;
//		if (amount <= 2000)
//            return 20 + ((amount-1000) * 0.05);
//		return 70 + (amount-2000) * 0.1;
//    }
	
	@Override
	public String printAccountType() {
		return "Maxi Savings Account\n";
	}
	
}
