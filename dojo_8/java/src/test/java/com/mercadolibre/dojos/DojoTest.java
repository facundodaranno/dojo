package com.mercadolibre.dojos;

import com.google.gson.GsonBuilder;
import com.mercadolibre.dojos.dto.CheckoutOptionsDto;
import com.mercadolibre.dojos.inconsistencies.AgreeAgree;
import com.mercadolibre.dojos.inconsistencies.Inconsitency;
import com.mercadolibre.dojos.inconsistencies.OnlyToAgree;
import org.junit.Assert;
import org.junit.Test;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;


public class DojoTest {

    @Test
    public void test() throws FileNotFoundException {
        CheckoutOptionsDto checkoutOptionsDto = new GsonBuilder().create().fromJson(loadFile("options.json"), CheckoutOptionsDto.class);

        Assert.assertEquals("MLA0000001", checkoutOptionsDto.getItem().getId());
    }

    @Test
    public void onlyToAgree() throws FileNotFoundException {
        CheckoutOptionsDto checkoutOptionsDto = new GsonBuilder().create().fromJson(loadFile("only_to_agree.json"), CheckoutOptionsDto.class);
        CheckoutContext checkoutContext = new CheckoutContext(checkoutOptionsDto);
        int inconsistency = InconsistencyCalculator.getInconsistencyValue(checkoutContext);
        Assert.assertEquals(IInconsistency.ONLY_TO_AGREE, inconsistency);
    }

    @Test
    public void cantSentXUnits() throws FileNotFoundException {
        CheckoutOptionsDto checkoutOptionsDto = new GsonBuilder().create().fromJson(loadFile("cant_sent_x_units.json"), CheckoutOptionsDto.class);
        CheckoutContext checkoutContext = new CheckoutContext(checkoutOptionsDto);
        int inconsistency = InconsistencyCalculator.getInconsistencyValue(checkoutContext);
        Assert.assertEquals(IInconsistency.CANT_SENT_X_UNITS, inconsistency);
    }

    @Test
    public void agreeAgree() throws FileNotFoundException {
        CheckoutOptionsDto checkoutOptionsDto = new GsonBuilder().create().fromJson(loadFile("agree_agree.json"), CheckoutOptionsDto.class);
        CheckoutContext checkoutContext = new CheckoutContext(checkoutOptionsDto);
        int inconsistency = InconsistencyCalculator.getInconsistencyValue(checkoutContext);
        Assert.assertEquals(IInconsistency.AGREE_AGREE, inconsistency);
    }

    @Test
    public void testAgreeAgreeVsOnlyToAgreeMustWinAgreeAgree()  throws FileNotFoundException {
        CheckoutOptionsDto checkoutOptionsDto = new GsonBuilder().create().fromJson(loadFile("agree_agree.json"), CheckoutOptionsDto.class);

        Inconsitency agreeAgree = new AgreeAgree();
        Inconsitency onlyToAgree = new OnlyToAgree();

        Assert.assertEquals( agreeAgree.apply(checkoutOptionsDto,onlyToAgree), agreeAgree);
    }

    @Test
    public void testOnlyToAgreeVsOnlyToAgreeMustWinAgreeAgree()  throws FileNotFoundException {
        CheckoutOptionsDto checkoutOptionsDto = new GsonBuilder().create().fromJson(loadFile("agree_agree.json"), CheckoutOptionsDto.class);

        AgreeAgree agreeAgree = new AgreeAgree();
        OnlyToAgree onlyToAgree = new OnlyToAgree();

        Assert.assertEquals( onlyToAgree.apply(checkoutOptionsDto,agreeAgree), agreeAgree);
    }

    @Test
    public void onlyCanBeSent() throws FileNotFoundException {
        CheckoutOptionsDto checkoutOptionsDto = new GsonBuilder().create().fromJson(loadFile("only_can_be_sent.json"), CheckoutOptionsDto.class);
        CheckoutContext checkoutContext = new CheckoutContext(checkoutOptionsDto);
        int inconsistency = InconsistencyCalculator.getInconsistencyValue(checkoutContext);
        Assert.assertEquals(IInconsistency.ONLY_CAN_BE_SENT, inconsistency);
    }

    @Test
    public void onlyPuis() throws FileNotFoundException {
        CheckoutOptionsDto checkoutOptionsDto = new GsonBuilder().create().fromJson(loadFile("only_puis.json"), CheckoutOptionsDto.class);
        CheckoutContext checkoutContext = new CheckoutContext(checkoutOptionsDto);
        int inconsistency = InconsistencyCalculator.getInconsistencyValue(checkoutContext);
        Assert.assertEquals(IInconsistency.ONLY_PUIS, inconsistency);
    }

    private InputStreamReader loadFile(String filename) {
        return new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream(filename));
    }

}
