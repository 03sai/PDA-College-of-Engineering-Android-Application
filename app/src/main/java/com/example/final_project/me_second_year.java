package com.example.final_project;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class me_second_year extends AppCompatActivity implements View.OnClickListener {

    private CardView tt_me2,syllabus_me2,qp_me2,ebook_me2;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_second_year);



        tt_me2=findViewById(R.id.tt_me2);
        syllabus_me2=findViewById(R.id.syllabus_me2);
        qp_me2=findViewById(R.id.qp_me2);
        ebook_me2=findViewById(R.id.ebook_me2);


        tt_me2.setOnClickListener(this);
        syllabus_me2.setOnClickListener(this);
        qp_me2.setOnClickListener(this);
        ebook_me2.setOnClickListener(this);

        me_second_year.context= getApplicationContext();
    }

    public static Context getAppContext(){return me_second_year.context;}

    public static int getPx(Context context,int dimensionDp){
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dimensionDp * density + 0.5f);
    }

    @Override

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tt_me2:
                startActivity(new Intent(this, tt_me2.class));
                break;
            case R.id.syllabus_me2:
                startActivity(new Intent(this, syllabus_me2.class));
                break;
            case R.id.qp_me2:
                startActivity(new Intent(this, qp_me2.class));
                break;
            case R.id.ebook_me2:
                startActivity(new Intent(this, ebook_me2.class));
                break;

        }
    }
}
