package com.mercadolibre.dojos.inconsistencies;

import com.mercadolibre.dojos.IInconsistency;
import com.mercadolibre.dojos.dto.CheckoutOptionsDto;
import com.mercadolibre.dojos.dto.ItemShippingDto;
import com.mercadolibre.dojos.dto.ShippingDto;
import com.mercadolibre.dojos.util.ShippingMethodType;

/**
 * Created by fdaranno on 20/12/17.
 */
public class CantSentXUnits implements Inconsitency{

    // identifier used to designate an item that has mercadoenvios as shipping specified
    private static final String SHIPPING_MODE_MERCADO_ENVIOS_2 = "me2";

    // identifier used to designate an item that has mercadoenvios as shipping specified
    private static final String SHIPPING_MODE_MERCADO_ENVIOS_1 = "me1";

    /**
     * Determinate if the item being bought by the user cant be sent (because of the amount of units) and has local pickup
     *
     * @param checkoutOptions - the CheckoutOptionsDto that contains the base data to make the calculations.
     * @return - true if the item can only be sent, false any other case.
     */
    public boolean apply(CheckoutOptionsDto checkoutOptions){
        boolean canOnlyBeSent = false;
        ItemShippingDto itemShippingDto = checkoutOptions.getItem().getShipping();
        // first, verify the item
        if (SHIPPING_MODE_MERCADO_ENVIOS_1.equals(itemShippingDto.getMode())
                || SHIPPING_MODE_MERCADO_ENVIOS_2.equals(itemShippingDto.getMode())) {
            // Verify shipping selections
            ShippingDto shippingDto = checkoutOptions.getShipping();
            canOnlyBeSent = shippingDto.getShippingMethods().getShippingSelections().size() == 1
                    && ShippingMethodType.isLocalPickUp(shippingDto.getShippingMethods().getShippingSelections().get(0).getShippingType());
        }

        return canOnlyBeSent;
    }

    public Integer getNumber(){
        return IInconsistency.CANT_SENT_X_UNITS;
    }

}
