package com.example.final_project;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class au_first_year extends AppCompatActivity implements View.OnClickListener {

    private CardView tt_au1,syllabus_au1,qp_au1,ebook_au1;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_au_first_year);



        tt_au1=findViewById(R.id.tt_au1);
        syllabus_au1=findViewById(R.id.syllabus_au1);
        qp_au1=findViewById(R.id.qp_au1);
        ebook_au1=findViewById(R.id.ebook_au1);


        tt_au1.setOnClickListener(this);
        syllabus_au1.setOnClickListener(this);
        qp_au1.setOnClickListener(this);
        ebook_au1.setOnClickListener(this);

        au_first_year.context= getApplicationContext();
    }

    public static Context getAppContext(){return au_first_year.context;}

    public static int getPx(Context context,int dimensionDp){
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dimensionDp * density + 0.5f);
    }

    @Override

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tt_au1:
                startActivity(new Intent(this, tt_au1.class));
                break;
            case R.id.syllabus_au1:
                startActivity(new Intent(this, syllabus_au1.class));
                break;
            case R.id.qp_au1:
                startActivity(new Intent(this, qp_au1.class));
                break;
            case R.id.ebook_au1:
                startActivity(new Intent(this, ebook_au1.class));
                break;

        }
    }
}
