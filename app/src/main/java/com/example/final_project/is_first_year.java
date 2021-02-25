package com.example.final_project;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class is_first_year extends AppCompatActivity implements View.OnClickListener {

    private CardView tt_is1,syllabus_is1,qp_is1,ebook_is1;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_is_first_year);



        tt_is1=findViewById(R.id.tt_is1);
        syllabus_is1=findViewById(R.id.syllabus_is1);
        qp_is1=findViewById(R.id.qp_is1);
        ebook_is1=findViewById(R.id.ebook_is1);


        tt_is1.setOnClickListener(this);
        syllabus_is1.setOnClickListener(this);
        qp_is1.setOnClickListener(this);
        ebook_is1.setOnClickListener(this);

        is_first_year.context= getApplicationContext();
    }

    public static Context getAppContext(){return is_first_year.context;}

    public static int getPx(Context context,int dimensionDp){
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dimensionDp * density + 0.5f);
    }

    @Override

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tt_is1:
                startActivity(new Intent(this, tt_is1.class));
                break;
            case R.id.syllabus_is1:
                startActivity(new Intent(this, syllabus_is1.class));
                break;
            case R.id.qp_is1:
                startActivity(new Intent(this, qp_is1.class));
                break;
            case R.id.ebook_is1:
                startActivity(new Intent(this, ebook_is1.class));
                break;

        }
    }
}
