package com.example.final_project;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

public class Electronics_and_Communication extends AppCompatActivity implements View.OnClickListener{




   private CardView bt_ec1,bt_ec2,bt_ec3,bt_ec4;
   private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronics_and__communication);

        bt_ec1=findViewById(R.id.button_ec1);
        bt_ec2=findViewById(R.id.button_ec2);
        bt_ec3=findViewById(R.id.button_ec3);
        bt_ec4=findViewById(R.id.button_ec4);

        bt_ec1.setOnClickListener(this);
        bt_ec2.setOnClickListener(this);
        bt_ec3.setOnClickListener(this);
        bt_ec4.setOnClickListener(this);

        Electronics_and_Communication.context= getApplicationContext();




    }

    public static Context getAppContext(){return Electronics_and_Communication.context;}

    public static int getPx(Context context,int dimensionDp){
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dimensionDp * density + 0.5f);
    }


    @Override

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_ec1:
                startActivity(new Intent(this,ec_first_year.class));
                break;
            case R.id.button_ec2:
                startActivity(new Intent(this,ec_second_year.class));
                break;
            case R.id.button_ec3:
                startActivity(new Intent(this, ec_third_year.class));
                break;
            case R.id.button_ec4:
                startActivity(new Intent(this, ec_fourth_year.class));
                break;

        }
    }
}
