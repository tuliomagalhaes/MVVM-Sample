package com.tuliohdev.mvvmsample.ui.main.viewmodel;

import com.tuliohdev.mvvmsample.data.model.presentationmodel.CreditCardPM;
import com.tuliohdev.mvvmsample.data.source.repository.creditcard.CreditCardRepository;
import com.tuliohdev.mvvmsample.ui.main.converter.CreditCardConverter;
import com.tuliohdev.mvvmsample.utils.ResourcesManager;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by tulio on 26/01/18.
 */

public class MainViewModel {

    private CreditCardRepository mCreditCardRepository;
    private ResourcesManager mResourcesManager;

    private boolean mShouldClearCache;

    @Inject
    public MainViewModel(CreditCardRepository creditCardRepository,
        ResourcesManager resourcesManager) {
        mCreditCardRepository = creditCardRepository;
        mResourcesManager = resourcesManager;

        mShouldClearCache = true;
    }

    public Observable<List<CreditCardPM>> getCreditCardPM() {
        if (mShouldClearCache) {
            mShouldClearCache = false;
            return mCreditCardRepository.clearCache().andThen(getCreditCardPMObservable());
        } else {
            return getCreditCardPMObservable();
        }
    }

    private Observable<List<CreditCardPM>> getCreditCardPMObservable() {
        return mCreditCardRepository.getAllCreditCards()
            .map(new CreditCardConverter(mResourcesManager))
            .toObservable();
    }
}
