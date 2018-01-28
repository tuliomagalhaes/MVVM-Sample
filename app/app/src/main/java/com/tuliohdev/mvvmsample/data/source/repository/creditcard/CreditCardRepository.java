package com.tuliohdev.mvvmsample.data.source.repository.creditcard;

import com.tuliohdev.mvvmsample.data.model.repositorymodel.CreditCardRM;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.List;


/**
 * Created by tulio on 16/01/2018.
 */

public interface CreditCardRepository {

    Single<List<CreditCardRM>> getAllCreditCards();

    Completable clearCache();
}
