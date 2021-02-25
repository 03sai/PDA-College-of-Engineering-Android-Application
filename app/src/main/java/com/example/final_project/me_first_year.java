package com.example.final_project;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class me_first_year extends AppCompatActivity implements View.OnClickListener {

    private CardView tt_me1,syllabus_me1,qp_me1,ebook_me1;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_first_year);



        tt_me1=findViewById(R.id.tt_me1);
        syllabus_me1=findViewById(R.id.syllabus_me1);
        qp_me1=findViewById(R.id.qp_me1);
        ebook_me1=findViewById(R.id.ebook_me1);


        tt_me1.setOnClickListener(this);
        syllabus_me1.setOnClickListener(this);
        qp_me1.setOnClickListener(this);
        ebook_me1.setOnClickListener(this);

        me_first_year.context= getApplicationContext();
    }

    public static Context getAppContext(){return me_first_year.context;}

    public static int getPx(Context context,int dimensionDp){
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dimensionDp * density + 0.5f);
    }

    @Override

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tt_me1:
                startActivity(new Intent(this, tt_me1.class));
                break;
            case R.id.syllabus_me1:
                startActivity(new Intent(this, syllabus_me1.class));
                break;
            case R.id.qp_me1:
                startActivity(new Intent(this, qp_me1.class));
                break;
            case R.id.ebook_me1:
                startActivity(new Intent(this, ebook_me1.class));
                break;

        }
    }
}
