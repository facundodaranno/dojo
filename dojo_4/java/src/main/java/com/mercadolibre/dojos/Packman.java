package com.mercadolibre.dojos;

/**
 * Created by fdaranno on 16/11/17.
 */
public class Packman {

    private Weight weight;

    public Packman(){
        weight = new Weight(1);
    }

    public Weight getWeight() {
        return new Weight( weight );
    }

    public void eat(Biscuit biscuit) {
        biscuit.incrementWeight( weight );
    }

    public void eat(Cherry cherry) {
        cherry.incrementWeight( weight );
    }

    public boolean isFatterThan(Weight weightToCompare) {
        return weight.isGretterThan(weightToCompare);
    }

    public boolean isDoubleThan(Weight weightToCompare) {
        return weight.isDoubleThan(weightToCompare);
    }
}
