package com.tuliohdev.mvvmsample.ui.authentication;

import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import com.tuliohdev.mvvmsample.R;
import com.tuliohdev.mvvmsample.ui.authentication.fragment.AuthenticationStep1Fragment;
import com.tuliohdev.mvvmsample.ui.authentication.fragment.AuthenticationStep2Fragment;
import com.tuliohdev.mvvmsample.ui.authentication.fragment.AuthenticationStep3Fragment;
import com.tuliohdev.mvvmsample.ui.generic.BaseNavigator;
import com.tuliohdev.mvvmsample.utils.FragmentHelper;
import com.tuliohdev.mvvmsample.utils.ResourcesManager;

/**
 * Created by tulio on 29/01/2018.
 */

public class AuthenticationNavigator extends BaseNavigator implements AuthenticationStep1Fragment.OnUserBasicDataFilledListener,
    AuthenticationStep2Fragment.OnAddressFilledListener {

    public interface ViewConfigger {
        void setTitle(String title);
        void hideNextButton();
    }

    private final int FIRST_STEP = 0;
    private final int SECOND_STEP = 1;
    private final int THIRD_STEP = 2;

    private ViewConfigger mViewConfigger;
    private AuthenticationNavigatorContinueListener mOnContinueListener;

    private int mCurrentStep = 0;
    private boolean mHasAddress = true;

    public AuthenticationNavigator(FragmentHelper fragmentHelper, ResourcesManager resourcesManager, ViewConfigger viewConfigger) {
        super(fragmentHelper, resourcesManager);
        mViewConfigger = viewConfigger;
    }

    public void initialize() {
        onNextStep();
    }

    public void onNextStepClicked() {
        if (mOnContinueListener != null) {
            mOnContinueListener.onContinue();
        }
    }

    private void onNextStep() {
        switch (mCurrentStep) {
            case FIRST_STEP:
                showStep1();
                break;
            case SECOND_STEP:
                showStep2();
                break;
            case THIRD_STEP:
                showStep3();
                break;
        }

        mCurrentStep++;
    }

    private void showStep1() {
        AuthenticationStep1Fragment fragment = AuthenticationStep1Fragment.newInstance();
        fragment.setOnUserBasicDataFilledListener(this);
        changeFragment(fragment, R.string.basic_data);
    }

    private void showStep2() {
        if (mHasAddress) {
            AuthenticationStep2Fragment fragment = AuthenticationStep2Fragment.newInstance();
            fragment.setOnAddressFilledListener(this);
            changeFragment(fragment, R.string.address_data);
        } else {
            mCurrentStep++;
            onNextStep();
        }
    }

    private void showStep3() {
        AuthenticationStep3Fragment fragment = AuthenticationStep3Fragment.newInstance();
        mViewConfigger.hideNextButton();
        changeFragment(fragment, R.string.successful_registered);
    }

    private void changeFragment(Fragment fragment, @StringRes int title) {
        mViewConfigger.setTitle(mResourcesManager.getString(title));
        mFragmentHelper.replaceFragment(fragment);
        setFragmentContinueListener(fragment);
    }

    private void setFragmentContinueListener(Fragment fragment) {
        mOnContinueListener = (AuthenticationNavigatorContinueListener) fragment;
    }

    @Override
    public void onUserBasicDataFilled(boolean hasAddress) {
        mHasAddress = hasAddress;
        onNextStep();
    }

    @Override
    public void onAddressFilled() {
        onNextStep();
    }
}
