package com.example.final_project;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class calender_of_events extends AppCompatActivity {


    private TextView text_calender_of_events;
    private PDFView pdfView_calender_of_events;
    FirebaseDatabase database_calender_of_events=FirebaseDatabase.getInstance();
    DatabaseReference mref_calender_of_events=database_calender_of_events.getReference("calender_of_events_2020");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender_of_events);


        text_calender_of_events=(TextView)findViewById(R.id.text_calender_of_events);
        pdfView_calender_of_events=(PDFView)findViewById(R.id.pdf_calender_of_events);

        mref_calender_of_events.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value=dataSnapshot.getValue(String.class);
                text_calender_of_events.setText(value);
                Toast.makeText(calender_of_events.this,"The time table is updated",Toast.LENGTH_LONG);
                String url_calender_of_events=text_calender_of_events.getText().toString();
                new calender_of_events.RetrivepdfStream().execute(url_calender_of_events);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {


                Toast.makeText(calender_of_events.this,"Failed to load the Timetable",Toast.LENGTH_SHORT).show();


            }
        });



    }


    class RetrivepdfStream extends AsyncTask<String,Void, InputStream>{

        @Override
        protected InputStream doInBackground(String... strings) {
            InputStream inputStream=null;
            try{
                URL url=new URL(strings[0]);
                HttpURLConnection urlConnection=(HttpURLConnection)url.openConnection();
                if(urlConnection.getResponseCode()==200)
                {
                    inputStream=new BufferedInputStream(urlConnection.getInputStream());
                }
            }
            catch (IOException e){
                return null;
            }
            return inputStream;
        }

        @Override
        protected void onPostExecute(InputStream inputStream) {
            pdfView_calender_of_events.fromStream(inputStream).load();
        }
    }







}
