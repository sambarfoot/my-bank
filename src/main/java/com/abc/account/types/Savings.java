package com.abc.account.types;

import com.abc.account.AccountAbstract;
import com.abc.constants.Constants;

public class Savings extends AccountAbstract {
	
	@Override
	public double interestEarned() {
		double amount = sumTransactions();
		if (amount <= 1000)
            return calculateCompoundInterest(amount, 0.001);
        else
            return 1 + (calculateCompoundInterest(amount-1000, 0.002));
    }

// old interest calculation
//	public double interestEarned() {
//		double amount = sumTransactions();
//		if (amount <= 1000)
//            return amount * 0.001;
//        else
//            return 1 + ((amount-1000) * 0.002);
//    }

	@Override
	public String printAccountType() {
		return "Savings Account\n";
	}
}
