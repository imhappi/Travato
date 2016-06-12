package com.thatsterrible.travato;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;

public class MainActivity extends AppCompatActivity {

    public boolean isLoggedIn() {
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        return accessToken != null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FacebookSdk.sdkInitialize(getApplicationContext());



        if (isLoggedIn()) {
            Intent intent = new Intent(this, MyToursActivity.class);
            startActivity(intent);
        } else {

            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
    }
}
