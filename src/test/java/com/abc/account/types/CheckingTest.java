package com.abc.account.types;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.abc.account.Account;

public class CheckingTest {

	private static final double DOUBLE_DELTA = 1e-15;
	
	Account account;
	
	@Before
	public void init() {
		account = new Checking();
		account.deposit(200);
	}
	
	@Test
	public void testInterestEarned() {
		double interest = account.interestEarned();
		assertEquals(0.20009975909411537, interest, DOUBLE_DELTA);
	}

	@Test
	public void testPrintAccountType() {
		assertEquals("Checking Account\n", account.printAccountType());
	}

}
