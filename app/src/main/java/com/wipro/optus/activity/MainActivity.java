package com.wipro.optus.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wipro.optus.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnScenario1;
    private Button btnScenario2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btnScenario1 = (Button) findViewById(R.id.btn_scenario_1);
        btnScenario2 = (Button) findViewById(R.id.btn_scenario_2);

        btnScenario1.setOnClickListener(this);
        btnScenario2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.btn_scenario_1:
                intent.setClass(this, Activity_scenario1.class);
                break;

            case R.id.btn_scenario_2:
                intent.setClass(this, Activity_scenario2.class);
                break;
        }

        startActivity(intent);
    }
}
