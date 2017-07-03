package com.liyahong.testdriving.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

import com.liyahong.testdriving.controllers.MockExamFragmentController;
import com.liyahong.testdriving.databinding.FragmentMockExamBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class MockExamFragment extends Fragment {

    private FragmentMockExamBinding binding;
    private Animation animation=null;

    public MockExamFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentMockExamBinding.inflate(inflater);
        MockExamFragmentController controller=new MockExamFragmentController(this,binding);
        binding.setController(controller);
        return binding.getRoot();
    }

    public void setInitAnimation(Animation initAnimation){
        this.animation=initAnimation;
    }
}
