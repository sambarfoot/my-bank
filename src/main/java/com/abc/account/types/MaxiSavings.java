package com.abc.account.types;

import com.abc.account.AccountAbstract;

public class MaxiSavings extends AccountAbstract {
	
	/**
	 * **Maxi-Savings accounts** to have an interest rate of 5% assuming no withdrawals in the past 10 days otherwise 0.1%
	 */
	@Override
	public double interestEarned() {
		// was there a withdrawal in the last 10 days interest 0.1
		return calculateCompoundInterest(getBalance(), hadWithdrawalInTheLast10Days() ? 0.001 : 0.05);
    }
	
	@Override
	public String printAccountType() {
		return "Maxi Savings Account\n";
	}
	
}
