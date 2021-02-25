package com.example.final_project;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class cs_fourth_year extends AppCompatActivity implements View.OnClickListener{

    private CardView tt_cs4,syllabus_cs4,qp_cs4,ebook_cs4;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cs_fourth_year);

        tt_cs4=findViewById(R.id.tt_cs4);
        syllabus_cs4=findViewById(R.id.syllabus_cs4);
        qp_cs4=findViewById(R.id.qp_cs4);
        ebook_cs4=findViewById(R.id.ebook_cs4);


        tt_cs4.setOnClickListener(this);
        syllabus_cs4.setOnClickListener(this);
        qp_cs4.setOnClickListener(this);
        ebook_cs4.setOnClickListener(this);

        cs_fourth_year.context= getApplicationContext();
    }

public static Context getAppContext(){return cs_fourth_year.context;}

public static int getPx(Context context,int dimensionDp){
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dimensionDp * density + 0.5f);
        }

@Override

public void onClick(View view) {
        switch (view.getId()) {
        case R.id.tt_cs4:
        startActivity(new Intent(this, tt_cs4.class));
        break;
        case R.id.syllabus_cs4:
        startActivity(new Intent(this, syllabus_cs4.class));
        break;
        case R.id.qp_cs4:
        startActivity(new Intent(this, qp_cs4.class));
        break;
        case R.id.ebook_cs4:
        startActivity(new Intent(this, ebook_cs4.class));
        break;

        }
        }
}