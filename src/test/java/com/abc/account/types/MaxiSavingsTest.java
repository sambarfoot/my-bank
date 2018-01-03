package com.abc.account.types;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.abc.Transaction;
import com.abc.account.Account;

public class MaxiSavingsTest {

	private static final double DOUBLE_DELTA = 1e-15;
	
	Account account;
	
	@Before
	public void init() {
		account = new MaxiSavings();		
	}
	
	@Test
	public void testInterestEarnedTransactionLess10Days() {
		account.deposit(300);
		double interest = account.interestEarned();
		assertEquals(0.30014963864118727, interest, DOUBLE_DELTA);
	}
	
	@Test
	public void testInterestEarnedTransactionover10Days() {
		account.deposit(300);
		List<Transaction> transactions = account.getTransactions();
		Transaction transaction = transactions.get(0);
		
		Calendar calendar = Calendar.getInstance();
    	calendar.add(Calendar.DATE, -15);  	
		transaction.setTransactionDate(calendar.getTime());
		
		double interest = account.interestEarned();
		assertEquals(15.380248940234196, interest, DOUBLE_DELTA);
	}

	@Test
	public void testPrintAccountType() {
		assertEquals("Maxi Savings Account\n", account.printAccountType());
	}

}
