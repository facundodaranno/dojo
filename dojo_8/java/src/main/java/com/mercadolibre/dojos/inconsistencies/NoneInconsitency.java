package com.mercadolibre.dojos.inconsistencies;

import com.mercadolibre.dojos.IInconsistency;
import com.mercadolibre.dojos.dto.CheckoutOptionsDto;

/**
 * Created by fdaranno on 20/12/17.
 */
public class NoneInconsitency implements Inconsitency {
    public Integer getNumber() {
        return IInconsistency.NONE;
    }

    public boolean apply(CheckoutOptionsDto checkoutOptions) {
        return true;
    }
}
