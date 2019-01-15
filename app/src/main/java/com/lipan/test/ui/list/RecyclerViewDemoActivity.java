package com.lipan.test.ui.list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.lipan.test.R;
import com.lipan.test.adapter.MyAdapter;
import com.lipan.test.helper.PagingScrollHelper;
import com.lipan.test.view.HorizontalPageLayoutManager;


public class RecyclerViewDemoActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PagingScrollHelper scrollHelper;
    private HorizontalPageLayoutManager horizontalPageLayoutManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        init();
    }

    private void init() {
        recyclerView = findViewById(R.id.recyclerview);
        MyAdapter myAdapter = new MyAdapter();
        recyclerView.setAdapter(myAdapter);

        horizontalPageLayoutManager = new HorizontalPageLayoutManager(1, 5);
        recyclerView.setLayoutManager(horizontalPageLayoutManager);
        scrollHelper = new PagingScrollHelper();
        scrollHelper.setUpRecycleView(recyclerView);
    }
}
