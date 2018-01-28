package com.tuliohdev.mvvmsample.di.module;

import com.tuliohdev.mvvmsample.data.source.remote.CreditCardApiService;
import com.tuliohdev.mvvmsample.data.source.local.CreditCardDao;
import com.tuliohdev.mvvmsample.data.source.repository.creditcard.CreditCardRepository;
import com.tuliohdev.mvvmsample.data.source.repository.creditcard.CreditCardRepositoryImpl;
import dagger.Module;
import dagger.Provides;

/**
 * Created by tulio on 21/01/2018.
 */
@Module
public abstract class RepositoryModule {

    @Provides
    static CreditCardRepository providesCreditCardRepository(CreditCardApiService creditCardApiService, CreditCardDao creditCardDao) {
        return new CreditCardRepositoryImpl(creditCardApiService, creditCardDao);
    }

}
