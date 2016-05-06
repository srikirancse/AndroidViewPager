package com.example.srikiransistla.homework3;

//import android.app.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.HashMap;


public class Activity_MasterDetail extends AppCompatActivity implements Fragment_Master.OnListItemSelectedListener {

    private boolean mTwoPane;


    public void onListItemSelected(int position, HashMap<String, ?> movie) {
        if (mTwoPane) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_container, Fragment_DetailView.newInstance(movie))
                    .addToBackStack(null)
                    .commit();
        }
        else{
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_container, Fragment_DetailView.newInstance(movie))
                    .addToBackStack(null)
                    .commit();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_detail);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_container, Fragment_Master.newInstance())
                    .commit();
        }

        if (findViewById(R.id.detail_container) != null) {
            mTwoPane = true;
        }
    }
}

