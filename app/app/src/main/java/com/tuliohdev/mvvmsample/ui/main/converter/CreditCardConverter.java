package com.tuliohdev.mvvmsample.ui.main.converter;

import android.graphics.drawable.Drawable;
import com.tuliohdev.mvvmsample.R;
import com.tuliohdev.mvvmsample.data.model.presentationmodel.CreditCardPM;
import com.tuliohdev.mvvmsample.data.model.repositorymodel.CreditCardRM;
import com.tuliohdev.mvvmsample.utils.ResourcesManager;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tulio on 26/01/18.
 */

public class CreditCardConverter implements Function<List<CreditCardRM>, List<CreditCardPM>> {

    private ResourcesManager mResourcesManager;

    public CreditCardConverter(ResourcesManager resourcesManager) {
        mResourcesManager = resourcesManager;
    }

    @Override
    public List<CreditCardPM> apply(List<CreditCardRM> creditCards) {
        List<CreditCardPM> creditCardPMList = new ArrayList<>();

        for(CreditCardRM creditCardRM : creditCards) {
            CreditCardPM creditCardPM = new CreditCardPM();
            creditCardPM.setId(creditCardRM.getId());
            creditCardPM.setCvv(creditCardRM.getCvv());
            creditCardPM.setName(creditCardRM.getName().toUpperCase());

            String cardNumber = creditCardRM.getNumber();
            String cardNumberFormatted = cardNumber.substring(0, 4) + " " + cardNumber.substring(4, 8) + " " + cardNumber.substring(8, 12) + " " + cardNumber.substring(12, cardNumber.length());

            creditCardPM.setNumber(cardNumberFormatted);

            String expirationDate = creditCardRM.getExpirationDate();
            String expirationDateFormatted = expirationDate.substring(expirationDate.length() - 2, expirationDate.length()) + "/" + expirationDate.substring(0, 4);
            creditCardPM.setExpirationDate(expirationDateFormatted);
            Drawable cardBrand = mResourcesManager.getDrawable(creditCardRM.getBrandType() == CreditCardRM.BrandType.MASTERCARD ?
                R.drawable.ic_mastercard_brand : R.drawable.ic_visa_brand);
            creditCardPM.setBrandType(cardBrand);

            creditCardPMList.add(creditCardPM);
        }

        return creditCardPMList;
    }
}
