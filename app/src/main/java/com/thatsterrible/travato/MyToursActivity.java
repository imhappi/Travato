package com.thatsterrible.travato;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by pandominator on 11/06/16.
 */
public class MyToursActivity extends AppCompatActivity{

    private RecyclerView mMyRecyclerView;
    private MyToursAdapter mMyToursAdapter;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mMyRecyclerView = new RecyclerView(this);
        mMyRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        mMyToursAdapter = new MyToursAdapter();
        mMyRecyclerView.setAdapter(mMyToursAdapter);
    }
}
