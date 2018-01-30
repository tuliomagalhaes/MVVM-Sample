package com.tuliohdev.mvvmsample.ui.generic;

import com.tuliohdev.mvvmsample.utils.FragmentHelper;
import com.tuliohdev.mvvmsample.utils.ResourcesManager;

/**
 * Created by tulio on 29/01/2018.
 */

public abstract class BaseNavigator {

    protected FragmentHelper mFragmentHelper;
    protected ResourcesManager mResourcesManager;

    public BaseNavigator(FragmentHelper fragmentHelper, ResourcesManager resourcesManager) {
        mFragmentHelper = fragmentHelper;
        mResourcesManager = resourcesManager;
    }

    public abstract void initialize();

}
