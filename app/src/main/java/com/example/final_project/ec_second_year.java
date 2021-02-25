package com.example.final_project;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class ec_second_year extends AppCompatActivity implements View.OnClickListener{


    private CardView tt_ec2,syllabus_ec2,qp_ec2,ebook_ec2;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ec_second_year);


        tt_ec2=findViewById(R.id.tt_ec2);
        syllabus_ec2=findViewById(R.id.syllabus_ec2);
        qp_ec2=findViewById(R.id.qp_ec2);
        ebook_ec2=findViewById(R.id.ebook_ec2);


        tt_ec2.setOnClickListener(this);
        syllabus_ec2.setOnClickListener(this);
        qp_ec2.setOnClickListener(this);
        ebook_ec2.setOnClickListener(this);

        ec_second_year.context= getApplicationContext();
    }



    public static Context getAppContext(){return ec_second_year.context;}

    public static int getPx(Context context,int dimensionDp){
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dimensionDp * density + 0.5f);
    }

    @Override

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tt_ec2:
                startActivity(new Intent(this, tt_ec2.class));
                break;
            case R.id.syllabus_ec2:
                startActivity(new Intent(this, syllabus_ec2.class));
                break;
            case R.id.qp_ec2:
                startActivity(new Intent(this, qp_ec2.class));
                break;
            case R.id.ebook_ec2:
                startActivity(new Intent(this, ebook_ec2.class));
                break;

        }
    }
}
