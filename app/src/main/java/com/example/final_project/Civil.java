package com.example.final_project;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

public class Civil extends AppCompatActivity implements View.OnClickListener{




    private CardView bt_cv1,bt_cv2,bt_cv3,bt_cv4;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_civil);

        bt_cv1=findViewById(R.id.button_cv1);
        bt_cv2=findViewById(R.id.button_cv2);
        bt_cv3=findViewById(R.id.button_cv3);
        bt_cv4=findViewById(R.id.button_cv4);

        bt_cv1.setOnClickListener(this);
        bt_cv2.setOnClickListener(this);
        bt_cv3.setOnClickListener(this);
        bt_cv4.setOnClickListener(this);

        Civil.context= getApplicationContext();




    }

    public static Context getAppContext(){return Civil.context;}

    public static int getPx(Context context,int dimensionDp){
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dimensionDp * density + 0.5f);
    }


    @Override

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_cv1:
                startActivity(new Intent(this,cv_first_year.class));
                break;
            case R.id.button_cv2:
                startActivity(new Intent(this,cv_second_year.class));
                break;
            case R.id.button_cv3:
                startActivity(new Intent(this, cv_third_year.class));
                break;
            case R.id.button_cv4:
                startActivity(new Intent(this, cv_fourth_year.class));
                break;

        }
    }
}
