package com.mercadolibre.dojos.shipping;

import com.google.gson.JsonObject;
import com.mercadolibre.dojos.interfaces.Headerable;
import com.mercadolibre.dojos.payment.AgreementPayment;
import com.mercadolibre.dojos.payment.CreditCard;
import com.mercadolibre.dojos.payment.Efecty;

/**
 * Created by fdaranno on 18/10/17.
 */
public class CustomShipping implements  Shipping, Headerable {
    public CustomShipping(JsonObject orderWrapperResponseAsJson) {
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

    public String getHeader() {
        return "{" +
                "\"status\": \"success\"," +
                "\"substatus\": null," +
                "\"heading\": \"¡Tu pago está aprobado!\"," +
                "\"title\": \"Coordina con el vendedor el envío\"," +
                "}";
    }
}
