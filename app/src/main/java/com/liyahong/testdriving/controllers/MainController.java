package com.liyahong.testdriving.controllers;

import com.liyahong.testdriving.R;
import com.liyahong.testdriving.activitys.MainActivity;
import com.liyahong.testdriving.databinding.ActivityMainBinding;
import com.liyahong.testdriving.fragments.BuyCarFragment;
import com.liyahong.testdriving.fragments.CommunityFragment;
import com.liyahong.testdriving.fragments.FindFragment;
import com.liyahong.testdriving.fragments.MainBtnFragment;
import com.liyahong.testdriving.fragments.SettingFragment;
import com.liyahong.testdriving.fragments.TestFragment;
import com.liyahong.testdriving.fragments.WealFragment;

/**
 * Created by liyahong0327 on 2017/6/19.
 */

public class MainController  {
    private MainActivity activity;
    private ActivityMainBinding binding;
    private  TestFragment testFragment;
    private  WealFragment wealFragment;
    private  CommunityFragment communityFragment;
    private  FindFragment findFragment;
    private  BuyCarFragment buyCarFragment;
    private  SettingFragment settingFragment;

    public MainController(MainActivity activity, ActivityMainBinding binding) {
        this.activity = activity;
        this.binding = binding;
        initFragment(activity);



    }

    private void initFragment(MainActivity activity) {
        testFragment = new TestFragment();
        wealFragment = new WealFragment();
        communityFragment = new CommunityFragment();
        findFragment = new FindFragment();
        buyCarFragment = new BuyCarFragment();
        settingFragment = new SettingFragment();
        BuyCarFragment mainListFragment=new BuyCarFragment();
        MainBtnFragment mainBtnFragment=new MainBtnFragment();
        activity.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_list_fragment,mainListFragment)
                .commit();
        activity.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_btn_fragment,mainBtnFragment)
                .commit();
        activity.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment_setting,settingFragment)
                .commit();
    }

    public void replace(int type){
        switch (type){
            case MainActivity.TEXT_FRAGMENT:
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_list_fragment,testFragment).commit();
                break;
            case MainActivity.WEAL_FRAGMENT:
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_list_fragment,wealFragment).commit();
                break;
            case MainActivity.COMMUNITY_FRAGMENT:
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_list_fragment,communityFragment).commit();
                break;
            case MainActivity.FIND_FRAGMENT:
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_list_fragment,findFragment).commit();
                break;
            case MainActivity.BUY_CAR_FRAGMENT:
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_list_fragment,buyCarFragment).commit();
                break;
        }
    }
}
