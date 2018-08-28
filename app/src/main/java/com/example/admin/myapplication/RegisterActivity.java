package com.example.admin.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import AndroidServer.User;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_container);
        Register_fragment register_fragment = new Register_fragment();
        getSupportFragmentManager().beginTransaction().add(R.id.login_container, register_fragment).commitAllowingStateLoss();
    }
}
