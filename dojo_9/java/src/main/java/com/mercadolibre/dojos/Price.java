package com.mercadolibre.dojos;

/**
 * Created by mkamien on 1/24/18.
 */
public class Price {

    private Integer price;

    public Price(Integer price) {
        this.price = price;
    }

    public Price(Price otherPrice) {
        this.price = otherPrice.price;
    }

    public boolean equals(Object another){
        Price anotherPrice = (Price) another;
        return this.price.equals(anotherPrice.price);
    }

    public Price addValue(Price otherPrice) {
        return new Price(this.price + otherPrice.price);
    }

    public Price addPercentage(int percentage) {
        return new Price( this.price + this.price*percentage/100);
    }
}
