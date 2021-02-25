package com.example.final_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import static java.lang.Thread.sleep;

public class Splash extends AppCompatActivity {

    ImageView splashimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splashimg=(ImageView) findViewById(R.id.splash_img);

        Animation splashanim= AnimationUtils.loadAnimation(this,R.anim.splash_anim);

        splashimg.startAnimation(splashanim);


        Thread mythread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(3000);


                    Intent i=new Intent(Splash.this,MainActivity.class);
                    startActivity(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        mythread.start();




    }
}
