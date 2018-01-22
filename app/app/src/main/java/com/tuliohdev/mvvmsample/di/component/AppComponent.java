package com.tuliohdev.mvvmsample.di.component;

import android.app.Application;
import com.tuliohdev.mvvmsample.AppController;
import com.tuliohdev.mvvmsample.data.creditcard.CreditCardRepositoryImpl;
import com.tuliohdev.mvvmsample.di.module.ActivityBindingModule;
import com.tuliohdev.mvvmsample.di.module.ApiServiceModule;
import com.tuliohdev.mvvmsample.di.module.ApplicationModule;
import com.tuliohdev.mvvmsample.di.module.DatabaseModule;
import com.tuliohdev.mvvmsample.di.module.NetworkModule;
import com.tuliohdev.mvvmsample.di.module.RepositoryModule;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by tulio on 21/01/2018.
 */
@Singleton
@Component(modules = {
    ApplicationMo   dule.class,
    DatabaseModule.class,
    NetworkModule.class,
    ApiServiceModule.class,
    RepositoryModule.class,
    ActivityBindingModule.class,
    AndroidSupportInjectionModule.class
})
public interface AppComponent extends AndroidInjector<DaggerApplication> {

    void inject(AppController appController);

    void inject(CreditCardRepositoryImpl creditCardRepository);

    @Override
    void inject(DaggerApplication daggerApplication);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        @BindsInstance
        Builder baseUrl(@Named("baseUrl") String baseUrl);

        @BindsInstance
        Builder databaseName(@Named("databaseName") String databaseName);

        AppComponent build();
    }
}
