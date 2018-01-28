package com.tuliohdev.mvvmsample.data.source.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import com.tuliohdev.mvvmsample.data.model.repositorymodel.CreditCardRM;
import io.reactivex.Single;
import java.util.List;

/**
 * Created by tulio on 16/01/2018.
 */
@Dao
public interface CreditCardDao {

    @Insert
    void insertCreditCardList(List<CreditCardRM> creditCards);

    @Query("SELECT * FROM CreditCardRM")
    Single<List<CreditCardRM>> getAllCreditCards();

    @Query("DELETE FROM CreditCardRM")
    void deleteAllCreditCards();

}
