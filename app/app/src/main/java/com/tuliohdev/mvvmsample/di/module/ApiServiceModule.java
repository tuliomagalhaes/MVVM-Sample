package com.tuliohdev.mvvmsample.di.module;

import com.tuliohdev.mvvmsample.data.creditcard.CreditCardApiService;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by tulio on 21/01/2018.
 */
@Module
public class ApiServiceModule {

    @Provides
    CreditCardApiService providesCreditCardApiService(Retrofit retrofit) {
        return retrofit.create(CreditCardApiService.class);
    }


}
