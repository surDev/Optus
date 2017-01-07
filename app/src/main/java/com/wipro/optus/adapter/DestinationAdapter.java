package com.wipro.optus.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by SO356253 on 03-Jan-17.
 */
public class DestinationAdapter extends ArrayAdapter {
    List<String> destList;
    private Context context;

    public DestinationAdapter(Context context, int textViewResourceId,List<String> objects) {
        super(context, textViewResourceId);
        this.context = context;
        this.destList = objects;
    }





}
