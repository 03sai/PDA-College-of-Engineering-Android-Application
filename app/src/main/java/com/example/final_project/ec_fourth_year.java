package com.example.final_project;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class ec_fourth_year extends AppCompatActivity implements View.OnClickListener{


    private CardView tt_ec4,syllabus_ec4,qp_ec4,ebook_ec4;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ec_fourth_year);


        tt_ec4=findViewById(R.id.tt_ec4);
        syllabus_ec4=findViewById(R.id.syllabus_ec4);
        qp_ec4=findViewById(R.id.qp_ec4);
        ebook_ec4=findViewById(R.id.ebook_ec4);


        tt_ec4.setOnClickListener(this);
        syllabus_ec4.setOnClickListener(this);
        qp_ec4.setOnClickListener(this);
        ebook_ec4.setOnClickListener(this);

        ec_fourth_year.context= getApplicationContext();
    }



    public static Context getAppContext(){return ec_fourth_year.context;}

    public static int getPx(Context context,int dimensionDp){
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dimensionDp * density + 0.5f);
    }

    @Override

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tt_ec4:
                startActivity(new Intent(this, tt_ec4.class));
                break;
            case R.id.syllabus_ec4:
                startActivity(new Intent(this, syllabus_ec4.class));
                break;
            case R.id.qp_ec4:
                startActivity(new Intent(this, qp_ec4.class));
                break;
            case R.id.ebook_ec4:
                startActivity(new Intent(this, ebook_ec4.class));
                break;

        }
    }
}
