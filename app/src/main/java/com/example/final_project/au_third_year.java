package com.example.final_project;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class au_third_year extends AppCompatActivity implements View.OnClickListener {

    private CardView tt_au3,syllabus_au3,qp_au3,ebook_au3;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_au_third_year);



        tt_au3=findViewById(R.id.tt_au3);
        syllabus_au3=findViewById(R.id.syllabus_au3);
        qp_au3=findViewById(R.id.qp_au3);
        ebook_au3=findViewById(R.id.ebook_au3);


        tt_au3.setOnClickListener(this);
        syllabus_au3.setOnClickListener(this);
        qp_au3.setOnClickListener(this);
        ebook_au3.setOnClickListener(this);

        au_third_year.context= getApplicationContext();
    }

    public static Context getAppContext(){return au_third_year.context;}

    public static int getPx(Context context,int dimensionDp){
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dimensionDp * density + 0.5f);
    }

    @Override

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tt_au3:
                startActivity(new Intent(this, tt_au3.class));
                break;
            case R.id.syllabus_au3:
                startActivity(new Intent(this, syllabus_au3.class));
                break;
            case R.id.qp_au3:
                startActivity(new Intent(this, qp_au3.class));
                break;
            case R.id.ebook_au3:
                startActivity(new Intent(this, ebook_au3.class));
                break;

        }
    }
}
