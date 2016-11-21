package com.liuhw.rxanroiddemo;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (mActionBar != null) {
            mActionBar.setTitle("RxAndroidDemo");
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_operator_creating_observables:
                startActivity(new Intent(this, CreatingObservablesActivity.class));
                break;
            case R.id.btn_operator_transforming_bservables:
                break;
            case R.id.btn_operator_filtering_observables:
                break;
            case R.id.btn_operator_combining_observables:
                break;
            case R.id.btn_operator_error_handling:
                break;
            case R.id.btn_operator_observable_utility:
                break;
            case R.id.btn_operator_conditional_boolean:
                break;
            case R.id.btn_operator_mathematical_aggregate:
                break;
            case R.id.btn_operator_backpressure:
                break;
            case R.id.btn_operator_connectable_observable:
                break;
            case R.id.btn_operator_to_convert_observables:
                break;

        }
    }

}
