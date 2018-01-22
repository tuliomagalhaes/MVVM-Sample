package com.tuliohdev.mvvmsample.di.module;

import android.content.Context;
import com.tuliohdev.mvvmsample.AppController;
import com.tuliohdev.mvvmsample.di.ApplicationContext;
import dagger.Module;
import dagger.Provides;

/**
 * Created by tulio on 21/01/2018.
 */
@Module
public class ApplicationModule {

    @Provides
    @ApplicationContext
    Context provideContext(AppController appController) {
        return appController;
    }
}
