package com.liyahong.testdriving.controllers;

import android.databinding.ObservableField;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.liyahong.testdriving.R;
import com.liyahong.testdriving.adapter.AnimationListenerAdapter;
import com.liyahong.testdriving.anim.TranslateD;
import com.liyahong.testdriving.bean.Questions;
import com.liyahong.testdriving.databinding.FragmentRandomExamBinding;
import com.liyahong.testdriving.databinding.SingleChoiceLayoutBinding;
import com.liyahong.testdriving.db.QuestionsReadUtil;
import com.liyahong.testdriving.fragments.MockExamFragment;
import com.liyahong.testdriving.fragments.RandomExamFragment;

import java.io.IOException;
import java.util.List;

/**
 * Created by liyahong0327 on 2017/6/23.
 */

public class RandomExamFragmentController {
    private RandomExamFragment fragment;
    private FragmentRandomExamBinding binding;
    private ObservableField<String> title =new ObservableField<>("");
    private ObservableField<String> description =new ObservableField<>("");
    private  List<Questions> questions;
    private Questions currentQuestions;
    private String type;
    private SingleChoiceLayoutBinding singleChoiceLayoutBinding;

    public RandomExamFragmentController(RandomExamFragment fragment, FragmentRandomExamBinding binding) {
        this.fragment = fragment;
        this.binding = binding;

        try {
            questions = QuestionsReadUtil.read(fragment.getActivity());
            showRandomQuestion();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(fragment.getActivity(),"读取文件失败",Toast.LENGTH_LONG).show();
        }

    }

    //随机练习
    public void showRandomQuestion(){
        description.set("");
        currentQuestions = this.questions.get((int) (Math.random() * this.questions.size()));
        title.set(currentQuestions.getTitle());
        type = currentQuestions.getType();
        if (type.equals("single")){
            binding.answerContainer.removeAllViews();
            singleChoiceLayoutBinding = SingleChoiceLayoutBinding.inflate(LayoutInflater.from(fragment.getContext()));
            binding.answerContainer.addView(singleChoiceLayoutBinding.getRoot());
            singleChoiceLayoutBinding.rbA.setText(currentQuestions.getA());
            singleChoiceLayoutBinding.rbB.setText(currentQuestions.getB());
            singleChoiceLayoutBinding.rbC.setText(currentQuestions.getC());
            singleChoiceLayoutBinding.rbD.setText(currentQuestions.getD());
        }
    }


    //下一题
    public void btnNextClickListener(View v){
        if (type.equals("single")){
            RadioGroup radioGroup = singleChoiceLayoutBinding.radioGroup;
            RadioButton radioButton = (RadioButton) radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
            String answer="";
            if (radioButton==singleChoiceLayoutBinding.rbA){
                answer="a";
            }else if (radioButton==singleChoiceLayoutBinding.rbB){
                answer="b";
            }else if (radioButton==singleChoiceLayoutBinding.rbC){
                answer="c";
            }else if (radioButton==singleChoiceLayoutBinding.rbD){
                answer="d";
            }

            if (answer.equals(currentQuestions.getAnswer())){
                Toast.makeText(fragment.getActivity(),"正确",Toast.LENGTH_LONG).show();
                showRandomQuestion();
            }else{
                description.set(currentQuestions.getDescription());
            }
        }
    }

    //切换页面
    public void btnNavigateToMockFragmentClickedHandler(View v){

        fragment.getView().startAnimation(new TranslateD(0,90,true,350,new AnimationListenerAdapter(){
            @Override
            public void onAnimationEnd(Animation animation) {
                MockExamFragment mockExamFragment=new MockExamFragment();
                mockExamFragment.setInitAnimation(new TranslateD(-90,0,false,350,null));

                fragment.getFragmentManager().beginTransaction()
                        .replace(R.id.examFragment,mockExamFragment)
                        .commit();
            }
        }));
    }

    public ObservableField<String> getTitle() {
        return title;
    }

    public ObservableField<String> getDescription() {
        return description;
    }
}
