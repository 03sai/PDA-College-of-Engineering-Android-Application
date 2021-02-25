package com.example.final_project;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

public class Automobile extends AppCompatActivity implements View.OnClickListener{




    private CardView bt_au1,bt_au2,bt_au3,bt_au4;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_automobile);

        bt_au1=findViewById(R.id.button_au1);
        bt_au2=findViewById(R.id.button_au2);
        bt_au3=findViewById(R.id.button_au3);
        bt_au4=findViewById(R.id.button_au4);

        bt_au1.setOnClickListener(this);
        bt_au2.setOnClickListener(this);
        bt_au3.setOnClickListener(this);
        bt_au4.setOnClickListener(this);

        Automobile.context= getApplicationContext();




    }

    public static Context getAppContext(){return Automobile.context;}

    public static int getPx(Context context,int diaunsionDp){
        float densauy = context.getResources().getDisplayMetrics().density;
        return (int) (diaunsionDp * densauy + 0.5f);
    }


    @Override

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_au1:
                startActivity(new Intent(this,au_first_year.class));
                break;
            case R.id.button_au2:
                startActivity(new Intent(this,au_second_year.class));
                break;
            case R.id.button_au3:
                startActivity(new Intent(this, au_third_year.class));
                break;
            case R.id.button_au4:
                startActivity(new Intent(this, au_fourth_year.class));
                break;

        }
    }
}
