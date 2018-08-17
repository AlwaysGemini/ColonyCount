package com.example.admin.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SampleAdapter extends ArrayAdapter<Sample> {

    private int resourceId;

    public SampleAdapter(Context context, int textViewResourceId, List<Sample> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Sample sample = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        ImageView sampleImage = view.findViewById(R.id.sample_imageId);
        TextView sampleserialNumber = view.findViewById(R.id.sample_serialNumber);
        TextView sampleCFU = view.findViewById(R.id.sample_CFU);
        TextView sampledate = view.findViewById(R.id.sample_date);
        sampleImage.setImageResource(sample.getImageId());
        sampleserialNumber.setText(sample.getSerialNumber());
        sampleCFU.setText(sample.getCFU());
        sampledate.setText(sample.getDate());
        return view;

    }
}
