package com.thatsterrible.travato;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by naomikoo on 16-06-11.
 */
public class LocalToursAdapter extends RecyclerView.Adapter<LocalTourViewHolder> {

    List<LocalTourItem> mLocalTourItems;

    public LocalToursAdapter() {
        mLocalTourItems = new ArrayList<>();
    }

    @Override
    public LocalTourViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.local_tour_item, parent, false);
        LocalTourViewHolder vh = new LocalTourViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(LocalTourViewHolder holder, int position) {
        holder.setFields(mLocalTourItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mLocalTourItems.size();
    }

    public void addLocalTour(LocalTourItem item) {
        mLocalTourItems.add(item);
        notifyDataSetChanged();
    }

    public void setLocalToursList(List<LocalTourItem> itemsList) {
        mLocalTourItems = itemsList;
        notifyDataSetChanged();
    }
}
