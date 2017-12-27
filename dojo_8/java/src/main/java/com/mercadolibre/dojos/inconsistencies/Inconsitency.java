package com.mercadolibre.dojos.inconsistencies;

import com.mercadolibre.dojos.dto.CheckoutOptionsDto;

/**
 * Created by fdaranno on 20/12/17.
 */
public interface Inconsitency {
    public Integer getNumber();
    public boolean apply(CheckoutOptionsDto checkoutOptions);
}
