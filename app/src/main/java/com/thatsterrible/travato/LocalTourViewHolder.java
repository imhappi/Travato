package com.thatsterrible.travato;

import android.support.v7.widget.RecyclerView;
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

    public LocalTourViewHolder(View itemView) {
        super(itemView);

        mTourImage = (ImageView) itemView.findViewById(R.id.local_tour_image);
        mTourTitle = (TextView) itemView.findViewById(R.id.local_tours_title);
        mGuideName = (TextView) itemView.findViewById(R.id.local_tours_guide_name);
        mPrice = (TextView) itemView.findViewById(R.id.local_tours_price);
        mCapacity = (TextView) itemView.findViewById(R.id.local_tours_capacity);
        mDate = (TextView) itemView.findViewById(R.id.local_tours_date);
    }

    public void setGuideName(String guideName) {
        mGuideName.setText(guideName);
    }

    public void setTourTitle(String tourTitle) {
        mTourTitle.setText(tourTitle);
    }

    public void setTourImage(String tourImage) {
        //TODO
    }

    public void setCityName(String cityName) {
        mCityName.setText(cityName);
    }

    public void setPrice(String price) {
        mPrice.setText(price);
    }

    public void setDescription(String description) {
        mDescription.setText(description);
    }

    public void setCapacity(String capacity) {
        mCapacity.setText(capacity);
    }

    public void setDate(String date) {
        mDate.setText(date);
    }


}
