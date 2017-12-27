package com.mercadolibre.dojos.inconsistencies;

import com.mercadolibre.dojos.IInconsistency;
import com.mercadolibre.dojos.Inconsistency;
import com.mercadolibre.dojos.dto.CheckoutOptionsDto;
import com.mercadolibre.dojos.dto.ItemShippingDto;
import com.mercadolibre.dojos.dto.ShippingDto;
import com.mercadolibre.dojos.dto.ShippingOptionDto;
import com.mercadolibre.dojos.util.PaymentMethodType;
import com.mercadolibre.dojos.util.ShippingMethodType;

/**
 * Created by fdaranno on 20/12/17.
 */
public class AgreeAgree implements Inconsitency{

    // identifier used to designate an item that doesn't has shipping specified
    private static final String SHIPPING_MODE_NOT_SPECIFIED = "not_specified";

    /**
     * Determinate if the item being bought by the user can only be sent by custom shipping (no inconsistency, changes the fallback) -
     * rare case.
     *
     * @param checkoutOptions - the CheckoutOptionsDto that contains the base data to make the calculations.
     * @return - true if the item can only be sent, false any other case.
     */
    public boolean apply(CheckoutOptionsDto checkoutOptions){
        return isShippingToAgreeOnly(checkoutOptions) && isPaymentToAgreeOnly(checkoutOptions);
    }

    /**
     * Verifies if the shipping is only (and exclusively) agreement.
     *
     * @param checkoutOptions - the CheckoutOptionsDto that contains the base data to make the calculations.
     * @return - true if it is only to agree, false any other case.
     */
    private static boolean isShippingToAgreeOnly(CheckoutOptionsDto checkoutOptions) {
        boolean isOnlyToAgree = false;
        ShippingDto shippingDto = checkoutOptions.getShipping();
        ItemShippingDto itemShippingDto = checkoutOptions.getItem().getShipping();
        // first, verify the item
        if (SHIPPING_MODE_NOT_SPECIFIED.equals(itemShippingDto.getMode()) && !itemShippingDto.isFreeShipping()) {
            // now verify checkout options
            isOnlyToAgree = isToAgree(shippingDto) && shippingDto.getShippingOptions().size() == 1;
        }
        return isOnlyToAgree;
    }


    /**
     * Verifies if the only payment option is to agree
     *
     * @param checkoutOptions - the CheckoutOptionsDto that contains the base data to make the calculations.
     * @return if there is only one available payment type and it is to agree
     */
    private static boolean isPaymentToAgreeOnly(CheckoutOptionsDto checkoutOptions) {
        return checkoutOptions.getPayment().getPaymentOptions().getOptions().size() == 1
                && PaymentMethodType.isCash(checkoutOptions.getPayment().getPaymentOptions().getOptions().get(0).getType());
    }

    /**
     * Verifies if at least one of the ShippingOption is agreement (to agree)
     *
     * @param shippingDto - the ShippingDto that contains all the shipping selections possible
     * @return - true if at least one of the ShippingOption in the model is agreement
     */
    private static boolean isToAgree(ShippingDto shippingDto) {
        boolean isToAgree = false;
        for (ShippingOptionDto shippingOptionDto : shippingDto.getShippingOptions()) {
            if (ShippingMethodType.isToAgree(shippingOptionDto.getShippingType())) {
                isToAgree = true;
                break;
            }
        }
        return isToAgree;
    }


    public Integer getNumber(){
        return IInconsistency.AGREE_AGREE;
    }

}
