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

public class RangeActivity extends BaseActivity {

    private TextView mTvRangeResult;
    private StringBuilder sb = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_range);
        if (mActionBar != null) {
            mActionBar.setTitle("range operator");
        }
        mTvRangeResult = (TextView) findViewById(R.id.tv_range_result);
    }

    public void onClick(View view) {
        Observable<Integer> obs = Observable.range(100, 5, AndroidSchedulers.mainThread());
        obs.subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                sb.append("onCompleted").append("\n");
                mTvRangeResult.setText(sb.toString());
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
