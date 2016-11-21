package com.liuhw.rxanroiddemo.creating;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.liuhw.rxanroiddemo.BaseActivity;
import com.liuhw.rxanroiddemo.R;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func0;

/**
 * defer操作符，每一次订阅，会创建一个新的observable
 * */
public class DeferActivity extends BaseActivity {

    private TextView mTvDeferResult;
    private StringBuilder sb = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defer);
        if (mActionBar != null) {
            mActionBar.setTitle("defer operator");
        }
        mTvDeferResult = (TextView) findViewById(R.id.tv_defer_result);
    }

    public void onClick(View view) {
        Observable<Long> obs = Observable.defer(new Func0<Observable<Long>>() {
            @Override
            public Observable<Long> call() {
                return Observable.just(System.currentTimeMillis());
            }
        });
        obs.subscribe(new Subscriber<Long>() {
            @Override
            public void onCompleted() {
                mTvDeferResult.setText(sb.toString());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Long aLong) {
                sb.append(aLong).append("\n");
            }
        });
    }
}
