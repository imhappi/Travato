package com.thatsterrible.travato;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pandominator on 11/06/16.
 */
public class MyToursAdapter extends RecyclerView.Adapter<MyToursViewHolder> {

    List<MyToursItem> mMyToursItem;

    public MyToursAdapter(){
        mMyToursItem = new ArrayList<>();
    }

    @Override
    public void onBindViewHolder(MyToursViewHolder holder, int position) {
        holder.setActivityImage(mMyToursItem.get(position).getGuideName());
        holder.setmGuideName(mMyToursItem.get(position).getGuideName());
        holder.setTourDescription(mMyToursItem.get(position).getGuideName());
    }

    @Override
    public MyToursViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mytoursitem, parent, false);
        // set the view's size, margins, paddings and layout parameters

        MyToursViewHolder vh = new MyToursViewHolder(v);
        return vh;
    }

    public void addMyTours(MyToursItem item){
        mMyToursItem.add(item);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
