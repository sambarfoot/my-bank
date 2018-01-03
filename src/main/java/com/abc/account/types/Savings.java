package com.abc.account.types;

import com.abc.account.AccountAbstract;
import com.abc.constants.Constants;

public class Savings extends AccountAbstract {
	
	/**
	 * **Savings accounts** have a rate of 0.1% for the first $1,000 then 0.2%
	 */
	@Override
	public double interestEarned() {
		double amount = getBalance();
		if (amount <= 1000)
            return calculateCompoundInterest(amount, 0.001);
        return 1 + (calculateCompoundInterest(amount-1000, 0.002));
    }

	@Override
	public String printAccountType() {
		return "Savings Account\n";
	}

}
