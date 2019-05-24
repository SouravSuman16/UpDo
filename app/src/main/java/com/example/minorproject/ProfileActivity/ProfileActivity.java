package com.example.minorproject.ProfileActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DialogTitle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.minorproject.Home.MainActivity;
import com.example.minorproject.Login.LoginActivity;
import com.example.minorproject.R;
import com.example.minorproject.Utils.BottomNavigationViewHelper;
import com.example.minorproject.Utils.SectionStatePagerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {

    private Context mContext = ProfileActivity.this;
//    private Context context;
    private static final int ACTIVITY_NUMBER = 2;
    private static final String TAG = "ProfileActivity";
    private SectionStatePagerAdapter pagerAdapter;
    private ViewPager mViewPager;
    private RelativeLayout mRelativeLayout;
    private FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthStateListener;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.d(TAG, "onCreate: starting");
        mViewPager= (ViewPager)findViewById(R.id.container);
        mRelativeLayout=(RelativeLayout)findViewById(R.id.relLayout1);
        setupBottomNavigationView();
        setupSettingList();
        setupFragments();
//        SetupToolbar();

        /*
-------------------------------------------        Signout button part -----------------------------------------------
         */
        button= (Button)findViewById(R.id.signout_button);
//        mAuth= FirebaseAuth.getInstance();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Log.d(TAG, "onClick: signout done");

            }
        });
        mAuthStateListener= new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(mAuth.getCurrentUser()==null){
                    startActivity(new Intent(ProfileActivity.this, LoginActivity.class));

                }

            }
        };

       /*
       --------------------------------------------------------------------------------------
        */


    }

    private void setupBottomNavigationView() {

        Log.d(TAG, "setupBottomNavigationView: Setting up Bottom navigation view");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);

        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(mContext, bottomNavigationViewEx);

        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUMBER);
        menuItem.setChecked(true);

    }

    private void setupFragments(){
        pagerAdapter= new SectionStatePagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new EditProfileFragment(), getString(R.string.edit_profile_fragment));
        //pagerAdapter.addFragment(new SignOutFragment(), getString(R.string.sign_out_fragment));
    }

    private void setupViewPager(int fragmentNumber){
        mRelativeLayout.setVisibility(View.GONE);
        Log.d(TAG, "setupViewPager: navigating to fragment number #:" +fragmentNumber);
        mViewPager.setAdapter(pagerAdapter);
        mViewPager.setCurrentItem(fragmentNumber);
    }


    private void setupSettingList() {

        Log.d(TAG, "setupSettingList: initalizing account setting list");
        ListView listView= (ListView) findViewById(R.id.lvAccountSettings);
        ArrayList<String> options= new ArrayList<>();
        options.add(getString(R.string.edit_profile_fragment));
        //options.add(getString(R.string.sign_out_fragment));

        ArrayAdapter adapter= new ArrayAdapter(mContext, android.R.layout.simple_list_item_1, options);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "onItemClick: navigating to postion #:"+position);
                setupViewPager(position);
            }
        });


    }






    }



//    private void SetupToolbar() {
//        Toolbar toolbar = (Toolbar) findViewById(R.id.profileToolbar);
//        setSupportActionBar(toolbar);
//        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                Log.d(TAG, "onMenuItemClick: clicked menu item" + item);
//
//                switch (item.getItemId()) {
//                    case  R.id.profileMenu:
//                        Log.d(TAG, "onMenuItemClick: navigating to profile preferences");
//
//                }
//                return false;
//            }
//        });
//
//
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.profile_menu, menu);
//        return true;
//    }



