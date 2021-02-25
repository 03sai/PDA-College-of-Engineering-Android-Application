package com.example.final_project;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class ec_third_year extends AppCompatActivity implements View.OnClickListener{


    private CardView tt_ec3,syllabus_ec3,qp_ec3,ebook_ec3;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ec_third_year);


        tt_ec3=findViewById(R.id.tt_ec3);
        syllabus_ec3=findViewById(R.id.syllabus_ec3);
        qp_ec3=findViewById(R.id.qp_ec3);
        ebook_ec3=findViewById(R.id.ebook_ec3);


        tt_ec3.setOnClickListener(this);
        syllabus_ec3.setOnClickListener(this);
        qp_ec3.setOnClickListener(this);
        ebook_ec3.setOnClickListener(this);

        ec_third_year.context= getApplicationContext();
    }



    public static Context getAppContext(){return ec_third_year.context;}

    public static int getPx(Context context,int dimensionDp){
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dimensionDp * density + 0.5f);
    }

    @Override

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tt_ec3:
                startActivity(new Intent(this, tt_ec3.class));
                break;
            case R.id.syllabus_ec3:
                startActivity(new Intent(this, syllabus_ec3.class));
                break;
            case R.id.qp_ec3:
                startActivity(new Intent(this, qp_ec3.class));
                break;
            case R.id.ebook_ec3:
                startActivity(new Intent(this, ebook_ec3.class));
                break;

        }
    }
}
