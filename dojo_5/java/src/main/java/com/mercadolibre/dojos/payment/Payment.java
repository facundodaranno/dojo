package com.mercadolibre.dojos.payment;

import com.mercadolibre.dojos.interfaces.Headerable;
import com.mercadolibre.dojos.shipping.Shipping;

/**
 * Created by fdaranno on 19/10/17.
 */
public interface Payment {

    Headerable challenge(Shipping shipping);
}
