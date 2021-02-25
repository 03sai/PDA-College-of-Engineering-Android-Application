package com.example.final_project;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class me_fourth_year extends AppCompatActivity implements View.OnClickListener {

    private CardView tt_me4,syllabus_me4,qp_me4,ebook_me4;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_fourth_year);



        tt_me4=findViewById(R.id.tt_me4);
        syllabus_me4=findViewById(R.id.syllabus_me4);
        qp_me4=findViewById(R.id.qp_me4);
        ebook_me4=findViewById(R.id.ebook_me4);


        tt_me4.setOnClickListener(this);
        syllabus_me4.setOnClickListener(this);
        qp_me4.setOnClickListener(this);
        ebook_me4.setOnClickListener(this);

        me_fourth_year.context= getApplicationContext();
    }

    public static Context getAppContext(){return me_fourth_year.context;}

    public static int getPx(Context context,int dimensionDp){
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dimensionDp * density + 0.5f);
    }

    @Override

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tt_me4:
                startActivity(new Intent(this, tt_me4.class));
                break;
            case R.id.syllabus_me4:
                startActivity(new Intent(this, syllabus_me4.class));
                break;
            case R.id.qp_me4:
                startActivity(new Intent(this, qp_me4.class));
                break;
            case R.id.ebook_me4:
                startActivity(new Intent(this, ebook_me4.class));
                break;

        }
    }
}
