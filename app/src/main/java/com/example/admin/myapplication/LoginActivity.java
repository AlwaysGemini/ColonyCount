package com.example.admin.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import AndroidServer.User;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById(R.id.bt_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //获取到用户输入的账号密码
                EditText editText1 = findViewById(R.id.et_1);
                EditText editText2 = findViewById(R.id.et_2);
                String UserAccount = editText1.getText().toString();
                String UserPassword = editText2.getText().toString();
                //将用户账号密码存入User对象中
                User user = new User(UserAccount,UserPassword);

                //尝试登陆
                TryLogin tryLogin = new TryLogin();
                String isSuccessLogin = tryLogin.run(user);
                if(isSuccessLogin.equals("Success")){
                    Toast.makeText(getApplicationContext(),"登陆成功",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(),"登陆失败",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
