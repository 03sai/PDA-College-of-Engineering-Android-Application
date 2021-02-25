package com.example.final_project;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class au_second_year extends AppCompatActivity implements View.OnClickListener {

    private CardView tt_au2,syllabus_au2,qp_au2,ebook_au2;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_au_second_year);



        tt_au2=findViewById(R.id.tt_au2);
        syllabus_au2=findViewById(R.id.syllabus_au2);
        qp_au2=findViewById(R.id.qp_au2);
        ebook_au2=findViewById(R.id.ebook_au2);


        tt_au2.setOnClickListener(this);
        syllabus_au2.setOnClickListener(this);
        qp_au2.setOnClickListener(this);
        ebook_au2.setOnClickListener(this);

        au_second_year.context= getApplicationContext();
    }

    public static Context getAppContext(){return au_second_year.context;}

    public static int getPx(Context context,int dimensionDp){
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dimensionDp * density + 0.5f);
    }

    @Override

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tt_au2:
                startActivity(new Intent(this, tt_au2.class));
                break;
            case R.id.syllabus_au2:
                startActivity(new Intent(this, syllabus_au2.class));
                break;
            case R.id.qp_au2:
                startActivity(new Intent(this, qp_au2.class));
                break;
            case R.id.ebook_au2:
                startActivity(new Intent(this, ebook_au2.class));
                break;

        }
    }
}
