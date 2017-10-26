package com.mercadolibre.dojos.payment;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mercadolibre.dojos.payment.CreditCard;
import com.mercadolibre.dojos.payment.Efecty;
import com.mercadolibre.dojos.payment.Payment;

/**
 * Created by fdaranno on 19/10/17.
 */
public class PaymentFactory {

    public PaymentFactory(){

    }

    public Payment createPayment(String orderWrapperResponseAsJson) {
        JsonObject paymentAsJson = getPaymentAsJson( orderWrapperResponseAsJson );
        String paymentMethodId = getPaymentMethodIdFromJson(paymentAsJson);

        Payment payment;

        //TODO: llevar este switch a un mapa con key paymentMethodId y value un objeto del tipo necesario
        // inyectado por spring de modo tal que sea return mapa[key] y devuelva la instancia necesaria.
        switch (paymentMethodId){
            case "visa":
                payment = new CreditCard(paymentAsJson);
                break;
            case "efecty":
                payment = new Efecty(paymentAsJson);
                break;
            default:
                payment = new AgreementPayment(paymentAsJson);
                break;
        }

        return payment;
    }

    private String getPaymentMethodIdFromJson(JsonObject paymentAsJson) {
        return paymentAsJson.get("payment_method_id").getAsString();
    }


    private JsonObject getPaymentAsJson(String orderWrapperResponseAsJson) {
        Gson gson = new Gson();
        JsonElement jelem = gson.fromJson(orderWrapperResponseAsJson, JsonElement.class);
        return jelem.getAsJsonObject().get("payments").getAsJsonArray().get(0).getAsJsonObject();
    }
}
