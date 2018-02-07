package com.mercadolibre.dojos.inconsistencies;

import com.mercadolibre.dojos.dto.CheckoutOptionsDto;

/**
 * Created by fdaranno on 20/12/17.
 */
public interface Inconsitency {
    public Integer getNumber();
    public Inconsitency apply(CheckoutOptionsDto checkoutOptions, Inconsitency inconsitency);
    public Inconsitency apply(CheckoutOptionsDto checkoutOptions, AgreeAgree agreeAgree);
}
