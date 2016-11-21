package com.liuhw.rxanroiddemo.creating;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.liuhw.rxanroiddemo.BaseActivity;
import com.liuhw.rxanroiddemo.R;

public class CreateActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        if (mActionBar != null) {
            mActionBar.setTitle("create operator");
        }
    }
}
