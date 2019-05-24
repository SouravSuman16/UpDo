package com.example.minorproject.Utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import com.example.minorproject.AddActivity.AddActivity;
import com.example.minorproject.Home.MainActivity;
import com.example.minorproject.ProfileActivity.ProfileActivity;
import com.example.minorproject.R;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class BottomNavigationViewHelper {


    private static final String TAG = "BottomNavigationViewHel";

    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx){
        Log.d(TAG, "setupBottomNavigationView: Setting up BottomNavigationView");
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);




    }


public static void enableNavigation(final Context context, BottomNavigationViewEx view){
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem Item) {
                switch (Item.getItemId()){
                    case R.id.ic_file:
                        Intent intent1=new Intent(context, MainActivity.class);
                        context.startActivity(intent1);

                        break;

                    case R.id.ic_add:
                        Intent intent2=new Intent(context, AddActivity.class);
                        context.startActivity(intent2);
                        break;

                    case R.id.ic_profile:
                        Intent intent3= new Intent(context, ProfileActivity.class);
                        context.startActivity(intent3);
                        break;


                }

                return false;
            }
        });

}
}
