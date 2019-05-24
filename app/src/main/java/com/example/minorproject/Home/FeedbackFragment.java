package com.example.minorproject.Home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.minorproject.R;

public class FeedbackFragment extends Fragment {

    private static final String TAG="Feedback Fragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view=  inflater.inflate(R.layout.fragment_feedback, container, false);
        return view;
    }
}
