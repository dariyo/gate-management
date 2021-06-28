package com.airport.gatemanagement.util;


import java.util.Calendar;
import java.util.Date;




public class TimeUtil {


    public static final int MINUTES_DIV = ( 60 * 1000 );


    public static int calculatePassedTimeInMinutes() {
        final Date startOfDay = getStartOfDay();
        final Date time = new Date();
        final long passedTime = time.getTime() - startOfDay.getTime();

        return (int) (passedTime / MINUTES_DIV);
    }


    private static Date getStartOfDay() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        calendar.set(year, month, day, 0, 0, 0);
        return calendar.getTime();
    }

}
