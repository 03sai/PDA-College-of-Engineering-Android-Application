package com.example.final_project;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

public class Computer_Science extends AppCompatActivity implements View.OnClickListener{

    private CardView bt_cs1,bt_cs2,bt_cs3,bt_cs4;
    private static Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer__science);



        bt_cs1=findViewById(R.id.button_cs1);
        bt_cs2=findViewById(R.id.button_cs2);
        bt_cs3=findViewById(R.id.button_cs3);
        bt_cs4=findViewById(R.id.button_cs4);

        bt_cs1.setOnClickListener(this);
        bt_cs2.setOnClickListener(this);
        bt_cs3.setOnClickListener(this);
        bt_cs4.setOnClickListener(this);

        Computer_Science.context= getApplicationContext();
    }


    public static Context getAppContext(){return Computer_Science.context;}

    public static int getPx(Context context,int dimensionDp){
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dimensionDp * density + 0.5f);
    }


    @Override

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_cs1:
                startActivity(new Intent(this,cs_first_year.class));
                break;
            case R.id.button_cs2:
                startActivity(new Intent(this,cs_second_year.class));
                break;
            case R.id.button_cs3:
                startActivity(new Intent(this, cs_third_year.class));
                break;
            case R.id.button_cs4:
                startActivity(new Intent(this, cs_fourth_year.class));
                break;

        }
    }
}
