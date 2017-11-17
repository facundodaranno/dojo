package com.mercadolibre.dojos;

/**
 * Created by fdaranno on 16/11/17.
 */
public class Weight  implements Cloneable{

    private Integer weight;

    public Weight(Integer weightToAssign) {
        weight = weightToAssign;
    }

    public Weight(Weight weightObjectToCopy) {
        weight = weightObjectToCopy.weight;
    }

    public void add(Weight weightToAdd) {
        weight += weightToAdd.weight;
    }

    public void multiply(Integer multiplexer) {
        this.weight *= multiplexer;
    }

    public boolean isGretterThan(Weight weightToCompare) {
        return  weight > weightToCompare.weight ;
    }

    public boolean isDoubleThan(Weight weightToCompare) {
        return  ( weight  / 2 ) == weightToCompare.weight;
    }
}
