package com.example.srikiransistla.homework3;

import android.support.v4.app.FragmentManager;
import android.content.Intent;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.util.HashMap;
import java.util.Locale;
import android.support.v4.app.Fragment;
import android.support.design.widget.TabLayout;

/**
 * Created by Srikiran Sistla on 2/10/2016.
 */
public class Activity_ViewPager extends AppCompatActivity {
    MyFragmentPagerAdapter myPagerAdapter;
    ViewPager mViewPager;
    MovieData movieData;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);

        movieData=new MovieData();

        //Adapter
        myPagerAdapter=new MyFragmentPagerAdapter(getSupportFragmentManager(),movieData.getSize());
        mViewPager=(ViewPager) findViewById(R.id.pager);//ViewPager
        mViewPager.setAdapter(myPagerAdapter); //connection between viewpager and adapter
        mViewPager.setCurrentItem(3);
        customizeViewPager(); //Animation

        TabLayout tabLayout=(TabLayout) findViewById(R.id.tabs); // find the tab layout
        tabLayout.setupWithViewPager(mViewPager); //connect tab layout with viewpager


    }

    private void customizeViewPager(){
        mViewPager.setPageTransformer(false,new ViewPager.PageTransformer(){
            @Override
            public void transformPage(View page,float position){
                final float normalized_position=Math.abs(Math.abs(position)-1);
                page.setScaleX(normalized_position/2+0.5f);
                page.setScaleY(normalized_position/2+0.5f);
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){
            @Override
            public void onPageScrolled(int i,float v,int i2){

            }

            @Override
            public void onPageSelected(int i){

            }

            @Override
            public void onPageScrollStateChanged(int i){

            }
        });
    }

    //Adapter class
    public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        int count;
//        MovieData movieData;

        public MyFragmentPagerAdapter(FragmentManager fm,int size){
            super(fm);
            count=size;
        }

        @Override
        //getItem is called on every swipe of a viewPager and this in turn returns a fragment
        public Fragment getItem(int position){
            return Fragment_DetailView.newInstance((HashMap<String,?>)movieData.getItem(position));
        }

        @Override
        public int getCount() {return count;}

        @Override
        //title of the fragment being displayed
        public CharSequence getPageTitle(int position){
            Locale l=Locale.getDefault();
            HashMap<String,?> movie=(HashMap<String,?>) movieData.getItem(position);
            String name=(String) movie.get("name");
            return name.toUpperCase(l);
        }
    }

}

