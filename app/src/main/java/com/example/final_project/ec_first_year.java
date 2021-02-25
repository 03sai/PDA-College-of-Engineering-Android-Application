package com.example.final_project;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class ec_first_year extends AppCompatActivity implements View.OnClickListener {

    private CardView tt_ec1,syllabus_ec1,qp_ec1,ebook_ec1;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ec_first_year);



        tt_ec1=findViewById(R.id.tt_ec1);
        syllabus_ec1=findViewById(R.id.syllabus_ec1);
        qp_ec1=findViewById(R.id.qp_ec1);
        ebook_ec1=findViewById(R.id.ebook_ec1);


        tt_ec1.setOnClickListener(this);
        syllabus_ec1.setOnClickListener(this);
        qp_ec1.setOnClickListener(this);
        ebook_ec1.setOnClickListener(this);

        ec_first_year.context= getApplicationContext();
    }

    public static Context getAppContext(){return ec_first_year.context;}

    public static int getPx(Context context,int dimensionDp){
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dimensionDp * density + 0.5f);
    }

    @Override

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tt_ec1:
                startActivity(new Intent(this, tt_ec1.class));
                break;
            case R.id.syllabus_ec1:
                startActivity(new Intent(this, syllabus_ec1.class));
                break;
            case R.id.qp_ec1:
                startActivity(new Intent(this, qp_ec1.class));
                break;
            case R.id.ebook_ec1:
                startActivity(new Intent(this, ebook_ec1.class));
                break;

        }
    }
}
