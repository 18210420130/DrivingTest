package com.liyahong.testdriving.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liyahong.testdriving.controllers.MainBtnController;
import com.liyahong.testdriving.databinding.FragmentMainBtnBinding;



public class MainBtnFragment extends Fragment {

    private FragmentMainBtnBinding binding;

    public MainBtnFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentMainBtnBinding.inflate(inflater);
        MainBtnController controller=new MainBtnController(MainBtnFragment.this,binding);
        binding.setController(controller);
        return binding.getRoot();
    }



}
