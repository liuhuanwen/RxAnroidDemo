package com.liuhw.rxanroiddemo.creating;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.liuhw.rxanroiddemo.BaseActivity;
import com.liuhw.rxanroiddemo.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

public class TimerActivity extends BaseActivity {

    private TextView mTvTimerResult;
    private StringBuilder sb = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        if (mActionBar != null) {
            mActionBar.setTitle("timer operator");
        }
        mTvTimerResult = (TextView) findViewById(R.id.tv_timer_result);
    }

    public void onClick(View view) {
        Observable<Long> obs = Observable.timer(1, TimeUnit.SECONDS, AndroidSchedulers.mainThread());
        obs.subscribe(new Subscriber<Long>() {
            @Override
            public void onCompleted() {
                sb.append("onCompleted").append("\n");
                mTvTimerResult.setText(sb.toString());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Long aLong) {
                sb.append("onNext:").append(aLong).append("\n");
                Toast.makeText(TimerActivity.this, "hello", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
