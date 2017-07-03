package com.liyahong.testdriving.activitys;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import com.liyahong.testdriving.R;
import com.liyahong.testdriving.controllers.MainController;
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

//        QuestionsReader questionsReader =new QuestionsReader(this,R.raw.questions);
//        for (Questions questions :questionsReader.getQuestions()){
//            String title = questions.getTitle();
//        }

    }

    public void replace(int type){
         controller.replace(type);
    }

    //打开侧滑菜单
    public void openDrawer(){
        binding.mainDrawerLayout.openDrawer(binding.mainFragmentSetting);
    }

    //关闭侧滑菜单
    public void closeDrawer(){
        binding.mainDrawerLayout.closeDrawer(binding.mainFragmentSetting);
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        //侧滑菜单是否打开
        boolean drawerOpen = binding.mainDrawerLayout.isDrawerOpen(binding.mainFragmentSetting);
       if (!drawerOpen){

       }else {

       }

        return super.onPrepareOptionsMenu(menu);
    }
}
