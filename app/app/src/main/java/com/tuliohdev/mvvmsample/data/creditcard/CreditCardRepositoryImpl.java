package com.tuliohdev.mvvmsample.data.creditcard;

import com.tuliohdev.mvvmsample.data.model.CreditCard;
import io.reactivex.Single;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by tulio on 21/01/2018.
 */

public class CreditCardRepositoryImpl implements CreditCardRepository {

    private CreditCardApiService mCreditCardApiService;
    private CreditCardDao mCreditCardDao;

    @Inject
    public CreditCardRepositoryImpl(CreditCardApiService creditCardApiService, CreditCardDao creditCardDao) {
        mCreditCardApiService = creditCardApiService;
        mCreditCardDao = creditCardDao;
    }

    @Override
    public Single<List<CreditCard>> getAllCreditCards() {
        return mCreditCardApiService.getAllCreditCards();
    }
}
