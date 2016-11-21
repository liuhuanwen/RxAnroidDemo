package com.liuhw.rxanroiddemo.creating;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.liuhw.rxanroiddemo.BaseActivity;
import com.liuhw.rxanroiddemo.R;

import rx.Observable;
import rx.Subscriber;

public class CreateActivity extends BaseActivity {

    private TextView mTvCreateResult;
    private StringBuilder sb = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        if (mActionBar != null) {
            mActionBar.setTitle("create operator");
        }
        mTvCreateResult = (TextView) findViewById(R.id.tv_create_result);
    }

    public void onClick(View view) {
        Observable<Integer> obs = Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                for (int i = 0; i < 5; i++) {
                    subscriber.onNext(i);
                }
                subscriber.onCompleted();
            }
        });
        obs.subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                sb.append("onCompleted over\n");
                mTvCreateResult.setText(sb.toString());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                sb.append("onNext:").append(integer).append("\n");
            }
        });
    }

}
