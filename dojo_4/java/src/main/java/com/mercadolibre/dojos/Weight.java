package com.mercadolibre.dojos;

/**
 * Created by fdaranno on 16/11/17.
 */
public class Weight  implements Cloneable{

    private Integer weight;

    public Weight(Integer weight) {
        this.weight = weight;
    }

    public Weight(Weight weight) {
        this.weight = weight.weight;
    }

    public void add(Weight weight) {
        this.weight += weight.weight;
    }

    public void multiply(Integer multiplexer) {
        this.weight *= multiplexer;
    }

    public boolean isGretterThan(Weight weight) {
        return  this.weight > weight.weight ;
    }

    public boolean isDoubleThan(Weight weight) {
        return  (this.weight  / 2 ) == weight.weight;
    }
}
