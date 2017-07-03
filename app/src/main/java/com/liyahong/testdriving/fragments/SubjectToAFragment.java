package com.liyahong.testdriving.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liyahong.testdriving.controllers.SubjectToAFragmentController;
import com.liyahong.testdriving.databinding.FragmentSubjectToABinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubjectToAFragment extends Fragment {

    private FragmentSubjectToABinding binding;
    private SubjectToAFragmentController controller;

    public SubjectToAFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentSubjectToABinding.inflate(inflater);
        controller = new SubjectToAFragmentController(this,binding);
        binding.setController(controller);
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        controller.onResum();
        super.onResume();
    }
}
