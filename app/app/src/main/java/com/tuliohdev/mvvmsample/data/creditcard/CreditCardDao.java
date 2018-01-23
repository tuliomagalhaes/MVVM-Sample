package com.tuliohdev.mvvmsample.data.creditcard;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import com.tuliohdev.mvvmsample.data.model.CreditCard;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.List;

/**
 * Created by tulio on 16/01/2018.
 */
@Dao
public interface CreditCardDao {

    @Insert
    void insertCreditCardList(List<CreditCard> creditCards);

    @Query("SELECT * FROM creditCard") Maybe<List<CreditCard>> getAllCreditCards();

}
