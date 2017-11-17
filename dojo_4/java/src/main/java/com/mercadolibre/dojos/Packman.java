package com.mercadolibre.dojos;

/**
 * Created by fdaranno on 16/11/17.
 */
public class Packman {

    private Weight weight;

    public Packman(){
        this.weight = new Weight(1);
    }

    public Weight getWeight() {
        return new Weight( weight );
    }

    public void eat(Biscuit biscuit) {
        biscuit.incrementWeight( this.weight );
    }

    public void eat(Cherry cherry) {
        cherry.incrementWeight( this.weight );
    }

    public boolean isFatterThan(Weight packmanWeight) {
        return weight.isGretterThan(packmanWeight);
    }

    public boolean isDoubleThan(Weight weight) {
        return this.weight.isDoubleThan(weight);
    }
}
