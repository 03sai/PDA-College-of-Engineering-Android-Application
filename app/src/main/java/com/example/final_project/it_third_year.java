package com.example.final_project;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class it_third_year extends AppCompatActivity implements View.OnClickListener {

    private CardView tt_it3,syllabus_it3,qp_it3,ebook_it3;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_it_third_year);



        tt_it3=findViewById(R.id.tt_it3);
        syllabus_it3=findViewById(R.id.syllabus_it3);
        qp_it3=findViewById(R.id.qp_it3);
        ebook_it3=findViewById(R.id.ebook_it3);


        tt_it3.setOnClickListener(this);
        syllabus_it3.setOnClickListener(this);
        qp_it3.setOnClickListener(this);
        ebook_it3.setOnClickListener(this);

        it_third_year.context= getApplicationContext();
    }

    public static Context getAppContext(){return it_third_year.context;}

    public static int getPx(Context context,int dimensionDp){
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dimensionDp * density + 0.5f);
    }

    @Override

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tt_it3:
                startActivity(new Intent(this, tt_it3.class));
                break;
            case R.id.syllabus_it3:
                startActivity(new Intent(this, syllabus_it3.class));
                break;
            case R.id.qp_it3:
                startActivity(new Intent(this, qp_it3.class));
                break;
            case R.id.ebook_it3:
                startActivity(new Intent(this, ebook_it3.class));
                break;

        }
    }
}
