package com.example.admin.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import AndroidServer.User;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //获取到用户输入的账号密码
                EditText useraccount = findViewById(R.id.user_account);
                EditText userpassword = findViewById(R.id.user_password);
                String UserAccount = useraccount.getText().toString();
                String UserPassword = userpassword.getText().toString();
                //将用户账号密码存入User对象中
                User user = new User(UserAccount, UserPassword);

                //尝试登陆
                TryLogin tryLogin = new TryLogin();
                //运行登录线程，并等待接受服务器发来的结果
                String isSuccessLogin = tryLogin.run(user);
                //如果结果是Success则登录成功，返回主界面；否则失败，提示检查账号密码是否正确
                if (isSuccessLogin.equals("Success")) {
                    Toast.makeText(getApplicationContext(), "登陆成功", Toast.LENGTH_LONG).show();
                    LoginActivity.this.finish();
                } else {
                    Toast.makeText(getApplicationContext(), "登陆失败，请检查账号密码是否正确", Toast.LENGTH_LONG).show();
                }
            }
        });

        //为注册按钮设置点击事件，点击跳转到注册界面
        findViewById(R.id.register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
