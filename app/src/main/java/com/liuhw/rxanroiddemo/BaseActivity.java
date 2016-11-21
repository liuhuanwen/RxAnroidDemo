package com.liuhw.rxanroiddemo;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by liuhw on 2016/11/21.
 * activity 基类
 */

public class BaseActivity extends AppCompatActivity {

    protected ActionBar mActionBar;

    @Override
    public void setContentView(@LayoutRes int layoutResId) {
        super.setContentView(layoutResId);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        mActionBar = getSupportActionBar();
    }

}
