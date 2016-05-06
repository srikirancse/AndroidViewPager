package com.example.srikiransistla.homework3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.Button;

import java.util.zip.Inflater;


public class Coverpage extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    private int counter;
    Button aboutme;

    private Coverpage newInstance(int sectionNumber) {
        Coverpage fragment = new Coverpage();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public Coverpage() {

    }


    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putInt("counter:",counter);
    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);


        if (savedInstanceState!=null)
            counter=savedInstanceState.getInt("Counter");
        else
            counter=0;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = null;
        int option = getArguments().getInt(ARG_SECTION_NUMBER);

        switch (option) {
            case R.id.action_fragment1:
                rootView = inflater.inflate(R.layout.activity_coverpage, container, false);

                break;
            case R.id.action_fragment2:
                rootView = inflater.inflate(R.layout.activity_aboutme, container, false);
                break;
        }

        return rootView;

    }
}
