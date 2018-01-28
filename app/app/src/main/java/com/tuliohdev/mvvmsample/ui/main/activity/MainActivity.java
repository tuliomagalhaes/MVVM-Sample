package com.tuliohdev.mvvmsample.ui.main.activity;

import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.tuliohdev.mvvmsample.R;
import com.tuliohdev.mvvmsample.ui.main.viewmodel.MainViewModel;
import com.tuliohdev.mvvmsample.ui.main.adapter.CreditCardAdapter;
import dagger.android.support.DaggerAppCompatActivity;
import javax.inject.Inject;

public class MainActivity extends DaggerAppCompatActivity {

    @BindView(R.id.rvCreditCard) RecyclerView mRvCreditCard;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;

    @Inject
    MainViewModel mMainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        mMainViewModel.getCreditCardPM().doOnSubscribe(disposable -> {
            mProgressBar.setVisibility(View.VISIBLE);
        }).subscribe(creditCardPMS -> {
            mProgressBar.setVisibility(View.GONE);
            mRvCreditCard.setAdapter(new CreditCardAdapter(creditCardPMS));
            mRvCreditCard.setLayoutManager(new LinearLayoutManager(this));
        });
    }
}
