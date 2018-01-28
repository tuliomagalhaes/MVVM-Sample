package com.tuliohdev.mvvmsample.data.source.repository.creditcard;

import com.tuliohdev.mvvmsample.data.source.local.CreditCardDao;
import com.tuliohdev.mvvmsample.data.source.remote.CreditCardApiService;
import com.tuliohdev.mvvmsample.data.model.repositorymodel.CreditCardRM;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
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
    public Single<List<CreditCardRM>> getAllCreditCards() {
        Observable<List<CreditCardRM>> remoteCreditCardsObservable = mCreditCardApiService.getAllCreditCards()
            .map(creditCards -> {
                mCreditCardDao.insertCreditCardList(creditCards);
                return creditCards;
            }).toObservable();

        Observable<List<CreditCardRM>> localCreditCardsObservable = mCreditCardDao.getAllCreditCards()
            .filter(creditCards -> !creditCards.isEmpty()).toObservable();

        return Observable.concat(localCreditCardsObservable, remoteCreditCardsObservable)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .first(new ArrayList<>());
    }

    @Override
    public Completable clearCache() {
        return Completable.create(emitter -> {
                mCreditCardDao.deleteAllCreditCards();
                emitter.onComplete();
            }).subscribeOn(Schedulers.io());
    }
}
