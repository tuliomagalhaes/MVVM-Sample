package com.tuliohdev.mvvmsample.data.creditcard;

import com.tuliohdev.mvvmsample.data.model.CreditCard;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import java.util.List;


/**
 * Created by tulio on 16/01/2018.
 */

public interface CreditCardRepository {

    Flowable<List<CreditCard>> getAllCreditCards();

}
