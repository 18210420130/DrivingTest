package com.liyahong.testdriving.controllers;

import android.view.View;
import android.view.animation.Animation;

import com.liyahong.testdriving.R;
import com.liyahong.testdriving.adapter.AnimationListenerAdapter;
import com.liyahong.testdriving.anim.TranslateD;
import com.liyahong.testdriving.databinding.FragmentMockExamBinding;
import com.liyahong.testdriving.fragments.MockExamFragment;
import com.liyahong.testdriving.fragments.RandomExamFragment;

/**
 * Created by liyahong0327 on 2017/6/23.
 */

public class MockExamFragmentController {
    private MockExamFragment fragment;
    private FragmentMockExamBinding binding;

    public MockExamFragmentController(MockExamFragment fragment, FragmentMockExamBinding binding) {
        this.fragment = fragment;
        this.binding = binding;
    }

    public void btnNavigateToRandomExamFragmentClickedHandler(View v){
        fragment.getView().startAnimation(new TranslateD(0, -90, true, 350, new AnimationListenerAdapter() {
            @Override
            public void onAnimationEnd(Animation animation) {
                RandomExamFragment randomExamFragment = new RandomExamFragment();
                randomExamFragment.setInitAnimation(new TranslateD(90, 0, false, 350, null));
                fragment.getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.examFragment, randomExamFragment)
                        .commit();
            }
        }));
    }
}
