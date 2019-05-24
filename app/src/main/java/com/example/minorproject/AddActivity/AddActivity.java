package com.example.minorproject.AddActivity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.minorproject.R;
import com.example.minorproject.Utils.BottomNavigationViewHelper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.sql.DataTruncation;

public class AddActivity extends AppCompatActivity {

    private Context mContext= AddActivity.this;


    private static final String TAG = "AddActivity";
    private static final int ACTIVITY_NUMBER=1;
//    Button upload, select, fetch;
//    TextView selection;
//    Uri pdfUri;
//    ProgressDialog progressDialog;
//    FirebaseStorage storage;
//    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_file);
        setupBottomNavigationView();
        Log.d(TAG, "onCreate: starting");}
//        database = FirebaseDatabase.getInstance();
//        storage = FirebaseStorage.getInstance();
//        upload=findViewById(R.id.upload_button);
//        select=findViewById(R.id.select_button);
//        fetch=findViewById(R.id.fetch_button);
//        fetch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(AddActivity.this, MyRecyclerView.class));
//
//            }
//        });
//        selection=findViewById(R.id.notification);
//        select.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(ContextCompat.checkSelfPermission(AddActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED){
//                    selectPDF();
//                }
//                else{
//                    ActivityCompat.requestPermissions(AddActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},9);
//                }
//            }
//        });
//        // setupBottomNavigationView();
//        upload.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(pdfUri!=null){
//                    uploadFile(pdfUri);
//                }else{
//                    Toast.makeText(AddActivity.this, "Please Provide File",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//        }
//
//    private void uploadFile(Uri pdfUri) {
//        progressDialog=new ProgressDialog(this);
//        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
//        progressDialog.setTitle("Uploading File");
//        progressDialog.show();
//
//        final String fileName= System.currentTimeMillis()+"";
//        final StorageReference storageReference=storage.getReference();
//        storageReference.child("Uploads").child(fileName).putFile(pdfUri)
//                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                    @Override
//                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                        String url= storageReference.getDownloadUrl().toString(); //check the video
//                        DatabaseReference reference= database.getReference();
//                        reference.child(fileName).setValue(url).addOnCompleteListener(new OnCompleteListener<Void>() {
//                            @Override
//                            public void onComplete(@NonNull Task<Void> task) {
//                                if(task.isSuccessful()){
//                                    Toast.makeText(AddActivity.this, "File Successfully Uploaded",Toast.LENGTH_SHORT).show();
//                                }else{
//                                    Toast.makeText(AddActivity.this, "File not Successfully Uploaded",Toast.LENGTH_SHORT).show();
//
//                                }
//                            }
//                        });
//
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(AddActivity.this, "File not Successfully Uploaded",Toast.LENGTH_SHORT).show();
//            }
//        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
//            @Override
//            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
//                int currentProgress= (int)(100*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
//                progressDialog.setProgress(currentProgress);
//            }
//        });
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
////        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if(requestCode==9 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
//            selectPDF();
//        }
//        else{
//            Toast.makeText(AddActivity.this, "Please Provide Information",Toast.LENGTH_SHORT).show();
//        }
//    }
//
//
//
//    private void selectPDF(){
//
//        Intent intent= new Intent();
//        intent.setType("application/pdf");
//        intent.setAction(Intent.ACTION_GET_CONTENT);// intent is made to fetch file
//        startActivityForResult(intent, 86);
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//       // super.onActivityResult(requestCode, resultCode, data);
//        if(requestCode==86 && resultCode== RESULT_OK && data!=null){
//            pdfUri=data.getData();
//            selection.setText("A file is successfully selected"+ data.getData().getLastPathSegment());
//        }
//        else{
//            Toast.makeText(AddActivity.this, "Please provide valid file",Toast.LENGTH_SHORT).show();
//
//        }
//    }

    private void setupBottomNavigationView(){

        Log.d(TAG, "setupBottomNavigationView: Setting up Bottom navigation view");
        BottomNavigationViewEx bottomNavigationViewEx= (BottomNavigationViewEx)findViewById(R.id.bottomNavViewBar);

        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(mContext, bottomNavigationViewEx);

        Menu menu= bottomNavigationViewEx.getMenu();
        MenuItem menuItem=menu.getItem(ACTIVITY_NUMBER);
        menuItem.setChecked(true);





    }
}