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
            .baseUrl("http://192.168.0.17:8000/sample/v1")
            .databaseName("mvvm-sample")
            .build();
        appComponent.inject(this);
        return appComponent;
    }
}
