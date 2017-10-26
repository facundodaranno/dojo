package com.mercadolibre.dojos.payment;

import com.google.gson.JsonObject;
import com.mercadolibre.dojos.interfaces.Headerable;
import com.mercadolibre.dojos.shipping.Shipping;

/**
 * Created by fdaranno on 18/10/17.
 */
public class Efecty implements Payment,Headerable {

    public Efecty(JsonObject paymentAsJson) {}

    public Headerable challenge(Shipping shipping) {
        return shipping.challenge( this );
    }

    public String getHeader() {
         return "{" +
                "\"status\": \"success\"," +
                "\"substatus\": null," +
                "\"heading\": \"¡Apúrate a pagar!\"," +
                "\"title\": \"Paga ${price} en ${paymentMethodName} para reservar tu compra\"," +
                "}";
    }
}
