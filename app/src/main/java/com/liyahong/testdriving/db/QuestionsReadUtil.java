package com.liyahong.testdriving.db;

import android.content.Context;

import com.liyahong.testdriving.bean.Questions;

import java.io.IOException;
import java.util.List;

/**
 * Created by liyahong0327 on 2017/6/22.
 */

public class QuestionsReadUtil {

   public  static List<Questions> read(Context context) throws IOException {
       return new QuestionsReader(context.getAssets().open("subject1/questions.xml")).getQuestions();
   }
}
