package com.abc;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

public class TransactionTest {

	private static final double DOUBLE_DELTA = 1e-15;
	
	@Test
    public void testTransaction() {
        Transaction t = new Transaction(5);
        assertTrue(t instanceof Transaction);
        assertEquals(5, t.amount, DOUBLE_DELTA);
    }
    
    @Test
    public void testWasLessThan10Days() {
    	Transaction t = new Transaction(5);
    	
    	Calendar calendar = Calendar.getInstance();
    	calendar.add(Calendar.DATE, -5);  	
    	
    	t.setTransactionDate(calendar.getTime());
    	assertTrue(t.wasLessThan10Days());
   
    }
}
