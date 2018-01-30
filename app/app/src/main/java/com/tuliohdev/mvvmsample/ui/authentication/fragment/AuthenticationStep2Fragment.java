package com.tuliohdev.mvvmsample.ui.authentication.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.tuliohdev.mvvmsample.R;
import com.tuliohdev.mvvmsample.ui.authentication.AuthenticationNavigatorContinueListener;

/**
 * Created by tulio on 29/01/2018.
 */

public class AuthenticationStep2Fragment extends Fragment implements AuthenticationNavigatorContinueListener {

    public interface OnAddressFilledListener {
        void onAddressFilled();
    }

    private OnAddressFilledListener mOnAddressFilledListener;
    private Unbinder mUnbinder;

    public static AuthenticationStep2Fragment newInstance() {
        return new AuthenticationStep2Fragment();
    }

    @Nullable @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
        Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_authentication_step2, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mUnbinder.unbind();
    }

    public void setOnAddressFilledListener(OnAddressFilledListener onAddressFilledListener) {
        mOnAddressFilledListener = onAddressFilledListener;
    }

    @Override
    public void onContinue() {

    }
}
