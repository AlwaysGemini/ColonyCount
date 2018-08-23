package com.example.admin.myapplication;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ImageSettingActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_setting);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        final AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(this);
        final AlertDialog.Builder alertDialog3 = new AlertDialog.Builder(this);
        final View view2 = View.inflate(this, R.layout.other_setting_layout, null);
        final View view3 = View.inflate(this, R.layout.other_setting_layout2, null);
        switch (view.getId()){
            case R.id.button2:
                alertDialog2.setTitle("参数设置").setIcon(R.mipmap.ic_launcher).setView(view2).create();
                final AlertDialog show1 = alertDialog2.show();
                break;
            case R.id.button3:
                alertDialog3.setTitle("选择操作").setIcon(R.mipmap.ic_launcher).setView(view3).create();
                final AlertDialog show2 = alertDialog3.show();
                break;
        }
    }
}
