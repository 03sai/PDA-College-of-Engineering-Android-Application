package com.example.final_project;

import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class cgpa_calculator extends AppCompatActivity {


    EditText et1;
    EditText et2;
    EditText et3;
    EditText et4;
    EditText et5;
    EditText et6;
    EditText et7;
    EditText et8;
    EditText et9;
    EditText et10;
    EditText et11;
    EditText et12;
    EditText et13;
    EditText et14;
    EditText et15;
    EditText et16;
    EditText et17;
    EditText et18;
    EditText et19;
    EditText et20;
    TextView tv;
    Button bt1;
    Button bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgpa_calculator);



        et1=(EditText) findViewById(R.id.et1);
        et2=(EditText) findViewById(R.id.et2);
        et3=(EditText) findViewById(R.id.et3);
        et4=(EditText) findViewById(R.id.et4);
        et5=(EditText) findViewById(R.id.et5);
        et6=(EditText) findViewById(R.id.et6);
        et7=(EditText) findViewById(R.id.et7);
        et8=(EditText) findViewById(R.id.et8);
        et9=(EditText) findViewById(R.id.et9);
        et10=(EditText) findViewById(R.id.et10);
        et11=(EditText) findViewById(R.id.et11);
        et12=(EditText) findViewById(R.id.et12);
        et13=(EditText) findViewById(R.id.et13);
        et14=(EditText) findViewById(R.id.et14);
        et15=(EditText) findViewById(R.id.et15);
        et16=(EditText) findViewById(R.id.et16);
        et17=(EditText) findViewById(R.id.et17);
        et18=(EditText) findViewById(R.id.et18);
        et19=(EditText) findViewById(R.id.et19);
        et20=(EditText) findViewById(R.id.et20);


        tv=(TextView) findViewById(R.id.tv);

        Button reset=findViewById(R.id.bt2);


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1.setText(null);
                et2.setText(null);
                et3.setText(null);
                et4.setText(null);
                et5.setText(null);
                et6.setText(null);
                et7.setText(null);
                et8.setText(null);
                et9.setText(null);
                et10.setText(null);
                et11.setText(null);
                et12.setText(null);
                et13.setText(null);
                et14.setText(null);
                et15.setText(null);
                et16.setText(null);
                et16.setText(null);
                et17.setText(null);
                et18.setText(null);
                et19.setText(null);
                et20.setText(null);

            }
        });




    }


    public void cgpa(View v){
        String s1=et1.getText().toString();
        String s2=et2.getText().toString();
        String s3=et3.getText().toString();
        String s4=et4.getText().toString();
        String s5=et5.getText().toString();
        String s6=et6.getText().toString();
        String s7=et7.getText().toString();
        String s8=et8.getText().toString();
        String s9=et9.getText().toString();
        String s10=et10.getText().toString();
        String s11=et11.getText().toString();
        String s12=et12.getText().toString();
        String s13=et13.getText().toString();
        String s14=et14.getText().toString();
        String s15=et15.getText().toString();
        String s16=et16.getText().toString();
        String s17=et17.getText().toString();
        String s18=et18.getText().toString();
        String s19=et19.getText().toString();
        String s20=et20.getText().toString();


        Double d1=Double.parseDouble(s1);
        Double d2=Double.parseDouble(s2);
        Double d3=Double.parseDouble(s3);
        Double d4=Double.parseDouble(s4);
        Double d5=Double.parseDouble(s5);
        Double d6=Double.parseDouble(s6);
        Double d7=Double.parseDouble(s7);
        Double d8=Double.parseDouble(s8);
        Double d9=Double.parseDouble(s9);
        Double d10=Double.parseDouble(s10);
        Double d11=Double.parseDouble(s11);
        Double d12=Double.parseDouble(s12);
        Double d13=Double.parseDouble(s13);
        Double d14=Double.parseDouble(s14);
        Double d15=Double.parseDouble(s15);
        Double d16=Double.parseDouble(s16);
        Double d17=Double.parseDouble(s17);
        Double d18=Double.parseDouble(s18);
        Double d19=Double.parseDouble(s19);
        Double d20=Double.parseDouble(s20);



        Double d21=(d1*d2+d3*d4+d5*d6+d7*d8+d9*d10+d11*d12+d13*d14+d15*d16+d17*d18+d19*d20)/25;
        tv.setText(""+d21);

    }


}
