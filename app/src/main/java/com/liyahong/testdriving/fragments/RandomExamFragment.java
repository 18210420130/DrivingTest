package com.liyahong.testdriving.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

import com.liyahong.testdriving.controllers.RandomExamFragmentController;
import com.liyahong.testdriving.databinding.FragmentRandomExamBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class RandomExamFragment extends Fragment {

    private FragmentRandomExamBinding binding;
    private Animation animation=null;

    public RandomExamFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentRandomExamBinding.inflate(inflater);
        RandomExamFragmentController controller=new RandomExamFragmentController(this,binding);
        binding.setController(controller);
        return binding.getRoot();
    }

    public void setInitAnimation(Animation initAnimation){
        this.animation=initAnimation;
    }

}
