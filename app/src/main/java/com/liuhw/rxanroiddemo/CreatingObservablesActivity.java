package com.liuhw.rxanroiddemo;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.liuhw.rxanroiddemo.creating.CreateActivity;

public class CreatingObservablesActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creating_observables);
        if (mActionBar != null) {
            mActionBar.setTitle("Creating Observables");
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_operator_create:
                startActivity(new Intent(this, CreateActivity.class));
                break;
            case R.id.btn_operator_defer:
                break;
            case R.id.btn_operator_empty_never_throw:
                break;
            case R.id.btn_operator_from:
                break;
            case R.id.btn_operator_interval:
                break;
            case R.id.btn_operator_just:
                break;
            case R.id.btn_operator_range:
                break;
            case R.id.btn_operator_repeat:
                break;
            case R.id.btn_operator_start:
                break;
            case R.id.btn_operator_timer:
                break;
        }
    }
}