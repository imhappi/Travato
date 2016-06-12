package com.thatsterrible.travato;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by naomikoo on 16-06-11.
 */
public class LocalTourViewHolder extends RecyclerView.ViewHolder {

    TextView mGuideName;
    TextView mTourTitle;
    ImageView mTourImage;
    TextView mCityName;
    TextView mPrice;
    TextView mDescription;
    TextView mCapacity;
    TextView mDate;

    View mItemContainer;

    LocalTourItem mLocalTourItem;

    public LocalTourViewHolder(View itemView) {
        super(itemView);

        mTourImage = (ImageView) itemView.findViewById(R.id.local_tour_image);
        mTourTitle = (TextView) itemView.findViewById(R.id.local_tour_title);
        mGuideName = (TextView) itemView.findViewById(R.id.local_tours_guide_name);
        mPrice = (TextView) itemView.findViewById(R.id.local_tours_price);
        mCapacity = (TextView) itemView.findViewById(R.id.local_tours_capacity);
        mDate = (TextView) itemView.findViewById(R.id.local_tours_date);
        mItemContainer = itemView.findViewById(R.id.local_tour_item_container);

        mItemContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Naomi","LocalTourViewHolder on click");
                Intent intent = new Intent(mItemContainer.getContext(), MyTourDetails.class);
                if (mLocalTourItem != null) {
                    intent.putExtra("local_tour_item", mLocalTourItem);
                }

            }
        });
    }


    public void setFields(LocalTourItem item) {
        mLocalTourItem = item;
        mPrice.setText(item.getPrice());
        mDescription.setText(item.getDescription());
        mCapacity.setText(item.getCapacity());
        mDate.setText(item.getDate());
        mCityName.setText(item.getCityName());
        mTourTitle.setText(item.getTourTitle());
        mGuideName.setText(item.getGuideName());
        // todo set tour image using library like picasso or glide
    }


}
