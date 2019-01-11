package com.lipan.test.ui;

import android.graphics.Outline;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.lipan.test.R;

public class MainActivity extends AppCompatActivity {

    private CircleOutlineProvider mCircleOutlineProvider;
    private RoundRectOutlineProvider mRoundRectOutlineProvider;

    private int mElevationStep;
    private int mElevation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init1();
        init2();
    }

    private void init1() {
        mCircleOutlineProvider = new CircleOutlineProvider();

        mElevationStep = getResources().getDimensionPixelSize(
                R.dimen.elevation_step);

        final View floatingShape = findViewById(R.id.circle);

        floatingShape.setOutlineProvider(mCircleOutlineProvider);
        floatingShape.setClipToOutline(true);

        findViewById(R.id.raise_bt).setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        mElevation += mElevationStep;
                        floatingShape.setElevation(mElevation);

                    }
                });

        findViewById(R.id.lower_bt).setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        mElevation -= mElevationStep;
                        if (mElevation < 0) {
                            mElevation = 0;
                        }

                        floatingShape.setElevation(mElevation);

                    }
                });
    }

    private void init2() {
        mRoundRectOutlineProvider = new RoundRectOutlineProvider();

        final View floatingShape = findViewById(R.id.circle1);

        floatingShape.setOutlineProvider(mRoundRectOutlineProvider);
        floatingShape.setClipToOutline(true);

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //如果处于裁剪状态，恢复即可
                if (floatingShape.getClipToOutline()) {
                    floatingShape.setClipToOutline(false);
                } else {
                    floatingShape.setClipToOutline(true);
                }
            }
        });

        findViewById(R.id.raise_bt1).setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        mElevation += mElevationStep;
                        floatingShape.setElevation(mElevation);

                    }
                });

        findViewById(R.id.lower_bt1).setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        mElevation -= mElevationStep;
                        if (mElevation < 0) {
                            mElevation = 0;
                        }

                        floatingShape.setElevation(mElevation);

                    }
                });
    }

    /**
     * 椭圆形边框
     */
    private class CircleOutlineProvider extends ViewOutlineProvider {

        @Override
        public void getOutline(View view, Outline outline) {
            outline.setOval(0, 0, view.getWidth(), view.getHeight());
        }
    }

    /**
     * 圆角矩形边框
     */
    private class RoundRectOutlineProvider extends ViewOutlineProvider {
        @Override
        public void getOutline(View view, Outline outline) {
            int radius = 30;
            //view是match_parent的
            outline.setRoundRect(radius, radius, view.getWidth() - radius, view.getHeight() , radius);
        }
    }
}
