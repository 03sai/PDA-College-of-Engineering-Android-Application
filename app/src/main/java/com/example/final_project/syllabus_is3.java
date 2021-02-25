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

public class syllabus_is3 extends AppCompatActivity {


    private TextView syllabus_is3;
    private PDFView pdfView_syllabus_is3;
    FirebaseDatabase database_syllabus_is3=FirebaseDatabase.getInstance();
    DatabaseReference mref_syllabus_is3=database_syllabus_is3.getReference("syllabus_is3");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus_is3);


        syllabus_is3=(TextView)findViewById(R.id.text_syllabus_is3);
        pdfView_syllabus_is3=(PDFView)findViewById(R.id.pdf_syllabus_is3);

        mref_syllabus_is3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String value=dataSnapshot.getValue(String.class);
                syllabus_is3.setText(value);
                Toast.makeText(syllabus_is3.this,"The time table is updated",Toast.LENGTH_LONG);
                String url_syllabus_is3=syllabus_is3.getText().toString();
                new syllabus_is3.RetrivepdfStream().execute(url_syllabus_is3);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {


                Toast.makeText(syllabus_is3.this,"Failed to load the Timetable",Toast.LENGTH_SHORT).show();


            }
        });
    }



    class RetrivepdfStream extends AsyncTask<String,Void, InputStream> {

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
            pdfView_syllabus_is3.fromStream(inputStream).load();
        }
    }
}
