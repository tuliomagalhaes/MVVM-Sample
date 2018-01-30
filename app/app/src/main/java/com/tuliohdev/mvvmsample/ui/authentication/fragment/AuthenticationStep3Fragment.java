package com.tuliohdev.mvvmsample.ui.authentication.fragment;

import android.support.v4.app.Fragment;
import com.tuliohdev.mvvmsample.ui.authentication.AuthenticationNavigatorContinueListener;

/**
 * Created by tulio on 29/01/2018.
 */

public class AuthenticationStep3Fragment extends Fragment implements AuthenticationNavigatorContinueListener {

    public static AuthenticationStep3Fragment newInstance() {
        return new AuthenticationStep3Fragment();
    }

    @Override
    public void onContinue() {

    }
}
