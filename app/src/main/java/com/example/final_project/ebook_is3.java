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

public class ebook_is3 extends AppCompatActivity {


    EditText editPDFName_is3;
    Button btn_upload_is3;
    Button btn_download_ebook_is3;

    StorageReference storageReference_is3;
    DatabaseReference databaseReference_is3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook_is3);


        editPDFName_is3=(EditText) findViewById(R.id.edit_text_ebook_is3);
        btn_upload_is3=(Button)findViewById(R.id.button_upload_ebook_is3);
        btn_download_ebook_is3=(Button)findViewById(R.id.button_download_ebook_is3);
        storageReference_is3= FirebaseStorage.getInstance().getReference();
        databaseReference_is3= FirebaseDatabase.getInstance().getReference("UPLOADED EBOOKS IS3");

        btn_upload_is3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectPDF_ebook_is3();
            }
        });


        btn_download_ebook_is3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start_download_ebook=new Intent(ebook_is3.this,download_ebook_is3.class);
                startActivity(start_download_ebook);
            }
        });
    }


    private void selectPDF_ebook_is3() {

        Intent intent=new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select the ebook"),1);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1 && resultCode==RESULT_OK && data!=null && data.getData()!=null)
        {
            uploadPDF_ebook_is3(data.getData());
        }
    }


    private void uploadPDF_ebook_is3(Uri data){
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Uploading");
        progressDialog.show();


        StorageReference reference= storageReference_is3.child("uploaded_ebooks_is3/"+System.currentTimeMillis()+".pdf");
        reference.putFile(data)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {


                        Task<Uri> uri = taskSnapshot.getStorage().getDownloadUrl();
                        while (!uri.isComplete());
                        Uri url=uri.getResult();
                        uploadEbook_cs1 uploadEbook_cs1=new uploadEbook_cs1(editPDFName_is3.getText().toString(),url.toString());
                        databaseReference_is3.child(databaseReference_is3.push().getKey()).setValue(uploadEbook_cs1);
                        Toast.makeText(ebook_is3.this,"The file is uploaded",Toast.LENGTH_SHORT).show();
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
