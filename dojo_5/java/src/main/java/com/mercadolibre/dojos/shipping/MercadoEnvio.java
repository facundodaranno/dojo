package com.mercadolibre.dojos.shipping;

import com.google.gson.JsonObject;
import com.mercadolibre.dojos.interfaces.Headerable;
import com.mercadolibre.dojos.payment.AgreementPayment;
import com.mercadolibre.dojos.payment.CreditCard;
import com.mercadolibre.dojos.payment.Efecty;

/**
 * Created by fdaranno on 18/10/17.
 */
public class MercadoEnvio implements  Shipping, Headerable {
    public MercadoEnvio(JsonObject orderWrapperResponseAsJson) {
    }

    public String getHeader() {
        return 	"{" +
                "\"status\": \"success\"," +
                "\"substatus\": null," +
                "\"heading\": \"¡Excelente compra!\"," +
                "\"title\": \"El jueves 2017-05-18T00:00:00.000-05:00. te llegará el producto\"," +
                "}";
    }

    public Headerable challenge(Efecty efecty) {
        return efecty;
    }

    public Headerable challenge(CreditCard creditCard) {
        return this;
    }

    @Override
    public Headerable challenge(AgreementPayment agreementPayment) {
        return this;
    }
}
