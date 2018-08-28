package com.example.admin.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import AndroidServer.User;

public class Login_fragment extends Fragment implements View.OnClickListener {

    private Button login;
    private TextView register;
    private Register_fragment register_fragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment, container, false);
        login = view.findViewById(R.id.login);
        register = view.findViewById(R.id.register);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        login.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //点击登录按钮，则尝试登录
            case R.id.login:
                //获取到用户输入的账号密码
                if (getActivity() != null) {
                    EditText useraccount = getActivity().findViewById(R.id.user_account);
                    EditText userpassword = getActivity().findViewById(R.id.user_password);
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
                        if (getActivity() != null) {
                            Toast.makeText(getActivity().getApplicationContext(), "登陆成功", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        if (getActivity() != null) {
                            Toast.makeText(getActivity().getApplicationContext(), "登陆失败，请检查账号密码是否正确", Toast.LENGTH_LONG).show();
                        }
                    }
                }
                break;
            //点击注册按钮，则跳转到注册界面
            case R.id.register:
                if (register_fragment == null) {
                    register_fragment = new Register_fragment();
                }
                if (getFragmentManager() != null) {
                    getFragmentManager().beginTransaction().replace(R.id.login_container, register_fragment).addToBackStack(null).commitAllowingStateLoss();
                }
                break;
        }
    }
}
