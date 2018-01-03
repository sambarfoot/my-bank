package com.abc;

import java.util.Calendar;
import java.util.Date;

public class DateProvider {
    private static DateProvider instance = null;

    /**
	 * @return instance of date provider
	 */
    public static DateProvider getInstance() {
        if (instance == null)
            instance = new DateProvider();
        return instance;
    }

    /**
	 * @return return the current date 
	 */
    public Date now() {
        return Calendar.getInstance().getTime();
    }
}
