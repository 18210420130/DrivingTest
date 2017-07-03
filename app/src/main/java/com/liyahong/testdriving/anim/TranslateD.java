package com.liyahong.testdriving.anim;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

import com.liyahong.testdriving.adapter.AnimationListenerAdapter;

/**
 * Created by liyahong0327 on 2017/6/23.
 */

public class TranslateD extends Animation {

    private Camera camera;
    private int halfParentWidth;
    private int halfParentHeight;
    private float from,to,distance;
    private boolean farAway =true;

   public TranslateD(float from, float to, boolean farAway, long duration, AnimationListenerAdapter adapter){
      this.from=from;
       this.to=to;
       distance=to-from;
       this.farAway=farAway;
       setDuration(duration);
       setAnimationListener(adapter);
   }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
       camera=new Camera();
        halfParentWidth =parentWidth/2;
        halfParentHeight=parentHeight/2;
        super.initialize(width, height, parentWidth, parentHeight);
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {

        Matrix matrix = t.getMatrix();
        camera.save();
        camera.translate(0,0,(farAway?interpolatedTime:1-interpolatedTime)*halfParentWidth);

        camera.rotateY(interpolatedTime*distance+from);
        camera.getMatrix(matrix);
        camera.restore();

        matrix.preTranslate(-halfParentWidth,-halfParentHeight);
        matrix.postTranslate(halfParentWidth,halfParentHeight);
    }
}
