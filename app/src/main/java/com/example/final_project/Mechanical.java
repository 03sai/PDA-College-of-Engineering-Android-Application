package com.example.final_project;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

public class Mechanical extends AppCompatActivity implements View.OnClickListener{




    private CardView bt_me1,bt_me2,bt_me3,bt_me4;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mechanical);

        bt_me1=findViewById(R.id.button_me1);
        bt_me2=findViewById(R.id.button_me2);
        bt_me3=findViewById(R.id.button_me3);
        bt_me4=findViewById(R.id.button_me4);

        bt_me1.setOnClickListener(this);
        bt_me2.setOnClickListener(this);
        bt_me3.setOnClickListener(this);
        bt_me4.setOnClickListener(this);

        Mechanical.context= getApplicationContext();




    }

    public static Context getAppContext(){return Mechanical.context;}

    public static int getPx(Context context,int dimensionDp){
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dimensionDp * density + 0.5f);
    }


    @Override

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_me1:
                startActivity(new Intent(this,me_first_year.class));
                break;
            case R.id.button_me2:
                startActivity(new Intent(this,me_second_year.class));
                break;
            case R.id.button_me3:
                startActivity(new Intent(this, me_third_year.class));
                break;
            case R.id.button_me4:
                startActivity(new Intent(this, me_fourth_year.class));
                break;

        }
    }
}
