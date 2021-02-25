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

public class qp_cv3 extends AppCompatActivity {


    EditText editPDFname_qp_cv3;
    Button btn_upload_qp_cv3;
    Button btn_download_qp_cv3;


    StorageReference storageReference_qp_cv3;
    DatabaseReference databaseReference_qp_cv3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qp_cv3);

        editPDFname_qp_cv3=(EditText)findViewById(R.id.edit_text_qp_cv3);
        btn_upload_qp_cv3=(Button) findViewById(R.id.button_upload_qp_cv3);
        btn_download_qp_cv3=(Button) findViewById(R.id.button_download_qp_cv3);
        storageReference_qp_cv3=FirebaseStorage.getInstance().getReference();
        databaseReference_qp_cv3=FirebaseDatabase.getInstance().getReference("UPLOADED QUESTION PAPERS CV3");



        btn_upload_qp_cv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectPDF_qp_cv3();
            }
        });


        btn_download_qp_cv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent start_download_qp_cv3=new Intent (qp_cv3.this,download_qp_cv3.class);
                startActivity(start_download_qp_cv3);
            }
        });


    }


    public void selectPDF_qp_cv3(){

        Intent intent=new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"select the book"),1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1 && resultCode==RESULT_OK && data!=null && data.getData()!=null){


            uploadPDF_qp_cv3(data.getData());
        }
    }

    private void uploadPDF_qp_cv3(Uri data) {

        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("UPLOADING");
        progressDialog.show();



        StorageReference reference=storageReference_qp_cv3.child("uploaded_qps_cv3/"+System.currentTimeMillis()+".pdf");
        reference.putFile(data)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {


                        Task<Uri> uri_qp_cv3= taskSnapshot.getStorage().getDownloadUrl();
                        while (!uri_qp_cv3.isComplete());

                        Uri url_qp_cv3= uri_qp_cv3.getResult();

                        uploadEbook_cs1 uploadEbook_cv3=new uploadEbook_cs1(editPDFname_qp_cv3.getText().toString(),url_qp_cv3.toString());
                        databaseReference_qp_cv3.child(databaseReference_qp_cv3.push().getKey()).setValue(uploadEbook_cv3);
                        Toast.makeText(qp_cv3.this,"The file is uploaded",Toast.LENGTH_LONG).show();
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
