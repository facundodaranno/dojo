package com.mercadolibre.dojos.inconsistencies;

import com.mercadolibre.dojos.IInconsistency;
import com.mercadolibre.dojos.inconsistencies.Inconsitency;
import com.mercadolibre.dojos.dto.CheckoutOptionsDto;
import com.mercadolibre.dojos.dto.ShippingDto;
import com.mercadolibre.dojos.util.ShippingMethodType;

/**
 * Created by fdaranno on 20/12/17.
 */
public class OnlyCanBeSent implements Inconsitency{

    /**
     * Determinate if the item being bought by the user can only be sent by custom shipping (no inconsistency, changes the fallback) -
     * rare case.
     *
     * @param checkoutOptions - the CheckoutOptionsDto that contains the base data to make the calculations.
     * @return - true if the item can only be sent, false any other case.
     */
    public boolean apply(CheckoutOptionsDto checkoutOptions){
        // Verify shipping selections
        ShippingDto shippingDto = checkoutOptions.getShipping();
        return shippingDto.getShippingMethods().getShippingSelections().size() == 1
                && ShippingMethodType.isCustomShipping(shippingDto.getShippingMethods().getShippingSelections().get(0).getShippingType());
    }

    public Integer getNumber(){
        return IInconsistency.ONLY_CAN_BE_SENT;
    }

}
