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

public class tt_au3 extends AppCompatActivity {

    private TextView text_au3;
    private PDFView pdfView_tt_au3;
    FirebaseDatabase database_tt_au3=FirebaseDatabase.getInstance();
    DatabaseReference mref_tt_au3=database_tt_au3.getReference("timetable_au3");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tt_au3);


        text_au3=(TextView)findViewById(R.id.text_tt_au3);
        pdfView_tt_au3=(PDFView)findViewById(R.id.pdf_tt_au3);


        mref_tt_au3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value=dataSnapshot.getValue(String.class);
                text_au3.setText(value);
                Toast.makeText(tt_au3.this,"The time table is updated",Toast.LENGTH_LONG);
                String url_tt_au3=text_au3.getText().toString();
                new tt_au3.RetrivepdfStream().execute(url_tt_au3);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {


                Toast.makeText(tt_au3.this,"Failed to load the Timetable",Toast.LENGTH_SHORT).show();


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
            pdfView_tt_au3.fromStream(inputStream).load();
        }
    }
}