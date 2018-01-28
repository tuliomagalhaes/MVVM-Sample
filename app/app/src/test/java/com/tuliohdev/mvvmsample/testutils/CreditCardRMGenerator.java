package com.tuliohdev.mvvmsample.testutils;

import com.tuliohdev.mvvmsample.data.model.repositorymodel.CreditCardRM;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tulio on 28/01/18.
 */

public class CreditCardRMGenerator {

    public static final String ID = "AAA";
    public static final String CVV = "000";
    public static final String EXPIRATION_DATE = "202001";
    public static final String CARD_NUMBER = "5252062126379381";
    public static final String NAME = "Name of Holder";

    public static List<CreditCardRM> generateList() {
        return generateListBasedOnBrandType(CreditCardRM.BrandType.MASTERCARD);
    }

    public static List<CreditCardRM> generateListBasedOnBrandType(CreditCardRM.BrandType brandType) {
        List<CreditCardRM> creditCardRMList = new ArrayList<>();

        CreditCardRM creditCardRM = new CreditCardRM();
        creditCardRM.setId(ID);
        creditCardRM.setCvv(CVV);
        creditCardRM.setExpirationDate(EXPIRATION_DATE);
        creditCardRM.setNumber(CARD_NUMBER);
        creditCardRM.setName(NAME);
        creditCardRM.setBrandType(brandType);
        creditCardRMList.add(creditCardRM);

        creditCardRM = new CreditCardRM();
        creditCardRM.setId(ID);
        creditCardRM.setCvv(CVV);
        creditCardRM.setExpirationDate(EXPIRATION_DATE);
        creditCardRM.setNumber(CARD_NUMBER);
        creditCardRM.setName(NAME);
        creditCardRM.setBrandType(brandType);
        creditCardRMList.add(creditCardRM);

        return creditCardRMList;
    }

}
