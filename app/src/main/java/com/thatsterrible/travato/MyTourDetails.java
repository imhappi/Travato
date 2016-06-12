package com.thatsterrible.travato;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by pandominator on 11/06/16.
 */
public class MyTourDetails extends DrawerActivity {

    ImageView mTourImage;
    TextView mGuideName;

    TextView mTourTitle;
    TextView mDescriptionText;
    Button mBookButton;
    LocalTourItem mLocalTourItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_details);

        Intent intent = getIntent();
        mLocalTourItem = (LocalTourItem) intent.getSerializableExtra("local_tour_item");

        mTourImage = (ImageView) findViewById(R.id.local_tour_image); //todo: img url
        mGuideName = (TextView) findViewById(R.id.tourDetails_tourGuide);
        mDescriptionText = (TextView) findViewById(R.id.tourDetails_activityDescription);
        mTourTitle = (TextView) findViewById(R.id.tourDetails_activityName);
        mBookButton = (Button) findViewById(R.id.tourDetails_bookButton);

        setupViews();

        mBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // todo make call to backend
            }
        });

        mGuideName.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mGuideName.getContext(), ProfileActivity.class);
                intent.putExtra("guide_name", mLocalTourItem.getGuideName());
                // may have to put id?
            }
        });
    }

    private void setupViews() {
        if (mLocalTourItem != null) {
            //todo: img url
            mGuideName.setText(mLocalTourItem.getGuideName());
            mDescriptionText.setText(mLocalTourItem.getDescription());
            mTourTitle.setText(mLocalTourItem.getTourTitle());
        }
    }
}
