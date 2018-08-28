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
import android.widget.Toast;

import AndroidServer.User;

public class Register_fragment extends Fragment {

    private Button register;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.register_fragment, container, false);
        register = view.findViewById(R.id.register);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getActivity() != null) {
                    EditText useraccount = getActivity().findViewById(R.id.user_account);
                    EditText userpassword = getActivity().findViewById(R.id.user_password);
                    String UserAccount = useraccount.getText().toString();
                    String UserPassword = userpassword.getText().toString();
                    //将用户账号密码存入User对象中
                    User user = new User(UserAccount, UserPassword);
                    //尝试注册
                    TryRegister tryRegister = new TryRegister();
                    String isSuccessRegister = tryRegister.run(user);

                    if (isSuccessRegister.equals("Success")) {
                        if (getActivity() != null) {
                            Toast.makeText(getActivity().getApplicationContext(), "注册成功", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        if (getActivity() != null) {
                            Toast.makeText(getActivity().getApplicationContext(), "注册失败", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        });
    }


}
