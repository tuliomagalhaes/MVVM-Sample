package com.tuliohdev.mvvmsample.di.module;

import com.tuliohdev.mvvmsample.ui.main.activity.MainActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by tulio on 21/01/2018.
 */
@Module
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    abstract MainActivity mainActivity();

}
