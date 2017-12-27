package com.mercadolibre.dojos;


import com.mercadolibre.dojos.dto.*;
import com.mercadolibre.dojos.inconsistencies.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper class that calculates the next step for the fallback shipping selection.
 * Created by jpperetti on 6/6/16.
 */
public final class InconsistencyCalculator {


    private InconsistencyCalculator() {
        // private method
    }

    /**
     * Calculates the inconsistency (in case that there is one) related to the shipping
     * options and the quantity selected by the user.
     *
     * @param checkoutContext - the CheckoutContext that contains the base data to make the calculations.
     * @return an IInconsistency value that indicates the current case.
     */
    @IInconsistency
    //FIXME: static... en general me muestra que se está pensando procedural,
    // y no se tiene en cuenta el ciclo de vida de un objeto
    // sus cambios de estado, etc
    public static Integer getInconsistencyValue(CheckoutContext checkoutContext) {

        //FIXME: Tell dont ask
        CheckoutOptionsDto checkoutOptions = checkoutContext.getCheckoutOptionsDto();

        List<Inconsitency> inconsistencyList = new ArrayList<Inconsitency>();
        inconsistencyList.add( new OnlyCanBeSent() );
        inconsistencyList.add( new CantSentXUnits() );
        inconsistencyList.add( new AgreeAgree() );
        inconsistencyList.add( new OnlyToAgree() );
        inconsistencyList.add( new OnlyPuis() );

        for(Inconsitency inconsitency : inconsistencyList){
            if(inconsitency.apply(checkoutOptions)){
                return inconsitency.getNumber();
            }
        }

        Inconsitency noneInconsistency = new NoneInconsitency();
        return noneInconsistency.getNumber();
    }

}

