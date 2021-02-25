package com.example.final_project;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class is_fourth_year extends AppCompatActivity implements View.OnClickListener {

    private CardView tt_is4,syllabus_is4,qp_is4,ebook_is4;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_is_fourth_year);



        tt_is4=findViewById(R.id.tt_is4);
        syllabus_is4=findViewById(R.id.syllabus_is4);
        qp_is4=findViewById(R.id.qp_is4);
        ebook_is4=findViewById(R.id.ebook_is4);


        tt_is4.setOnClickListener(this);
        syllabus_is4.setOnClickListener(this);
        qp_is4.setOnClickListener(this);
        ebook_is4.setOnClickListener(this);

        is_fourth_year.context= getApplicationContext();
    }

    public static Context getAppContext(){return is_fourth_year.context;}

    public static int getPx(Context context,int dimensionDp){
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dimensionDp * density + 0.5f);
    }

    @Override

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tt_is4:
                startActivity(new Intent(this, tt_is4.class));
                break;
            case R.id.syllabus_is4:
                startActivity(new Intent(this, syllabus_is4.class));
                break;
            case R.id.qp_is4:
                startActivity(new Intent(this, qp_is4.class));
                break;
            case R.id.ebook_is4:
                startActivity(new Intent(this, ebook_is4.class));
                break;

        }
    }
}
