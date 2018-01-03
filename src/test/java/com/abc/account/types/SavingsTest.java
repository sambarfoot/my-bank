package com.abc.account.types;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.abc.account.Account;

public class SavingsTest {

	private static final double DOUBLE_DELTA = 1e-15;
	
	Account account;
	
	@Before
	public void init() {
		account = new Savings();
		account.deposit(200);
	}
	
	@Test
	public void testInterestEarnedUnder1000() {
		double interest = account.interestEarned();
		assertEquals(0.20009975909411537, interest, DOUBLE_DELTA);
	}
	
	@Test
	public void testInterestEarnedOver1000() {
		account.deposit(1000);
		double interest = account.interestEarned();
		assertEquals(1.400399168716973, interest, DOUBLE_DELTA);
	}

	@Test
	public void testPrintAccountType() {
		assertEquals("Savings Account\n", account.printAccountType());
	}

}
