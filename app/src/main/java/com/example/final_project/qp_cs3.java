package com.example.final_project;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class qp_cs3 extends AppCompatActivity {


    EditText editPDFname_qp_cs3;
    Button btn_upload_qp_cs3;
    Button btn_download_qp_cs3;


    StorageReference storageReference_qp_cs3;
    DatabaseReference databaseReference_qp_cs3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qp_cs3);

        editPDFname_qp_cs3=(EditText)findViewById(R.id.edit_text_qp_cs3);
        btn_upload_qp_cs3=(Button) findViewById(R.id.button_upload_qp_cs3);
        btn_download_qp_cs3=(Button) findViewById(R.id.button_download_qp_cs3);
        storageReference_qp_cs3= FirebaseStorage.getInstance().getReference();
        databaseReference_qp_cs3= FirebaseDatabase.getInstance().getReference("UPLOADED QUESTION PAPERS CS3");



        btn_upload_qp_cs3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectPDF_qp_cs3();
            }
        });


        btn_download_qp_cs3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent start_download_qp_cs3=new Intent (qp_cs3.this,download_qp_cs3.class);
                startActivity(start_download_qp_cs3);
            }
        });
    }

    public void selectPDF_qp_cs3(){

        Intent intent=new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"select the book"),1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1 && resultCode==RESULT_OK && data!=null && data.getData()!=null){


            uploadPDF_qp_cs3(data.getData());
        }
    }

    private void uploadPDF_qp_cs3(Uri data) {

        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("UPLOADING");
        progressDialog.show();



        StorageReference reference=storageReference_qp_cs3.child("uploaded_qps_cs3/"+System.currentTimeMillis()+".pdf");
        reference.putFile(data)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {


                        Task<Uri> uri_qp_cs3= taskSnapshot.getStorage().getDownloadUrl();
                        while (!uri_qp_cs3.isComplete());

                        Uri url_qp_cs3= uri_qp_cs3.getResult();

                        uploadEbook_cs1 uploadEbook_cs1=new uploadEbook_cs1(editPDFname_qp_cs3.getText().toString(),url_qp_cs3.toString());
                        databaseReference_qp_cs3.child(databaseReference_qp_cs3.push().getKey()).setValue(uploadEbook_cs1);
                        Toast.makeText(qp_cs3.this,"The file is uploaded",Toast.LENGTH_LONG).show();
                        progressDialog.dismiss();




                    }
                }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {

                double progress=(100.0*taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
                progressDialog.setMessage("Uploaded: "+(int)progress+"%");




            }
        });
    }
}
