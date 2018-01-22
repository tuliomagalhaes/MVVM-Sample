package com.tuliohdev.mvvmsample.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import com.tuliohdev.mvvmsample.data.creditcard.CreditCardDao;
import com.tuliohdev.mvvmsample.data.model.CreditCard;

/**
 * Created by tulio on 21/01/2018.
 */
@Database(entities = {CreditCard.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract CreditCardDao creditCardDao();

}
