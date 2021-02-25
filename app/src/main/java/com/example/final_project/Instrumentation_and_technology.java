package com.example.final_project;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

public class Instrumentation_and_technology extends AppCompatActivity implements View.OnClickListener{




    private CardView bt_it1,bt_it2,bt_it3,bt_it4;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrumentation_and_technology);

        bt_it1=findViewById(R.id.button_it1);
        bt_it2=findViewById(R.id.button_it2);
        bt_it3=findViewById(R.id.button_it3);
        bt_it4=findViewById(R.id.button_it4);

        bt_it1.setOnClickListener(this);
        bt_it2.setOnClickListener(this);
        bt_it3.setOnClickListener(this);
        bt_it4.setOnClickListener(this);

        Instrumentation_and_technology.context= getApplicationContext();




    }

    public static Context getAppContext(){return Instrumentation_and_technology.context;}

    public static int getPx(Context context,int dimensionDp){
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dimensionDp * density + 0.5f);
    }


    @Override

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_it1:
                startActivity(new Intent(this,it_first_year.class));
                break;
            case R.id.button_it2:
                startActivity(new Intent(this,it_second_year.class));
                break;
            case R.id.button_it3:
                startActivity(new Intent(this, it_third_year.class));
                break;
            case R.id.button_it4:
                startActivity(new Intent(this, it_fourth_year.class));
                break;

        }
    }
}
