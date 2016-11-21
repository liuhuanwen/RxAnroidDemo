package com.liuhw.rxanroiddemo.creating;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.liuhw.rxanroiddemo.BaseActivity;
import com.liuhw.rxanroiddemo.R;

import rx.Observable;
import rx.Subscriber;

/**
 * just 是最常见的操作符，用来创建一个observable
 * */
public class JustActivity extends BaseActivity {

    private TextView mTvJustResult;
    private StringBuilder sb = new StringBuilder();
    private Observable<Long> obs = Observable.just(System.currentTimeMillis());;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_just);
        if (mActionBar != null) {
            mActionBar.setTitle("just operator");
        }
        mTvJustResult = (TextView) findViewById(R.id.tv_just_result);
    }

    public void onClick(View view) {
        obs.subscribe(new Subscriber<Long>() {
            @Override
            public void onCompleted() {
                mTvJustResult.setText(sb.toString());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Long along) {
                sb.append(along).append("\n");
            }
        });
    }
}
