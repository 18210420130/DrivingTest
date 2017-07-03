package com.liyahong.testdriving.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liyahong.testdriving.controllers.SettingFragmentController;
import com.liyahong.testdriving.databinding.FragmentSettingBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment {


    private FragmentSettingBinding binding;
    public SettingFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentSettingBinding.inflate(inflater);
        SettingFragmentController controller =new SettingFragmentController(this,binding);
        binding.setController(controller);
        return binding.getRoot();
    }

}
