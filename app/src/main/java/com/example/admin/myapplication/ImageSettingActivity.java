package com.example.admin.myapplication;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ImageSettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_setting);
        final AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(this);
        final AlertDialog.Builder alertDialog3 = new AlertDialog.Builder(this);
        final View view2 = View.inflate(this, R.layout.other_setting_layout, null);
        final View view3 = View.inflate(this, R.layout.other_setting_layout2, null);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog2.setTitle("参数设置").setIcon(R.mipmap.ic_launcher).setView(view2).create();
                final AlertDialog show = alertDialog2.show();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog3.setTitle("选择操作").setIcon(R.mipmap.ic_launcher).setView(view3).create();
                final AlertDialog show = alertDialog3.show();
            }
        });

    }
}
