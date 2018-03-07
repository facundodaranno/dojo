package com.mercadolibre.dojos.TripCostRules;

import com.mercadolibre.dojos.Price;
import com.mercadolibre.dojos.TripDate;

/**
 * Created by fdaranno on 7/2/18.
 */
public class OneWeekBeforeEarning extends AbstractTripCostRule {

    @Override
    protected Boolean apply(Integer daysBetweenTodayAndTripDate) {
        return daysBetweenTodayAndTripDate <= 7;
    }

    @Override
    protected Price earning(Price tripCost) {
        Price oneWeekBeforeEarning = new Price(100);
        return tripCost.addValue( oneWeekBeforeEarning );
    }
}
