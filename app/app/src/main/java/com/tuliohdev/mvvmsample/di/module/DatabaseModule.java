package com.tuliohdev.mvvmsample.di.module;

import android.arch.persistence.room.Room;
import android.content.Context;
import com.tuliohdev.mvvmsample.data.source.local.AppDatabase;
import com.tuliohdev.mvvmsample.data.source.local.CreditCardDao;
import com.tuliohdev.mvvmsample.di.ApplicationContext;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by tulio on 21/01/2018.
 */
@Module
public class DatabaseModule {

    @Provides
    @Named("databaseName")
    String provideDatabaseName() {
        return "mvvm-sample";
    }

    @Provides
    @Singleton
    AppDatabase providesAppDatabase(@ApplicationContext Context context, @Named("databaseName") String databaseName) {
        return Room.databaseBuilder(context, AppDatabase.class, databaseName).build();
    }

    @Provides
    CreditCardDao providesCreditCardDao(AppDatabase appDatabase) {
        return appDatabase.creditCardDao();
    }
}
