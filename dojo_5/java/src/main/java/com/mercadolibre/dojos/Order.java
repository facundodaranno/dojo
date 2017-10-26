package com.mercadolibre.dojos;

import com.mercadolibre.dojos.payment.Payment;
import com.mercadolibre.dojos.payment.PaymentFactory;
import com.mercadolibre.dojos.shipping.Shipping;
import com.mercadolibre.dojos.shipping.ShippingFactory;

/**
 * Created by fdaranno on 17/10/17.
 */
public class Order {

    private Shipping shipping;
    private Payment payment;

    public Order( String orderWrapperResponseAsJson ){

        //TODO: llevar los factory a Inyeccion de dependencia
        PaymentFactory paymentFactory = new PaymentFactory();
        ShippingFactory shippingFactory = new ShippingFactory();

        this.shipping = shippingFactory.createShipping(orderWrapperResponseAsJson);
        this.payment = paymentFactory.createPayment(orderWrapperResponseAsJson);
    }

    public String getHeaderAsJson() {
        //TODO: para invertir la jerarquia del double Dispatch es necesario que shipping le pregunte a payment
        return payment.challenge(shipping).getHeader();
    }
}
