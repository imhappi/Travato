package com.thatsterrible.travato;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by pandominator on 12/06/16.
 */
public class SearchActivity extends AppCompatActivity{

    String mCountryName;
    String mCityName;
    Button mSearchButton;
    EditText mEditCity;
    EditText mEditCountry;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mSearchButton = (Button) findViewById(R.id.search_Button);
        mEditCity = (EditText)findViewById(R.id.search_City);
        mEditCountry = (EditText)findViewById(R.id.search_Country);

        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCityName = mEditCity.getText().toString();
                mCountryName = mEditCountry.getText().toString();

                Intent intent = new Intent(SearchActivity.this, ChooseLocalTour.class);
                intent.putExtra("CITY_NAME", mCityName);
                intent.putExtra("COUNTRY_NAME", mCountryName);
                startActivity(intent);
            }
        });

    }
}
