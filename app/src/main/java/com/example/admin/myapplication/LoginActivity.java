package com.example.admin.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_container);
        Login_fragment login_fragment = new Login_fragment();
        getSupportFragmentManager().beginTransaction().add(R.id.login_container, login_fragment).commitAllowingStateLoss();
    }
}
