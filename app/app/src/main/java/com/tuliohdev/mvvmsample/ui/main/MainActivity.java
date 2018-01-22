package com.tuliohdev.mvvmsample.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tuliohdev.mvvmsample.R;
import com.tuliohdev.mvvmsample.data.creditcard.CreditCardRepository;
import com.tuliohdev.mvvmsample.data.model.CreditCard;
import dagger.android.support.DaggerAppCompatActivity;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import java.util.List;
import javax.inject.Inject;

public class MainActivity extends DaggerAppCompatActivity {

    @Inject
    CreditCardRepository mCreditCardRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCreditCardRepository.getAllCreditCards().subscribe(new SingleObserver<List<CreditCard>>() {
            @Override public void onSubscribe(Disposable d) {

            }

            @Override public void onSuccess(List<CreditCard> creditCards) {
                System.out.println(creditCards);
            }

            @Override public void onError(Throwable e) {

            }
        });
    }
}
