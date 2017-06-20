package com.liyahong.testdriving.controllers;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.liyahong.testdriving.activitys.MainActivity;
import com.liyahong.testdriving.databinding.FragmentTestBinding;
import com.liyahong.testdriving.fragments.SubjectToAFragment;
import com.liyahong.testdriving.fragments.SubjectToBFragment;
import com.liyahong.testdriving.fragments.SubjectToCFragment;
import com.liyahong.testdriving.fragments.SubjectToDFragment;
import com.liyahong.testdriving.fragments.TestFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyahong0327 on 2017/6/19.
 */

public class TestFragmentController {
    private TestFragment fragment;
    private FragmentTestBinding binding;

    private List<String> stringList =new ArrayList<>();
    private List<Fragment> fragmentList =new ArrayList<>();
    private SubjectToAFragment a;
    private SubjectToBFragment b;
    private SubjectToCFragment c;
    private SubjectToDFragment d;

    public TestFragmentController(TestFragment fragment, FragmentTestBinding binding) {
        this.fragment = fragment;
        this.binding = binding;
        add2List();
        initViewPager();
    }

    private void add2List(){
        stringList.add("科目一");
        stringList.add("科目二");
        stringList.add("科目三");
        stringList.add("科目四");
        a = new SubjectToAFragment();
        b = new SubjectToBFragment();
        c = new SubjectToCFragment();
        d = new SubjectToDFragment();
        fragmentList.add(a);
        fragmentList.add(b);
        fragmentList.add(c);
        fragmentList.add(d);
    }

    private void initViewPager(){
        MainActivity activity= (MainActivity) binding.getRoot().getContext();
        FragmentManager fm = activity.getSupportFragmentManager();
        binding.testFragmentViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return stringList.get(position);
            }
        });
        binding.testFragmentTabLayout.setupWithViewPager(binding.testFragmentViewPager);
    }
}
