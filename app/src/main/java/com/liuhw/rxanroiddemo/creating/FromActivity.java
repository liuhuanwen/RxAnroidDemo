package com.liuhw.rxanroiddemo.creating;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.liuhw.rxanroiddemo.BaseActivity;
import com.liuhw.rxanroiddemo.R;

import rx.Observable;
import rx.Subscriber;

public class FromActivity extends BaseActivity {

    private Observable<Integer> obs;
    private StringBuilder sb = new StringBuilder();
    private TextView mTvFromResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from);
        if (mActionBar != null) {
            mActionBar.setTitle("from operator");
        }
        mTvFromResult = (TextView) findViewById(R.id.tv_from_result);
    }

    public void onClick(View view) {
        Integer[] scores = {60, 70, 80, 90, 100};
        obs = Observable.from(scores);
        obs.subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                sb.append("onCompleted").append("\n");
                mTvFromResult.setText(sb.toString());
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
