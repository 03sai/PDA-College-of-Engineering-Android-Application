package com.example.final_project;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class cv_first_year extends AppCompatActivity implements View.OnClickListener {

    private CardView tt_cv1,syllabus_cv1,qp_cv1,ebook_cv1;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv_first_year);




        tt_cv1=findViewById(R.id.tt_cv1);
        syllabus_cv1=findViewById(R.id.syllabus_cv1);
        qp_cv1=findViewById(R.id.qp_cv1);
        ebook_cv1=findViewById(R.id.ebook_cv1);


        tt_cv1.setOnClickListener(this);
        syllabus_cv1.setOnClickListener(this);
        qp_cv1.setOnClickListener(this);
        ebook_cv1.setOnClickListener(this);

        cv_first_year.context= getApplicationContext();

    }

    public static Context getAppContext(){return cv_first_year.context;}

    public static int getPx(Context context,int dimensionDp){
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dimensionDp * density + 0.5f);
    }

    @Override

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tt_cv1:
                startActivity(new Intent(this, tt_cv1.class));
                break;
            case R.id.syllabus_cv1:
                startActivity(new Intent(this, syllabus_cv1.class));
                break;
            case R.id.qp_cv1:
                startActivity(new Intent(this, qp_cv1.class));
                break;
            case R.id.ebook_cv1:
                startActivity(new Intent(this, ebook_cv1.class));
                break;

        }
    }
}
