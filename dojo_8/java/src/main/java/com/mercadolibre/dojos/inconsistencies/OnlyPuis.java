package com.mercadolibre.dojos.inconsistencies;

import com.mercadolibre.dojos.IInconsistency;
import com.mercadolibre.dojos.dto.CheckoutOptionsDto;
import com.mercadolibre.dojos.dto.ShippingSelectionDto;
import com.mercadolibre.dojos.util.ShippingMethodType;

import java.util.List;

/**
 * Created by fdaranno on 20/12/17.
 */
public class OnlyPuis implements Inconsitency {
    public Integer getNumber() {
        return IInconsistency.ONLY_PUIS;
    }

    @Override
    public Inconsitency apply(CheckoutOptionsDto checkoutOptions, Inconsitency inconsitency) {
        return apply(checkoutOptions) ? this : inconsitency;
    }

    /**
     * Determinate if the item being bought by the user can only be picked up in store (no inconsistency, changes the fallback)
     *
     * @param checkoutOptions - the CheckoutOptionsDto that contains the base data to make the calculations.
     * @return - true if the item can only be picked up in store, false any other case.
     */
    private boolean apply(CheckoutOptionsDto checkoutOptions) {
        List<ShippingSelectionDto> shippingSelections = checkoutOptions.getShipping().getShippingMethods().getShippingSelections();
        boolean isPUISOnly = !shippingSelections.isEmpty(); // List may have at least one element to reset flag to true
        for (ShippingSelectionDto shippingSelection : shippingSelections) {
            if (!ShippingMethodType.isPickUpInStore(shippingSelection.getShippingType())) {
                isPUISOnly = false;
                break;
            }
        }
        return isPUISOnly;
    }

    @Override
    public Inconsitency apply(CheckoutOptionsDto checkoutOptions, AgreeAgree agreeAgree) {
        return this.apply(checkoutOptions,new NoneInconsitency());
    }


}
