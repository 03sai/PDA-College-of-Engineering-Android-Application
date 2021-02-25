package com.example.final_project;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class cv_second_year extends AppCompatActivity implements View.OnClickListener {


    private CardView tt_cv2,syllabus_cv2,qp_cv2,ebook_cv2;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv_second_year);

        tt_cv2=findViewById(R.id.tt_cv2);
        syllabus_cv2=findViewById(R.id.syllabus_cv2);
        qp_cv2=findViewById(R.id.qp_cv2);
        ebook_cv2=findViewById(R.id.ebook_cv2);


        tt_cv2.setOnClickListener(this);
        syllabus_cv2.setOnClickListener(this);
        qp_cv2.setOnClickListener(this);
        ebook_cv2.setOnClickListener(this);

        cv_second_year.context= getApplicationContext();
    }

    public static Context getAppContext(){return cv_second_year.context;}

    public static int getPx(Context context,int dimensionDp){
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dimensionDp * density + 0.5f);
    }


    @Override

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tt_cv2:
                startActivity(new Intent(this, tt_cv2.class));
                break;
            case R.id.syllabus_cv2:
                startActivity(new Intent(this, syllabus_cv2.class));
                break;
            case R.id.qp_cv2:
                startActivity(new Intent(this, qp_cv2.class));
                break;
            case R.id.ebook_cv2:
                startActivity(new Intent(this, ebook_cv2.class));
                break;

        }
    }
}
