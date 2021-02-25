package com.example.final_project;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

public class Information_science extends AppCompatActivity implements View.OnClickListener{




    private CardView bt_is1,bt_is2,bt_is3,bt_is4;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_science);

        bt_is1=findViewById(R.id.button_is1);
        bt_is2=findViewById(R.id.button_is2);
        bt_is3=findViewById(R.id.button_is3);
        bt_is4=findViewById(R.id.button_is4);

        bt_is1.setOnClickListener(this);
        bt_is2.setOnClickListener(this);
        bt_is3.setOnClickListener(this);
        bt_is4.setOnClickListener(this);

        Information_science.context= getApplicationContext();




    }

    public static Context getAppContext(){return Information_science.context;}

    public static int getPx(Context context,int diisnsionDp){
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (diisnsionDp * density + 0.5f);
    }


    @Override

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_is1:
                startActivity(new Intent(this,is_first_year.class));
                break;
            case R.id.button_is2:
                startActivity(new Intent(this,is_second_year.class));
                break;
            case R.id.button_is3:
                startActivity(new Intent(this, is_third_year.class));
                break;
            case R.id.button_is4:
                startActivity(new Intent(this, is_fourth_year.class));
                break;

        }
    }
}
