package com.mercadolibre.dojos.TripCostRules;

import com.mercadolibre.dojos.Price;

/**
 * Created by fdaranno on 7/2/18.
 */
public abstract class AbstractTripCostRule{

    protected abstract Boolean apply(Integer daysBetweenTodayAndTripDate);
    protected abstract Price earning(Price tripCost);

    public Price earning(Integer daysBetweenTodayAndTripDate, Price tripCost) {
        return apply(daysBetweenTodayAndTripDate) ? earning(tripCost) : tripCost;
    }
}
