package com.liuhw.rxanroiddemo.creating;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.liuhw.rxanroiddemo.BaseActivity;
import com.liuhw.rxanroiddemo.R;

import rx.Observable;
import rx.Subscriber;

public class EmptyAndErrorAndNeverActivity extends BaseActivity {

    private Observable<String> obs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty_and_error_and_never);
        if (mActionBar != null) {
            mActionBar.setTitle("empty error never");
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_empty_observable:
                obs = Observable.empty();
                break;
            case R.id.btn_error_observable:
                obs = Observable.error(new Throwable("this is a error!"));
                break;
            case R.id.btn_never_observable:
                obs = Observable.never();
                break;
        }
        obs.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                Toast.makeText(EmptyAndErrorAndNeverActivity.this, "invoke onCompleted",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(EmptyAndErrorAndNeverActivity.this, e.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNext(String s) {
                Toast.makeText(EmptyAndErrorAndNeverActivity.this, s,
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
