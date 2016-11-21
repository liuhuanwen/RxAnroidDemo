package com.liuhw.rxanroiddemo;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.liuhw.rxanroiddemo.creating.CreateActivity;
import com.liuhw.rxanroiddemo.creating.DeferActivity;
import com.liuhw.rxanroiddemo.creating.EmptyAndErrorAndNeverActivity;
import com.liuhw.rxanroiddemo.creating.FromActivity;
import com.liuhw.rxanroiddemo.creating.IntervalActivity;
import com.liuhw.rxanroiddemo.creating.JustActivity;
import com.liuhw.rxanroiddemo.creating.RangeAcitivity;
import com.liuhw.rxanroiddemo.creating.RepeatActivity;
import com.liuhw.rxanroiddemo.creating.TimerActivity;

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
        Class classes = null;
        switch (view.getId()) {
            case R.id.btn_operator_create:
                classes = CreateActivity.class;
                break;
            case R.id.btn_operator_defer:
                classes = DeferActivity.class;
                break;
            case R.id.btn_operator_empty_never_throw:
                classes = EmptyAndErrorAndNeverActivity.class;
                break;
            case R.id.btn_operator_from:
                classes = FromActivity.class;
                break;
            case R.id.btn_operator_interval:
                classes = IntervalActivity.class;
                break;
            case R.id.btn_operator_just:
                classes = JustActivity.class;
                break;
            case R.id.btn_operator_range:
                classes = RangeAcitivity.class;
                break;
            case R.id.btn_operator_repeat:
                classes = RepeatActivity.class;
                break;
            case R.id.btn_operator_timer:
                classes = TimerActivity.class;
                break;
        }
        startActivity(new Intent(this, classes));
    }
}
