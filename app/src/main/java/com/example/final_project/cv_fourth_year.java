package com.example.final_project;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class cv_fourth_year extends AppCompatActivity implements View.OnClickListener{

    private CardView tt_cv4,syllabus_cv4,qp_cv4,ebook_cv4;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv_fourth_year);

        tt_cv4=findViewById(R.id.tt_cv4);
        syllabus_cv4=findViewById(R.id.syllabus_cv4);
        qp_cv4=findViewById(R.id.qp_cv4);
        ebook_cv4=findViewById(R.id.ebook_cv4);


        tt_cv4.setOnClickListener(this);
        syllabus_cv4.setOnClickListener(this);
        qp_cv4.setOnClickListener(this);
        ebook_cv4.setOnClickListener(this);

        cv_fourth_year.context= getApplicationContext();
    }

    public static Context getAppContext(){return cv_fourth_year.context;}

    public static int getPx(Context context,int dimensionDp){
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dimensionDp * density + 0.5f);
    }

    @Override

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tt_cv4:
                startActivity(new Intent(this, tt_cv4.class));
                break;
            case R.id.syllabus_cv4:
                startActivity(new Intent(this, syllabus_cv4.class));
                break;
            case R.id.qp_cv4:
                startActivity(new Intent(this, qp_cv4.class));
                break;
            case R.id.ebook_cv4:
                startActivity(new Intent(this, ebook_cv4.class));
                break;

        }
    }
}
