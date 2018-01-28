package com.tuliohdev.mvvmsample.data.source.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import com.tuliohdev.mvvmsample.data.model.repositorymodel.CreditCardRM;

/**
 * Created by tulio on 21/01/2018.
 */
@Database(entities = {CreditCardRM.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract CreditCardDao creditCardDao();

}
