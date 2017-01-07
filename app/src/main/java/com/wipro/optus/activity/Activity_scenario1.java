package com.wipro.optus.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wipro.optus.R;
import com.wipro.optus.adapter.ItemAdapter;
import com.wipro.optus.fragment.Fragment1;
import com.wipro.optus.interfaces.OnRecyclerItemClickListener;


public class Activity_scenario1 extends AppCompatActivity implements View.OnClickListener, OnRecyclerItemClickListener{

    private LinearLayout llButtonGroup;
    private FrameLayout fragmentContainer;
    private TextView txtResult;
    private Button btnRed;
    private Button btnGreen;
    private Button btnBlue;
    private RecyclerView mRecyclerView;
    private ItemAdapter itemAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenario1);
        initView();
    }

    private void initView() {
        llButtonGroup = (LinearLayout) findViewById(R.id.ll_button_group);
        fragmentContainer = (FrameLayout) findViewById(R.id.fragment_container);
        txtResult = (TextView) findViewById(R.id.txt_result);
        btnRed = (Button) findViewById(R.id.btn_red);
        btnGreen = (Button) findViewById(R.id.btn_green);
        btnBlue = (Button) findViewById(R.id.btn_blue);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_items);

        itemAdapter = new ItemAdapter(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(itemAdapter);

        btnRed.setOnClickListener(this);
        btnGreen.setOnClickListener(this);
        btnBlue.setOnClickListener(this);

        Fragment1 fragment = new Fragment1();
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment, "").commit();
    }

    @Override
    public void onClick(View v) {
        int color = 0;
        switch (v.getId()){
            case R.id.btn_red:
                color = getResources().getColor(R.color.red);
                break;
            case R.id.btn_green:
                color = getResources().getColor(R.color.green);
                break;
            case R.id.btn_blue:
                color = getResources().getColor(R.color.blue);
                break;
        }
        llButtonGroup.setBackgroundColor(color);
    }

    @Override
    public void onRecyclerItemSelected(int position) {
        txtResult.setText("Item "+(position+1));
    }
}
