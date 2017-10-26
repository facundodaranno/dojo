package com.mercadolibre.dojos.shipping;

import com.google.gson.JsonObject;
import com.mercadolibre.dojos.interfaces.Headerable;
import com.mercadolibre.dojos.payment.AgreementPayment;
import com.mercadolibre.dojos.payment.CreditCard;
import com.mercadolibre.dojos.payment.Efecty;

/**
 * Created by fdaranno on 26/10/17.
 */
public class AgreementShipping implements Shipping , Headerable {
    public AgreementShipping(JsonObject shippingAsJson) {
    }

    public Headerable challenge(Efecty efecty) {
        return efecty;
    }

    public Headerable challenge(CreditCard creditCard) {
        return creditCard;
    }

    @Override
    public Headerable challenge(AgreementPayment agreementPayment) {
        return this;
    }

    @Override
    public String getHeader() {
        return "";
    }
}
