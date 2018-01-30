package com.tuliohdev.mvvmsample.ui.authentication.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.tuliohdev.mvvmsample.R;
import com.tuliohdev.mvvmsample.ui.authentication.AuthenticationNavigator;
import dagger.android.support.DaggerAppCompatActivity;
import javax.inject.Inject;

/**
 * Created by tulio on 29/01/2018.
 */

public class AuthenticationActivity extends DaggerAppCompatActivity implements AuthenticationNavigator.ViewConfigger {

    @Inject
    AuthenticationNavigator mAuthenticationNavigator;

    @BindView(R.id.btNextStep) Button mBtNextStep;
    @BindView(R.id.tvTitle) TextView mTvTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_authentication);

        mAuthenticationNavigator.initialize();
    }

    @OnClick(R.id.btNextStep)
    void onClickNextStep() {
        mAuthenticationNavigator.onNextStepClicked();
    }

    @Override
    public void setTitle(String title) {
        mTvTitle.setText(title);
    }

    @Override
    public void hideNextButton() {
        mBtNextStep.setVisibility(View.GONE);
    }
}
