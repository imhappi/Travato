package com.thatsterrible.travato;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by pandominator on 11/06/16.
 */
public class MyToursViewHolder extends RecyclerView.ViewHolder {

    TextView mGuideName;
    TextView mTourDescription;
    ImageView mActivityImage;


    public MyToursViewHolder(View itemView) {
        super(itemView);

        mGuideName = (TextView) itemView.findViewById(R.id.mytours_guideName);
        mTourDescription = (TextView) itemView.findViewById(R.id.mytours_tourDescription);
        mActivityImage = (ImageView) itemView.findViewById(R.id.mytours_activityImage);
    }

    public void setActivityImage(String activityImage) {
        // TO-DO
    }

    public void setTourDescription (String tourDescription){
        mTourDescription.setText(tourDescription);
    }

    public void setmGuideName(String guideName) {
        mGuideName.setText(guideName);
    }
}
