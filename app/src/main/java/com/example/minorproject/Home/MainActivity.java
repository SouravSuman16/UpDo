package com.example.minorproject.Home;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.minorproject.Login.LoginActivity;
import com.example.minorproject.R;
import com.example.minorproject.Utils.SectionPageAdapter;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import com.example.minorproject.Utils.BottomNavigationViewHelper;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private Context mContext= MainActivity.this;
    private static final String TAG = "MainActivity";
    private static final int ACTIVITY_NUMBER=0;
    //private FirebaseAuth mAuth;
    //private FirebaseAuth.AuthStateListener mAuthListener;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: starting");
        FirebaseApp.initializeApp(MainActivity.this);
        setupBottomNavigationView();
        setupViewPager();
      //  setupFirebaseAuth();


    }







    private void setupViewPager(){
        SectionPageAdapter adapter=new SectionPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new CameraFragment());
        adapter.addFragment(new HomeFragment());
        adapter.addFragment(new FeedbackFragment());
        ViewPager viewPager= (ViewPager) findViewById(R.id.container);
        viewPager.setAdapter(adapter);
        TabLayout tabLayout= (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_camera);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_icon_main);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_arrow);
    }





    private void setupBottomNavigationView(){

        Log.d(TAG, "setupBottomNavigationView: Setting up Bottom navigation view");
        BottomNavigationViewEx bottomNavigationViewEx= (BottomNavigationViewEx)findViewById(R.id.bottomNavViewBar);

        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(mContext, bottomNavigationViewEx);

        Menu menu= bottomNavigationViewEx.getMenu();
        MenuItem menuItem=menu.getItem(ACTIVITY_NUMBER);
        menuItem.setChecked(true);
    }


    /*
    Setting up firebase object
     */
//    private void setupFirebaseAuth(){
//        Log.d(TAG, "setupFirebaseAuth: Setting up the firebase auth");
//        mAuth = FirebaseAuth.getInstance();
//        mAuthListener=new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//                FirebaseUser user= firebaseAuth.getCurrentUser();
//                if(user!= null){
//                    Log.d(TAG, "onAuthStateChanged: User is signed in:"+user.getUid());
//                }else{
//                    Log.d(TAG, "onAuthStateChanged: User is not signed in");
//                }
//            }
//        };
//    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        // Check if user is signed in (non-null) and update UI accordingly.
//        mAuth.addAuthStateListener(mAuthListener);
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        if(mAuthListener!=null){
//            mAuth.removeAuthStateListener(mAuthListener);}
//    }

/*
-------------------------------------------------Firebase Stuff------------------------------------------------------
 */
//    private void setupFirebaseAuth() {
//        Log.d(TAG, "setupFirebaseAuth: Setting up the firebase auth");
//        mAuth = FirebaseAuth.getInstance();
//    }
//    @Override
//    public void onStart() {
//        super.onStart();
//        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        //checkCurrentUser(currentUser);
//
//        updateUI(currentUser);
//    }
//
//    private void updateUI(FirebaseUser currentUser) {
//        //checkCurrentUser(currentUser);
//        if(currentUser!= null){
//                    Log.d(TAG, "onAuthStateChanged: User is signed in:"+currentUser.getUid());
//                }else{
//                    Log.d(TAG, "onAuthStateChanged: User is not signed in");
//                }
//    }

//    private void checkCurrentUser(FirebaseUser currentUser){
//        Log.d(TAG, "checkCurrentUser: checking if the user is logged in");
//        if(currentUser==null){
//            new Intent(mContext, LoginActivity.class);
//        }
//    }

}
