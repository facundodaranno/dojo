package com.mercadolibre.dojos;

/**
 * Created by fdaranno on 17/10/17.
 */
public class Congrats {

    private Order order;

    public Congrats(Order order) {
        this.order = order;
    }

    public String asJson() {
        return order.getHeaderAsJson();
    }
}
