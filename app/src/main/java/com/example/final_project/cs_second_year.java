package com.example.final_project;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class cs_second_year extends AppCompatActivity implements View.OnClickListener {


    private CardView tt_cs2,syllabus_cs2,qp_cs2,ebook_cs2;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cs_second_year);

        tt_cs2=findViewById(R.id.tt_cs2);
        syllabus_cs2=findViewById(R.id.syllabus_cs2);
        qp_cs2=findViewById(R.id.qp_cs2);
        ebook_cs2=findViewById(R.id.ebook_cs2);


        tt_cs2.setOnClickListener(this);
        syllabus_cs2.setOnClickListener(this);
        qp_cs2.setOnClickListener(this);
        ebook_cs2.setOnClickListener(this);

        cs_second_year.context= getApplicationContext();
    }

    public static Context getAppContext(){return cs_second_year.context;}

    public static int getPx(Context context,int dimensionDp){
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dimensionDp * density + 0.5f);
    }


    @Override

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tt_cs2:
                startActivity(new Intent(this, tt_cs2.class));
                break;
            case R.id.syllabus_cs2:
                startActivity(new Intent(this, syllabus_cs2.class));
                break;
            case R.id.qp_cs2:
                startActivity(new Intent(this, qp_cs2.class));
                break;
            case R.id.ebook_cs2:
                startActivity(new Intent(this, ebook_cs2.class));
                break;

        }
    }
}
