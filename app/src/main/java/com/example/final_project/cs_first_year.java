package com.example.final_project;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class cs_first_year extends AppCompatActivity implements View.OnClickListener {

    private CardView tt_cs1,syllabus_cs1,qp_cs1,ebook_cs1;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cs_first_year);




        tt_cs1=findViewById(R.id.tt_cs1);
        syllabus_cs1=findViewById(R.id.syllabus_cs1);
        qp_cs1=findViewById(R.id.qp_cs1);
        ebook_cs1=findViewById(R.id.ebook_cs1);


        tt_cs1.setOnClickListener(this);
        syllabus_cs1.setOnClickListener(this);
        qp_cs1.setOnClickListener(this);
        ebook_cs1.setOnClickListener(this);

        cs_first_year.context= getApplicationContext();

    }

    public static Context getAppContext(){return cs_first_year.context;}

    public static int getPx(Context context,int dimensionDp){
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dimensionDp * density + 0.5f);
    }

    @Override

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tt_cs1:
                startActivity(new Intent(this, tt_cs1.class));
                break;
            case R.id.syllabus_cs1:
                startActivity(new Intent(this, syllabus_cs1.class));
                break;
            case R.id.qp_cs1:
                startActivity(new Intent(this, qp_cs1.class));
                break;
            case R.id.ebook_cs1:
                startActivity(new Intent(this, ebook_cs1.class));
                break;

        }
    }
}
