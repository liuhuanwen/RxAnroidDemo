package com.liuhw.rxanroiddemo.creating;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.liuhw.rxanroiddemo.BaseActivity;
import com.liuhw.rxanroiddemo.R;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

public class RepeatActivity extends BaseActivity {

    private TextView mTvRepeatResult;
    private StringBuilder sb = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repeat);
        if (mActionBar != null) {
            mActionBar.setTitle("repeat operator");
        }
        mTvRepeatResult = (TextView) findViewById(R.id.tv_repeat_result);
    }

    public void onClick(View view) {
        Observable<Integer> obs = Observable.just(1).repeat(5, AndroidSchedulers.mainThread());
        obs.subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                sb.append("onCompleted").append("\n");
                mTvRepeatResult.setText(sb.toString());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                sb.append(integer).append("\n");
            }
        });
    }
}

