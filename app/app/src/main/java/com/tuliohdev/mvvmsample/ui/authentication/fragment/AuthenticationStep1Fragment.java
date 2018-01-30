package com.tuliohdev.mvvmsample.ui.authentication.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.tuliohdev.mvvmsample.R;
import com.tuliohdev.mvvmsample.ui.authentication.AuthenticationNavigatorContinueListener;

/**
 * Created by tulio on 29/01/2018.
 */

public class AuthenticationStep1Fragment extends Fragment implements AuthenticationNavigatorContinueListener {

    public interface OnUserBasicDataFilledListener {
        void onUserBasicDataFilled(boolean hasAddress);
    }

    @BindView(R.id.etFullName) EditText mEtFullName;
    @BindView(R.id.etEmail) EditText mEtEmail;
    @BindView(R.id.etSalary) EditText mEtSalary;

    private OnUserBasicDataFilledListener mOnUserBasicDataFilledListener;
    private Unbinder mUnbinder;

    public static AuthenticationStep1Fragment newInstance() {
        return new AuthenticationStep1Fragment();
    }

    @Nullable @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_authentication_step1, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mUnbinder.unbind();
    }

    public void setOnUserBasicDataFilledListener(OnUserBasicDataFilledListener onUserBasicDataFilledListener) {
        mOnUserBasicDataFilledListener = onUserBasicDataFilledListener;
    }

    @Override
    public void onContinue() {

    }
}
