package com.liyahong.testdriving.controllers;

import com.liyahong.testdriving.R;
import com.liyahong.testdriving.databinding.FragmentSubjectToABinding;
import com.liyahong.testdriving.fragments.RandomExamFragment;
import com.liyahong.testdriving.fragments.SubjectToAFragment;

/**
 * Created by liyahong0327 on 2017/6/21.
 */

public class SubjectToAFragmentController {
    private SubjectToAFragment fragment;
    private FragmentSubjectToABinding binding;

    public SubjectToAFragmentController(SubjectToAFragment fragment, FragmentSubjectToABinding binding) {
        this.fragment = fragment;
        this.binding = binding;
    }

    public void onResum(){
        fragment.getChildFragmentManager().beginTransaction().replace(R.id.examFragment,new RandomExamFragment()).commit();
    }

//    //顺序练题
//    public void btnSetOrderTrainingOnClickListener(View v){
//        intentToTestQuestionsListActivity();
//
//    }
//
//    //随机练题
//    public void btnSetRandomTrainingOnClickListener(View v){
//        intentToTestQuestionsListActivity();
//    }
//
//    private void intentToTestQuestionsListActivity() {
//        Intent intent=new Intent(fragment.getActivity(), TestQuestionsListActivity.class);
//        fragment.getActivity().startActivity(intent);
//    }


}
