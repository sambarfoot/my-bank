package com.abc.functional;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import com.abc.Transaction;

public class TransactionTest {

	private static final double DOUBLE_DELTA = 1e-15;
	
	@Test
    public void testDepositTransaction() {
        Transaction t = new Transaction(5);
        assertTrue(t instanceof Transaction);
        assertEquals(5, t.amount, DOUBLE_DELTA);
    }
	
	public void testWithdrawlTransaction() {
		Transaction t = new Transaction(-5);
        assertTrue(t instanceof Transaction);
        assertEquals(-5, t.amount, DOUBLE_DELTA);
	}
    
    @Test
    public void testWasLessThan10Days() {
    	Transaction t = new Transaction(5);
    	
    	Calendar calendar = Calendar.getInstance();
    	calendar.add(Calendar.DATE, -5);
    	
    	t.setTransactionDate(calendar.getTime());
    	assertTrue(t.wasWithdrawlAndLessThan10Days());
    }
    
    @Test
    public void testWasGreaterThan10Days() {
    	Transaction t = new Transaction(5);
    	
    	Calendar calendar = Calendar.getInstance();
    	calendar.add(Calendar.DATE, -15);  	
    	
    	t.setTransactionDate(calendar.getTime());
    	assertFalse(t.wasWithdrawlAndLessThan10Days());
    }
}
