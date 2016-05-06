package com.example.srikiransistla.homework3;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.HashMap;

public class Fragment_Master extends Fragment {
    MovieData movieData=new MovieData();
    private static final String ARG_SECTION_NUMBER = "section_number";
    Button frozen;
    Button starwar;
    Button lionking;
    Button transformer;
    Button titanic;
    HashMap<String, ?> movie;

    public interface OnListItemSelectedListener{
        public void onListItemSelected(int position, HashMap<String,?> movie);
    }

    public static Fragment_Master newInstance() {
        Fragment_Master fragment = new Fragment_Master();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, R.id.action_fragment4);
        fragment.setArguments(args);
        return fragment;
    }

    public Fragment_Master() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_master,container,false);

        frozen=(Button) rootView.findViewById(R.id.button_frozen);
        starwar=(Button) rootView.findViewById(R.id.button_starwar);
        lionking=(Button) rootView.findViewById(R.id.button_lionking);
        transformer=(Button) rootView.findViewById(R.id.button_transformer);
        titanic=(Button) rootView.findViewById(R.id.button_titanic);

        final OnListItemSelectedListener mListener;
        try{
            mListener=(OnListItemSelectedListener) getContext();
        } catch (ClassCastException e){
            throw new ClassCastException("The hosting activity of the fragment" +
                    "forgot to implement onFragmentInteractionListener");
        }



        frozen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                movie=(HashMap<String, ?>) movieData.getItem(18);
                mListener.onListItemSelected(0,movie);
            }
        });

        starwar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                HashMap<String, ?> movie=(HashMap<String, ?>) movieData.getItem(4);
                mListener.onListItemSelected(1,movie);
            }
        });

        lionking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, ?> movie = (HashMap<String, ?>) movieData.getItem(11);
                mListener.onListItemSelected(2, movie);
            }
        });

        transformer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, ?> movie = (HashMap<String, ?>) movieData.getItem(17);
                mListener.onListItemSelected(3, movie);
            }
        });

        titanic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, ?> movie = (HashMap<String, ?>) movieData.getItem(1);
                mListener.onListItemSelected(4, movie);
            }
        });

        return rootView;

    }

    /*@Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        try{

        }
    }*/

}

