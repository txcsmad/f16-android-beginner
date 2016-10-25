package com.example.franklong.planetdrawer;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;


//This is a simplified version of the code from https://developer.android.com/training/implementing-navigation/nav-drawer.html
public class MainActivity extends Activity {
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private String[] mPlanetTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO explain XML resource
        mPlanetTitles = getResources().getStringArray(R.array.planets_array);

        //TODO attach adapter and listener

        //TODO select an item by default
    }


    //TODO Create listener
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    private void selectItem(int position) {
        //TODO update the main content by replacing fragments
    }
}