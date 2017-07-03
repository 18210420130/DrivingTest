package com.liyahong.testdriving.controllers;

import android.databinding.ObservableField;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.liyahong.testdriving.activitys.TestQuestionsListActivity;
import com.liyahong.testdriving.bean.Questions;
import com.liyahong.testdriving.databinding.ActivityTestQuestionsListBinding;
import com.liyahong.testdriving.databinding.SingleChoiceLayoutBinding;
import com.liyahong.testdriving.db.QuestionsReadUtil;

import java.io.IOException;
import java.util.List;

/**
 * Created by liyahong0327 on 2017/6/21.
 */

public class TestQuestionsListActivityController {
    private TestQuestionsListActivity activity;
    private ActivityTestQuestionsListBinding binding;

    private List<Questions> questions ;

    private ObservableField<String> title =new ObservableField<>("");
    private ObservableField<String> description =new ObservableField<>("");
    private Questions currentQuestion;
    private SingleChoiceLayoutBinding singleChoiceLayoutBinding;
    private String type;


    public TestQuestionsListActivityController(
            TestQuestionsListActivity activity,
            ActivityTestQuestionsListBinding binding) {
        this.activity = activity;
        this.binding = binding;
        try {
            //获取数据
            questions= QuestionsReadUtil.read(activity);
            showRandomQuestion();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(activity,"获取数据失败",Toast.LENGTH_LONG).show();
        }
    }




    //随机练习
    public void showRandomQuestion(){

        description.set("");
        currentQuestion = questions.get((int) (Math.random() * this.questions.size()));
        title.set(currentQuestion.getTitle());
        type = currentQuestion.getType();
        if (type !=null){
        if (type.equals("single")){
            binding.answerContainer.removeAllViews();
            singleChoiceLayoutBinding=SingleChoiceLayoutBinding.inflate(LayoutInflater.from(activity));
            binding.answerContainer.addView(singleChoiceLayoutBinding.getRoot());
            singleChoiceLayoutBinding.rbA.setText(currentQuestion.getA());
            singleChoiceLayoutBinding.rbB.setText(currentQuestion.getB());
            singleChoiceLayoutBinding.rbC.setText(currentQuestion.getC());
            singleChoiceLayoutBinding.rbD.setText(currentQuestion.getD());
        }

    }
    }

    //点击下一题
    public void btnNextClickListener(View v) {
        if (type != null) {
            if (type.equals("single")) {
                RadioGroup radioGroup = singleChoiceLayoutBinding.radioGroup;
                RadioButton radioButton = (RadioButton) radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());

                String answer = "";
                if (radioButton == singleChoiceLayoutBinding.rbA) {
                    answer = "a";
                } else if (radioButton == singleChoiceLayoutBinding.rbB) {
                    answer = "b";
                } else if (radioButton == singleChoiceLayoutBinding.rbC) {
                    answer = "c";
                } else if (radioButton == singleChoiceLayoutBinding.rbD) {
                    answer = "d";
                }
                if (answer.equals(currentQuestion.getAnswer())) {

                    Toast.makeText(activity, "正确", Toast.LENGTH_LONG).show();
                    showRandomQuestion();
                } else {
                    Toast.makeText(activity, "错误，请重新选择", Toast.LENGTH_LONG).show();

                    description.set(currentQuestion.getDescription());
                }
            }
        }

    }

    public ObservableField<String> getTitle() {
        return title;
    }

    public ObservableField<String> getDescription() {
        return description;
    }
}
