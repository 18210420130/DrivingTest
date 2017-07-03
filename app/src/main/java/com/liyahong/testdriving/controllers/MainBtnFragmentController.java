package com.liyahong.testdriving.controllers;

import android.view.View;

import com.liyahong.testdriving.activitys.MainActivity;
import com.liyahong.testdriving.databinding.FragmentMainBtnBinding;
import com.liyahong.testdriving.fragments.MainBtnFragment;

/**
 * Created by liyahong0327 on 2017/6/19.
 */

public class MainBtnFragmentController {
    private MainBtnFragment fragment;
    private FragmentMainBtnBinding btnBinding;
    private final MainActivity activity;

    public MainBtnFragmentController(MainBtnFragment fragment, FragmentMainBtnBinding btnBinding) {
        this.fragment = fragment;
        this.btnBinding = btnBinding;
        activity = (MainActivity) btnBinding.getRoot().getContext();
    }

    public void setTestBtnClickListener(View v){
        activity.replace(MainActivity.TEXT_FRAGMENT);
    }

    public void setWealBtnClickListener(View v){
        activity.replace(MainActivity.WEAL_FRAGMENT);
    }

    public void setCommunityBtnClickListener(View v){
        activity.replace(MainActivity.COMMUNITY_FRAGMENT);
    }

    public void setFindBtnClickListener(View v){
        activity.replace(MainActivity.FIND_FRAGMENT);
    }

    public void setBuyCarBtnClickListener(View v){
        activity.replace(MainActivity.BUY_CAR_FRAGMENT);
    }


}
