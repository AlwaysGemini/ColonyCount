package com.example.admin.myapplication;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class LogoActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);


        ImageView imageView = findViewById(R.id.logo);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(ObjectAnimator.ofFloat(imageView, "alpha", 0, 1),
                //ObjectAnimator.ofFloat(imageView,"rotation",360),
                ObjectAnimator.ofFloat(imageView, "scaleX", 0, 0.8f),
                ObjectAnimator.ofFloat(imageView, "scaleY", 0, 0.8f)
        );
        set.setDuration(2000).start();

        findViewById(R.id.toLogin).setOnClickListener(this);
        findViewById(R.id.toRegister).setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toLogin:
                Intent intent = new Intent(LogoActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.toRegister:
                intent = new Intent(LogoActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }
}
