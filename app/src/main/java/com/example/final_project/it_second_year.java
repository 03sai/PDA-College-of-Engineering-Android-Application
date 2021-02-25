package com.example.final_project;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class it_second_year extends AppCompatActivity implements View.OnClickListener {

    private CardView tt_it2,syllabus_it2,qp_it2,ebook_it2;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_it_second_year);



        tt_it2=findViewById(R.id.tt_it2);
        syllabus_it2=findViewById(R.id.syllabus_it2);
        qp_it2=findViewById(R.id.qp_it2);
        ebook_it2=findViewById(R.id.ebook_it2);


        tt_it2.setOnClickListener(this);
        syllabus_it2.setOnClickListener(this);
        qp_it2.setOnClickListener(this);
        ebook_it2.setOnClickListener(this);

        it_second_year.context= getApplicationContext();
    }

    public static Context getAppContext(){return it_second_year.context;}

    public static int getPx(Context context,int dimensionDp){
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dimensionDp * density + 0.5f);
    }

    @Override

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tt_it2:
                startActivity(new Intent(this, tt_it2.class));
                break;
            case R.id.syllabus_it2:
                startActivity(new Intent(this, syllabus_it2.class));
                break;
            case R.id.qp_it2:
                startActivity(new Intent(this, qp_it2.class));
                break;
            case R.id.ebook_it2:
                startActivity(new Intent(this, ebook_it2.class));
                break;

        }
    }
}
