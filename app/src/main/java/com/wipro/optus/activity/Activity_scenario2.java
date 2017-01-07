package com.wipro.optus.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.gms.maps.model.LatLng;
import com.wipro.optus.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Activity_scenario2 extends AppCompatActivity {

    private Button btnNavigate;
    private Spinner spnDestinations;
    private HashMap<String, LatLng> destinationMap;
    private ArrayAdapter<String> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenario2);
        initView();
    }

    private void initView() {
        btnNavigate = (Button) findViewById(R.id.btn_navigate);
        spnDestinations = (Spinner) findViewById(R.id.spn_destinations);

        btnNavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_scenario2.this, MapsActivity.class);
                intent.putExtra("Destination", destinationMap.get(spnDestinations.getSelectedItem()));
                startActivity(intent);
            }
        });

        destinationMap = new HashMap<>(4);
        destinationMap.put("Sydney", new LatLng(-33.868, 151.207));
        destinationMap.put("Melbourne", new LatLng(-37.814, 144.963));
        destinationMap.put("Brisbane", new LatLng(-27.468, 153.028));
        destinationMap.put("Perth", new LatLng(-31.952, 115.861));

        List<String> destinationList = new ArrayList<>();
        for (String place : destinationMap.keySet()) {
            destinationList.add(place);
        }

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, destinationList);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spnDestinations.setAdapter(adapter);
    }
}
