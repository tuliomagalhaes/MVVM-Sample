package com.tuliohdev.mvvmsample.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tuliohdev.mvvmsample.R;
import com.tuliohdev.mvvmsample.data.creditcard.CreditCardRepository;
import com.tuliohdev.mvvmsample.data.model.CreditCard;
import dagger.android.support.DaggerAppCompatActivity;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.List;
import javax.inject.Inject;
import org.reactivestreams.Subscription;

public class MainActivity extends DaggerAppCompatActivity {

    @Inject
    CreditCardRepository mCreditCardRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCreditCardRepository.getAllCreditCards().subscribe(new FlowableSubscriber<List<CreditCard>>() {
            @Override public void onSubscribe(Subscription s) {

            }

            @Override public void onNext(List<CreditCard> creditCards) {
                System.out.println(creditCards);
            }

            @Override public void onError(Throwable t) {
                System.out.println("onError: " + t.getMessage());
            }

            @Override public void onComplete() {

            }
        });
    }
}
