package com.example.admin.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.preference.PreferenceActivity;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private List<Sample> sampleList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化SampleList
        initSample();
        SampleAdapter adapter = new SampleAdapter(MainActivity.this, R.layout.sample, sampleList);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);


        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectLeakedSqlLiteObjects().penaltyLog().penaltyDeath().build());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //为悬浮按钮设置点击事件
        findViewById(R.id.fab).setOnClickListener(this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //为头像和头像下的两行文字设置点击事件，点击跳转到登录界面
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View drawview = navigationView.inflateHeaderView(R.layout.nav_header_main);
        drawview.findViewById(R.id.imageView).setOnClickListener(this);
        drawview.findViewById(R.id.textView1).setOnClickListener(this);
        drawview.findViewById(R.id.textView2).setOnClickListener(this);


        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageView:
            case R.id.textView1:
            case R.id.textView2:
                Intent intent = new Intent(MainActivity.this, LogoActivity.class);
                startActivity(intent);
                break;
            case R.id.fab:
                intent = new Intent(MainActivity.this, ImageSettingActivity.class);
                startActivity(intent);
                break;
        }
    }


    //记录SampleList个数
    int count = 1;

    //实时生成时间，生成格式为xxxx:xx:xx xx:xx:xx
    SimpleDateFormat format = new SimpleDateFormat("yyyy:MM:dd hh:mm:ss");
    Date date = new Date();

    private void initSample() {
        for (int i = 0; i < 10; i++) {

            Sample sample = new Sample(R.drawable.a1, "#" + count++, 132 + "个", format.format(date));
            sampleList.add(sample);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
