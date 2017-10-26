package com.mercadolibre.dojos.payment;

import com.google.gson.JsonObject;
import com.mercadolibre.dojos.interfaces.Headerable;
import com.mercadolibre.dojos.shipping.Shipping;

/**
 * Created by fdaranno on 26/10/17.
 */
public class AgreementPayment implements Payment, Headerable {
    public AgreementPayment(JsonObject paymentAsJson) {
    }

    @Override
    public Headerable challenge(Shipping shipping) {
        return shipping.challenge(this);
    }

    @Override
    public String getHeader() {
        return "";
    }
}
