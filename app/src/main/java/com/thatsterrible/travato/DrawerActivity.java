package com.thatsterrible.travato;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

public class DrawerActivity extends AppCompatActivity {

    public CustomDrawerLayout fullLayout;
    public FrameLayout frameLayout;
    private Toolbar toolbar;
    ActionBarDrawerToggle mDrawerToggle;

    private ListView mDrawerList;
    private ArrayAdapter<String> mAdapter;


    @Override
    public void setContentView(int layoutResID) {

        fullLayout = (CustomDrawerLayout) getLayoutInflater().inflate(R.layout.activity_drawer,null);

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


        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        addDrawerItems();
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

    private void addDrawerItems() {
        // for the interest of time, hard coding as strings

        String[] menuItems = { "My Tours","Search for Tours","Settings","Logout" };
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menuItems);
        mDrawerList.setAdapter(mAdapter);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String optionSelected = mAdapter.getItem(position);
                Intent intent;

                if (optionSelected.equals("My Tours")) {
                    intent = new Intent(view.getContext(),MyToursActivity.class);
                } else if (optionSelected.equals("Search for Tours")) {
                    // todo when alex finishes search page
                } else if (optionSelected.equals("Settings")) {
                    // todo when settings is finished
                } else if (optionSelected.equals("Logout")) {

                }
            }
        });
    }
}
