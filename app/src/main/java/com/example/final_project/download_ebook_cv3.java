package com.example.final_project;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class download_ebook_cv3 extends AppCompatActivity {

    ListView uploaded_ebooks_cv3;
    DatabaseReference databaseReference_cv3;
    List<uploadEbook_cs1> uploadedEbooks_cv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_ebook_cv3);


        uploaded_ebooks_cv3=(ListView)findViewById(R.id.ebook_list_cv3);
        uploadedEbooks_cv3=new ArrayList<>();

        viewAllEbooks_cv3();


        uploaded_ebooks_cv3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                uploadEbook_cs1 uploadEbook_cs1= uploadedEbooks_cv3.get(position);
                Intent intent= new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(Uri.parse(uploadEbook_cs1.getUrl()),"application/pdf");
                startActivity(intent);
            }
        });

    }

    private void viewAllEbooks_cv3() {

        databaseReference_cv3 = FirebaseDatabase.getInstance().getReference("UPLOADED EBOOKS CV3");
        databaseReference_cv3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot postSnapshot: dataSnapshot.getChildren()){

                    uploadEbook_cs1 uploadEbook_cs1=postSnapshot.getValue(com.example.final_project.uploadEbook_cs1.class);
                    uploadedEbooks_cv3.add(uploadEbook_cs1);

                }


                String[] uploads=new String[uploadedEbooks_cv3.size()];


                for(int i=0;i<uploads.length;i++){
                    uploads[i]=uploadedEbooks_cv3.get(i).getName();
                }


                ArrayAdapter<String> adapter= new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_expandable_list_item_1,uploads){

                    @NonNull
                    @Override
                    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                        View view=super.getView(position, convertView, parent);

                        TextView mytext=(TextView)view.findViewById(android.R.id.text1);
                        mytext.setTextColor(Color.BLACK);
                        return view;
                    }
                };


                uploaded_ebooks_cv3.setAdapter(adapter);





            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
