package com.lipan.test.ui.snap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.lipan.test.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<Integer> mImagesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mImagesList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            mImagesList.add(R.drawable.ic_item1);
            mImagesList.add(R.drawable.ic_item2);
            mImagesList.add(R.drawable.ic_item3);

            mImagesList.add(R.drawable.ic_item4);
            mImagesList.add(R.drawable.ic_item5);
            mImagesList.add(R.drawable.ic_item6);

            mImagesList.add(R.drawable.ic_item7);
            mImagesList.add(R.drawable.ic_item8);
            mImagesList.add(R.drawable.ic_item9);

            mImagesList.add(R.drawable.ic_item10);
        }
        mRecyclerView = findViewById(R.id.rv_main);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mRecyclerView.setAdapter(new MyAdapter(mImagesList));

        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(mRecyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(view.getContext(), "position" + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        }));

        MySnapHelper mMySnapHelper = new MySnapHelper();
        mMySnapHelper.attachToRecyclerView(mRecyclerView);
    }
}
