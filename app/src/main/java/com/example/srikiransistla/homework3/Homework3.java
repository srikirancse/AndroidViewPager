package com.example.srikiransistla.homework3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.Button;


public class Homework3 extends AppCompatActivity implements Fragment_List.OnListItemSelectedListener {

    private Fragment mContent1;
    private Fragment mContent;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        int id = item.getItemId();
        mContent1 = MySimpleFragment.newInstance(id); //passing id to fragment and creating new fragment

        getSupportFragmentManager().beginTransaction() //loading fragment
                .replace(R.id.container, mContent1)
                .commit();

        switch (id) {
            case R.id.action_fragment4:
                intent = new Intent(this, Activity_MasterDetail.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onListItemSelected(int ref) {
        //loads fragments into the this activity on request of other fragments
        mContent = MySimpleFragment.newInstance(ref);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, mContent   )
                .addToBackStack(null)
                .commit();
    }

    public static class MySimpleFragment extends Fragment {
        private static final String ARG_SECTION_NUMBER = "section_number";
        private int counter;

        private static MySimpleFragment newInstance(int sectionNumber) {
            MySimpleFragment fragment = new MySimpleFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public MySimpleFragment() {

        }


        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            if (savedInstanceState != null)
                counter = savedInstanceState.getInt("Counter");
            else
                counter = 0;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View rootView = null;
            int option = getArguments().getInt(ARG_SECTION_NUMBER);
            Intent intent;

            switch (option) {
                case R.id.action_fragment1:
                    rootView = inflater.inflate(R.layout.activity_coverpage, container, false);
                    final Button aboutme = (Button) rootView.findViewById(R.id.cpbutton1);
                    final Button task2 = (Button) rootView.findViewById(R.id.cpbutton2);
                    final Button task3 = (Button) rootView.findViewById(R.id.cpbutton3);

                    final Fragment_List.OnListItemSelectedListener mListener;
                    try {
                        mListener = (Fragment_List.OnListItemSelectedListener) getContext();
                    } catch (ClassCastException e) {
                        throw new ClassCastException("The hosting activity of the fragment" +
                                "forgot to implement onFragmentInteractionListener");
                    }

                    aboutme.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mListener.onListItemSelected(R.id.action_fragment2);
                        }
                    });

                    task2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getActivity(), Activity_ViewPager.class); //help taken to put getActivity()
                            startActivity(intent);
                        }
                    });
                    task3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getActivity(), Activity_MasterDetail.class); //help taken to put getActivity()
                            startActivity(intent);
                        }
                    });

                    break;
                case R.id.action_fragment2:
                    rootView = inflater.inflate(R.layout.activity_aboutme, container, false);
                    break;

            }

            return rootView;

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_simplefragment);

        if (savedInstanceState != null) {
            if (getSupportFragmentManager().getFragment(savedInstanceState, "mContent") != null)
                mContent = getSupportFragmentManager().getFragment(savedInstanceState, "mContent");
            else
                mContent = MySimpleFragment.newInstance(R.id.action_fragment1);
            Log.d("Message", "In if");
        } else {
            mContent = MySimpleFragment.newInstance(R.id.action_fragment1);
            Log.d("Message", "In else");
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, mContent)
                .commit();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mContent.isAdded())
            getSupportFragmentManager().putFragment(outState, "mContent", mContent);
    }

}

