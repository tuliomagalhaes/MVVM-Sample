package com.tuliohdev.mvvmsample;

import com.tuliohdev.mvvmsample.di.component.AppComponent;
import com.tuliohdev.mvvmsample.di.component.DaggerAppComponent;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * Created by tulio on 16/01/2018.
 */

public class AppController extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = DaggerAppComponent.builder()
            .application(this)
            .build();
        appComponent.inject(this);
        return appComponent;
    }
}
