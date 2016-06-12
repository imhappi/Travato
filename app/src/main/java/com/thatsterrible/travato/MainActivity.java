package com.thatsterrible.travato;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

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


        FacebookSdk.sdkInitialize(getApplicationContext(),new FacebookSdk.InitializeCallback() {
                    @Override
                    public void onInitialized() {
                        Intent intent;

                        if (isLoggedIn()) {
                            intent = new Intent(getApplicationContext(), ChooseLocalTour.class);
                        } else {
                            intent = new Intent(getApplicationContext(), LoginActivity.class);
                        }

                        intent = new Intent(getApplicationContext(), ProfileActivity.class);

                        startActivity(intent);
                        finish();
                    }
                });
    }
}
