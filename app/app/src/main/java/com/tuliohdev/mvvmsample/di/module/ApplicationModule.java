package com.tuliohdev.mvvmsample.di.module;

import android.app.Application;
import android.content.Context;
import com.tuliohdev.mvvmsample.AppController;
import com.tuliohdev.mvvmsample.di.ApplicationContext;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created by tulio on 21/01/2018.
 */
@Module
public abstract class ApplicationModule {

    @Binds
    @ApplicationContext
    abstract Context provideContext(Application appController);
}
