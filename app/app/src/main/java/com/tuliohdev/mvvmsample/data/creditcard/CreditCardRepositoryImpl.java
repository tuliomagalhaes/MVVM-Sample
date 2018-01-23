package com.tuliohdev.mvvmsample.data.creditcard;

import com.tuliohdev.mvvmsample.data.model.CreditCard;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
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
    public Flowable<List<CreditCard>> getAllCreditCards() {
        Maybe<List<CreditCard>> localCreditCardsObservable = mCreditCardDao.getAllCreditCards().filter(
            new Predicate<List<CreditCard>>() {
                @Override public boolean test(List<CreditCard> creditCards) throws Exception {
                    return creditCards.size() > 0;
                }
            }).subscribeOn(Schedulers.computation());

        Maybe<List<CreditCard>> apiCreditCards = mCreditCardApiService.getAllCreditCards()
            .map(new Function<List<CreditCard>, List<CreditCard>>() {
                @Override public List<CreditCard> apply(final List<CreditCard> creditCards)
                    throws Exception {

                    Observable.create(new ObservableOnSubscribe<List<CreditCard>>() {
                        @Override public void subscribe(ObservableEmitter<List<CreditCard>> emitter)
                            throws Exception {
                            mCreditCardDao.insertCreditCardList(creditCards);
                        }
                    }).subscribeOn(Schedulers.computation()).subscribe();

                    return creditCards;
                }
            }).subscribeOn(Schedulers.io());

        return Maybe.concat(localCreditCardsObservable, apiCreditCards).observeOn(AndroidSchedulers.mainThread());
    }
}
