package com.liuhw.rxanroiddemo.creating;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.liuhw.rxanroiddemo.BaseActivity;
import com.liuhw.rxanroiddemo.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class IntervalActivity extends BaseActivity {

    private TextView mTvIntervalResult;
    private StringBuilder sb = new StringBuilder();
    private Subscription subscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interval);
        if (mActionBar != null) {
            mActionBar.setTitle("interval operator");
        }
        mTvIntervalResult = (TextView) findViewById(R.id.tv_interval_result);
    }

    public void onClick(View view) {
        Observable<Long> obs = Observable.interval(1, TimeUnit.SECONDS, AndroidSchedulers
                .mainThread());
        subscription = obs.subscribe(new Subscriber<Long>() {
            @Override
            public void onCompleted() {
                sb.append("onCompleted").append("\n");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Long aLong) {
                sb.append("onNext:").append(aLong).append("\n");
                mTvIntervalResult.setText(sb.toString());
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
