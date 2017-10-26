package com.mercadolibre.dojos;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

/**
 * Created by fdaranno on 17/10/17.
 */
public class OrderWrapperResponse {
    public String efectyResponse() throws IOException {
        String path = "/Users/fdaranno/git/dojo-prices/dojo/dojo_5/java/src/test/params/efectyBuyEqualPay.json";
        return readFilePath(path);
    }

    public String creditCardAndShippedCustomlyResponse() throws IOException {
        String path = "/Users/fdaranno/git/dojo-prices/dojo/dojo_5/java/src/test/params/creditCardBuyEqualPayWithCustomShipping.json";
        return readFilePath(path);
    }

    public String creditCardAndShippedME() throws IOException {
        String path = "/Users/fdaranno/git/dojo-prices/dojo/dojo_5/java/src/test/params/creditCardByEqualPayShippedByME.json";
        return readFilePath(path);
    }


    private String readFilePath(String path) throws IOException {
        return FileUtils.readFileToString(new File(path), "UTF-8");
    }
}
