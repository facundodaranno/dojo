package com.mercadolibre.dojos;

/**
 * Created by fdaranno on 21/2/18.
 */
public class FakeAvailabilityService {

    private Integer availabilityPercentage;

    public FakeAvailabilityService(Integer availabilityPercentage) {
        this.availabilityPercentage = availabilityPercentage;
    }

    public Integer getAvailability(){
        return availabilityPercentage;
    }
}
