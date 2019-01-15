package com.lipan.test.ui.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.lipan.test.R;

public class VectorAnimationActivity extends AppCompatActivity {

    private ObjectAnimator mRotationAnimator;
    private AnimatorSet mSet;
    private ImageView mImg;
    private FrameLayout mRoot;
    private ObjectAnimator mTranslationAnimator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_animation_vector);

        mRoot = findViewById(R.id.root);
        mImg = findViewById(R.id.img1);
    }

    public void begin(View view) {
        if (mSet == null) {
            mSet = new AnimatorSet();
            mRotationAnimator = ObjectAnimator.ofFloat(mRoot, "rotation", 0, 360);
            mRotationAnimator.setDuration(600);

            mTranslationAnimator = ObjectAnimator.ofFloat(mRoot, "translationY", 300f);
            mTranslationAnimator.setDuration(600);

            mSet.playTogether(mRotationAnimator, mTranslationAnimator);
        } else {
            if (mSet.isRunning()) {
                return;
            } else if (mSet.isPaused()) {
                mSet.resume();
            } else {
                mSet.start();
            }
        }
    }

    public void pause(View view) {
        if (mSet != null) {
            mSet.pause();
        }
    }

}
