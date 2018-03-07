package com.mercadolibre.dojos.TripCostRules;

import com.mercadolibre.dojos.Price;
import com.mercadolibre.dojos.TripDate;

/**
 * Created by fdaranno on 7/2/18.
 */
public class TwoWeekBeforeEarning extends AbstractTripCostRule{

    protected Boolean apply(Integer daysBetweenTodayAndTripDate) {
        return daysBetweenTodayAndTripDate <= 15 && daysBetweenTodayAndTripDate > 7 ;
    }

    protected Price earning(Price tripCost) {
        return tripCost.addPercentage(10);
    }
}
