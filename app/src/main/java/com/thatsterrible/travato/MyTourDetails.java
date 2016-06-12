package com.thatsterrible.travato;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by pandominator on 11/06/16.
 */
public class MyTourDetails extends AppCompatActivity{

    ImageView mTourImage;
    TextView mGuideName;

    TextView mActivityText;
    TextView mDescriptionText;
    Button mBookButton;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_details);

        Intent intent = getIntent();
        String guideName = intent.getStringExtra("alexisthebest"); // alex you can't have the same key name for all these extras :I
        String imgUrl = intent.getStringExtra("alexisthebest");
        String tourName = intent.getStringExtra("alexisthebest");
        String tourDescription = intent.getStringExtra("alexisthebest");

        mTourImage = (ImageView) findViewById(R.id.local_tour_image);
        this.mGuideName = (TextView) findViewById(R.id.tourDetails_tourGuide);
        mDescriptionText = (TextView) findViewById(R.id.tourDetails_activityDescription);
        mActivityText = (TextView) findViewById(R.id.tourDetails_activityName);
        mBookButton = (Button) findViewById(R.id.tourDetails_bookButton);

        mBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    public void setGuideName(String guideName) {
        mGuideName.setText(guideName);
    }

}
