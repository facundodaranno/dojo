package com.mercadolibre.dojos;

/**
 * Created by fdaranno on 16/11/17.
 */
public class Biscuit {

    private Weight weight;

    public Biscuit(){
        this.weight = new Weight(10);
    }

    public void incrementWeight(Weight weight) {
        weight.add(this.weight);
    }
}
