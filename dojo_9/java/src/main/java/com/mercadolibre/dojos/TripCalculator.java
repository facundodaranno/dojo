package com.mercadolibre.dojos;

import com.mercadolibre.dojos.TripCostRules.AbstractTripCostRule;
import com.mercadolibre.dojos.TripCostRules.OneWeekBeforeEarning;
import com.mercadolibre.dojos.TripCostRules.TwoWeekBeforeEarning;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mkamien on 1/24/18.
 */
public class TripCalculator {

    List<AbstractTripCostRule> tripCostRuleList;
    FakeAvailabilityService availabilityService;

    TripCalculator(){
        init();
        this.availabilityService = new FakeAvailabilityService(0);
    }

    public TripCalculator(FakeAvailabilityService fakeAvailabilityService) {
        init();
        this.availabilityService = fakeAvailabilityService;
    }

    private void init() {
        List list = new ArrayList<AbstractTripCostRule>();
        list.add( new OneWeekBeforeEarning());
        list.add( new TwoWeekBeforeEarning());
        this.tripCostRuleList = list;
    }

    public Price calculate(Trip trip, TripDate inquiryDate) {
        Integer daysBetweenTodayAndTripDate = trip.daysToDeparture(inquiryDate);

        Price finalCost = this.calculateEarning(trip.getTotalCost(), daysBetweenTodayAndTripDate);

        return finalCost;
    }

    private Price calculateEarning(Price tripCost, Integer daysBetweenTodayAndTripDate) {

        for (AbstractTripCostRule iterator : tripCostRuleList) {
            tripCost = iterator.earning(daysBetweenTodayAndTripDate,tripCost);
        }

        return tripCost;
    }

}
