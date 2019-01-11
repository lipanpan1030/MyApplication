package com.lipan.test.ui.animation;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.lipan.test.R;

public class VectorAnimationActivity extends AppCompatActivity {

    private ObjectAnimator mAnimator;
    private ImageView mImg;
    private FrameLayout mRoot;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_animation_vector);

        mRoot = findViewById(R.id.root);
        mImg = findViewById(R.id.img1);
    }

    public void begin(View view) {
        if (mAnimator == null) {
            mAnimator = ObjectAnimator.ofFloat(mRoot, "rotation", 0, 360);
            mAnimator.setDuration(600);
            mAnimator.start();
        } else {
            if (mAnimator.isRunning()) {
                return;
            } else if (mAnimator.isPaused()) {
                mAnimator.resume();
            } else {
                mAnimator.start();
            }
        }
    }

    private void beginCircleAnimator() {

    }

    public void pause(View view) {
        if (mAnimator != null) {
            mAnimator.pause();
        }
    }

}
