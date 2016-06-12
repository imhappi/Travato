package com.thatsterrible.travato;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by naomikoo on 16-06-12.
 */
public class ProfileActivity extends DrawerActivity {

    String mGuideName;

    TextView mName;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        mGuideName = intent.getStringExtra("guide_name");

        // todo: should pass in id instead. Based on user id we should pull user information from database: age, nationality, etc
        // todo: should set profile picture with facebook

        mName = (TextView) findViewById(R.id.profile_name);
        updateViews();
    }

    private void updateViews() {
        if (mName != null && mGuideName != null) {
            mName.setText(mGuideName);
        }
    }
}
