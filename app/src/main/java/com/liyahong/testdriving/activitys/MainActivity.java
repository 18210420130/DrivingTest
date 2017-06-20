package com.liyahong.testdriving.activitys;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.liyahong.testdriving.controllers.MainController;
import com.liyahong.testdriving.R;
import com.liyahong.testdriving.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    public static final int TEXT_FRAGMENT=0;
    public static final int WEAL_FRAGMENT=1;
    public static final int COMMUNITY_FRAGMENT=2;
    public static final int FIND_FRAGMENT=3;
    public static final int BUY_CAR_FRAGMENT=4;

    private ActivityMainBinding binding;
    private MainController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main);
        controller = new MainController(this,binding);
        binding.setController(controller);
    }

    public void replace(int type){
         controller.replace(type);
    }
}
