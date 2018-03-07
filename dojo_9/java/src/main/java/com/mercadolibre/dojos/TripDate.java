package com.mercadolibre.dojos;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by mkamien on 1/24/18.
 */
public class TripDate {

    private Date date;

    public TripDate(int day, int month, int year) {
        this.date = new Date(year, month, day);
    }

    public Integer calculateDaysDistance(TripDate date) {
        long startTime = this.date.getTime();
        long endTime = date.date.getTime();
        long diffTime = Math.abs(endTime - startTime);
        return (int) TimeUnit.DAYS.convert(diffTime, TimeUnit.MILLISECONDS);
    }
}
