package com.liyahong.testdriving.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liyahong.testdriving.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubjectToAFragment extends Fragment {


    public SubjectToAFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_subject_to_a, container, false);
    }

}
