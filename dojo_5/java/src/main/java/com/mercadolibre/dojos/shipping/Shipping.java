package com.mercadolibre.dojos.shipping;

import com.mercadolibre.dojos.interfaces.Headerable;
import com.mercadolibre.dojos.payment.AgreementPayment;
import com.mercadolibre.dojos.payment.CreditCard;
import com.mercadolibre.dojos.payment.Efecty;

/**
 * Created by fdaranno on 19/10/17.
 */
public interface Shipping {

    Headerable challenge(Efecty efecty);

    Headerable challenge(CreditCard creditCard);

    Headerable challenge(AgreementPayment agreementPayment);
}
