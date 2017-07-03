package com.liyahong.testdriving.activitys;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.liyahong.testdriving.R;
import com.liyahong.testdriving.controllers.TestQuestionsListActivityController;
import com.liyahong.testdriving.databinding.ActivityTestQuestionsListBinding;

/**
 * Created by liyahong0327 on 2017/6/21.
 * 试题详情页面
 */

public class TestQuestionsListActivity extends AppCompatActivity {
    private ActivityTestQuestionsListBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(TestQuestionsListActivity.this, R.layout.activity_test_questions_list);
        TestQuestionsListActivityController controller =new TestQuestionsListActivityController(this,binding);
        binding.setController(controller);
    }


}
