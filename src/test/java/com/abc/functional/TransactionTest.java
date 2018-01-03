package com.abc.functional;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.Calendar;

import org.junit.Test;

import com.abc.Transaction;

public class TransactionTest {

	private static final double DOUBLE_DELTA = 1e-15;
	
	@Test
    public void testDepositTransaction() {
        Transaction t = new Transaction(5);
        assertTrue(t instanceof Transaction);
        assertEquals(5, t.getAmount(), DOUBLE_DELTA);
    }
	
	public void testWithdrawlTransaction() {
		Transaction t = new Transaction(-5);
        assertTrue(t instanceof Transaction);
        assertEquals(-5, t.getAmount(), DOUBLE_DELTA);
	}
    
    @Test
    public void testWasLessThan10Days() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
    	Transaction t = new Transaction(5);
    	
    	Calendar calendar = Calendar.getInstance();
    	calendar.add(Calendar.DATE, -5);
    	
    	Field field = Transaction.class.getDeclaredField("transactionDate");
    	field.setAccessible(true);
		field.set(t, calendar.getTime());
    	
    	assertTrue(t.wasWithdrawnFromWithinLast10Days());
    }
    
    @Test
    public void testWasGreaterThan10Days() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
    	Transaction t = new Transaction(5);
    	
    	Calendar calendar = Calendar.getInstance();
    	calendar.add(Calendar.DATE, -15);  
    	
    	Field field = Transaction.class.getDeclaredField("transactionDate");
    	field.setAccessible(true);
		field.set(t, calendar.getTime());
    	
    	assertFalse(t.wasWithdrawnFromWithinLast10Days());
    }
}
