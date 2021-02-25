package com.example.final_project;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class cv_third_year extends AppCompatActivity implements View.OnClickListener{


    private CardView tt_cv3,syllabus_cv3,qp_cv3,ebook_cv3;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv_third_year);


        tt_cv3=findViewById(R.id.tt_cv3);
        syllabus_cv3=findViewById(R.id.syllabus_cv3);
        qp_cv3=findViewById(R.id.qp_cv3);
        ebook_cv3=findViewById(R.id.ebook_cv3);


        tt_cv3.setOnClickListener(this);
        syllabus_cv3.setOnClickListener(this);
        qp_cv3.setOnClickListener(this);
        ebook_cv3.setOnClickListener(this);

        cv_third_year.context= getApplicationContext();
    }

    public static Context getAppContext(){return cv_third_year.context;}

    public static int getPx(Context context,int dimensionDp){
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dimensionDp * density + 0.5f);
    }

    @Override

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tt_cv3:
                startActivity(new Intent(this, tt_cv3.class));
                break;
            case R.id.syllabus_cv3:
                startActivity(new Intent(this, syllabus_cv3.class));
                break;
            case R.id.qp_cv3:
                startActivity(new Intent(this, qp_cv3.class));
                break;
            case R.id.ebook_cv3:
                startActivity(new Intent(this, ebook_cv3.class));
                break;

        }
    }
}
