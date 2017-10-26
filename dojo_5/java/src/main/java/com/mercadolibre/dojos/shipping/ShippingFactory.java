package com.mercadolibre.dojos.shipping;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mercadolibre.dojos.payment.CreditCard;
import com.mercadolibre.dojos.payment.Efecty;
import com.mercadolibre.dojos.payment.Payment;
import com.mercadolibre.dojos.shipping.CustomShipping;
import com.mercadolibre.dojos.shipping.MercadoEnvio;
import com.mercadolibre.dojos.shipping.Shipping;

/**
 * Created by fdaranno on 19/10/17.
 */
public class ShippingFactory {

    public ShippingFactory(){

    }

    public Shipping createShipping(String orderWrapperResponseAsJson) {
        JsonObject shippingAsJson = getShippingAsJson( orderWrapperResponseAsJson );
        String shippingMethodId = getShippingMethodId(shippingAsJson);

        Shipping shipping;

        //TODO: llevar este switch a un mapa con key shippingMethodId y value un objeto del tipo necesario
        // inyectado por spring de modo tal que sea return mapa[key] y devuelva la instancia necesaria.
        switch (shippingMethodId){
            case "me2":
                shipping = new MercadoEnvio(shippingAsJson);
                break;
            case "custom":
                shipping = new CustomShipping(shippingAsJson);
                break;
            default:
                shipping = new AgreementShipping(shippingAsJson);
                break;
        }

        return shipping;
    }

    private String getShippingMethodId(JsonObject paymentAsJson) {
        return paymentAsJson.get("shipping_mode").getAsString();
    }


    private JsonObject getShippingAsJson(String orderWrapperResponseAsJson) {
        Gson gson = new Gson();
        JsonElement jelem = gson.fromJson(orderWrapperResponseAsJson, JsonElement.class);
        return jelem.getAsJsonObject().get("shipping").getAsJsonObject();
    }

}
