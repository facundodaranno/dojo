package com.mercadolibre.dojos.payment;

import com.google.gson.JsonObject;
import com.mercadolibre.dojos.interfaces.Headerable;
import com.mercadolibre.dojos.shipping.Shipping;

/**
 * Created by fdaranno on 18/10/17.
 */
public class CreditCard implements Payment,Headerable {

    public CreditCard(JsonObject paymentAsJson) {}

    public Headerable challenge(Shipping shipping) {
        return shipping.challenge(this);
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
