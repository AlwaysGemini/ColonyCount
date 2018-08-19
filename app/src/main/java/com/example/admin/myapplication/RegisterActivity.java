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
        setContentView(R.layout.activity_register);
        findViewById(R.id.register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText useraccount = findViewById(R.id.user_account);
                EditText userpassword = findViewById(R.id.user_password);
                String UserAccount = useraccount.getText().toString();
                String UserPassword = userpassword.getText().toString();
                //将用户账号密码存入User对象中
                User user = new User(UserAccount, UserPassword);
                //尝试注册
                TryRegister tryRegister = new TryRegister();
                String isSuccessRegister = tryRegister.run(user);
                if (isSuccessRegister.equals("Success")) {
                    Toast.makeText(getApplicationContext(), "注册成功", Toast.LENGTH_LONG).show();
                    //RegisterActivity.this.finish();
                } else {
                    Toast.makeText(getApplicationContext(), "注册失败", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
