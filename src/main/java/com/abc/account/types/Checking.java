package com.abc.account.types;

import com.abc.account.AccountAbstract;
import com.abc.constants.Constants;

public class Checking extends AccountAbstract {
	
	/**
	 * **Checking accounts** have a flat rate of 0.1%
	 */
	@Override
	public double interestEarned() {
		return calculateCompoundInterest(getBalance(), 0.001);
    }
	
	@Override
	public String printAccountType() {
		return "Checking Account\n";
	}
	
}
