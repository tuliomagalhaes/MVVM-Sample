package com.tuliohdev.mvvmsample.utils;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.tuliohdev.mvvmsample.R;

/**
 * Created by tulio on 29/01/2018.
 */

public class FragmentHelper {

    private FragmentManager mFragmentManager;
    private @IdRes int mContentId;

    public FragmentHelper(FragmentManager fragmentManager, @IdRes int contentId) {
        mFragmentManager = fragmentManager;
        mContentId = contentId;
    }

    public FragmentHelper(FragmentManager fragmentManager) {
        this(fragmentManager, R.id.main_content);
    }

    public void replaceFragment(Fragment fragment) {
        mFragmentManager
            .beginTransaction()
            .replace(mContentId, fragment)
            .commit();
    }
}
