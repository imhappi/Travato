package com.thatsterrible.travato;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

public class DrawerActivity extends AppCompatActivity {

    public DrawerLayout fullLayout;
    public FrameLayout frameLayout;
    private Toolbar toolbar;
    ActionBarDrawerToggle mDrawerToggle;

    @Override
    public void setContentView(int layoutResID) {

        fullLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_drawer, null);
        frameLayout = (FrameLayout) fullLayout.findViewById(R.id.activity_content);

        getLayoutInflater().inflate(layoutResID, frameLayout, true);

        super.setContentView(fullLayout);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        final ActionBar actionBar = getSupportActionBar();

        CustomDrawerLayout drawerLayout = (CustomDrawerLayout) findViewById(R.id.drawer_layout);

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, 0, 0) {

                public void onDrawerClosed(View view) {
                    //drawerOpened = false;
                }

                public void onDrawerOpened(View drawerView) {
                    supportInvalidateOptionsMenu();
                    //drawerOpened = true;
                }
            };
            mDrawerToggle.setDrawerIndicatorEnabled(true);
            drawerLayout.setDrawerListener(mDrawerToggle);
            mDrawerToggle.syncState();
        }


        //Your drawer content...

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(final android.view.MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this behavior.
        mDrawerToggle.onOptionsItemSelected(item);

        return super.onOptionsItemSelected(item);
    }
}
