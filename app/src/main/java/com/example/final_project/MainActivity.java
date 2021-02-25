package com.example.final_project;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.KeyEvent;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private WebView webview;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);









        //Notification

        if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.P){

            NotificationChannel channel=
                    new NotificationChannel("MyNotifications","MyNotifications", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);


        }


        FirebaseMessaging.getInstance().subscribeToTopic("general")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg = "Succesfull";
                        if (!task.isSuccessful()) {
                            msg = "Failed";
                        }

                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });



        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);



        webview=(WebView) findViewById(R.id.pda_web);
        WebSettings websettings= webview.getSettings();
        websettings.setJavaScriptEnabled(true);
        webview.loadUrl("https://03sai.github.io/pdaceg.github.io/");
        webview.setWebViewClient(new WebViewClient());

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
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




    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.cs) {
            Intent start_cs=new Intent(MainActivity.this,Computer_Science.class);
            startActivity(start_cs);

        } else if (id == R.id.mech) {
            Intent start_me=new Intent(MainActivity.this,Mechanical.class);
            startActivity(start_me);

        } else if (id == R.id.EC) {
            Intent start_ec=new Intent(MainActivity.this,Electronics_and_Communication.class);
            startActivity(start_ec);

        } else if (id == R.id.cv) {
            Intent start_cv=new Intent(MainActivity.this,Civil.class);
            startActivity(start_cv);

        } else if (id == R.id.it) {
            Intent start_it=new Intent(MainActivity.this,Instrumentation_and_technology.class);
            startActivity(start_it);

        } else if (id == R.id.is) {
            Intent start_is=new Intent(MainActivity.this,Information_science.class);
            startActivity(start_is);



        } else if (id == R.id.calci){
            Intent start_calci=new Intent(MainActivity.this,cgpa_calculator.class);
            startActivity(start_calci);
        } else if (id == R.id.calci_cgpa){
            Intent start_calci_cgpa=new Intent(MainActivity.this,cgpa_real.class);
            startActivity(start_calci_cgpa);
        } else if (id == R.id.calender){
            Intent start_calender=new Intent(MainActivity.this,calender_of_events.class);
            startActivity(start_calender);
        }  else if (id == R.id.eduwize){
            Intent start_eduwize=new Intent(MainActivity.this,eduwize.class);
            startActivity(start_eduwize);
        }  else if (id == R.id.about){
            Intent start_about=new Intent(MainActivity.this,About.class);
            startActivity(start_about);
        }

          else if (id == R.id.automobile){
            Intent start_au=new Intent(MainActivity.this,Automobile.class);
            startActivity(start_au);
        };

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if((keyCode==KeyEvent.KEYCODE_BACK)&& webview.canGoBack()){
            webview.canGoBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
