package com.liyahong.testdriving.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liyahong.testdriving.controllers.TestFragmentController;
import com.liyahong.testdriving.databinding.FragmentTestBinding;


public class TestFragment extends Fragment {


    private FragmentTestBinding binding;
    public TestFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentTestBinding.inflate(inflater);
        TestFragmentController controller=new TestFragmentController(this,binding);
        binding.setController(controller);
        return binding.getRoot();
    }

}
