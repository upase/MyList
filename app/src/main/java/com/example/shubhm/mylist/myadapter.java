package com.example.shubhm.mylist;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentStatePagerAdapter;

/**
 * Created by Shubhm on 04-11-2016.
 */
public class myadapter extends FragmentStatePagerAdapter {

    public myadapter(FragmentManager fm){super(fm);}
    @Override
    public Fragment getItem(int i) {
        return ScreenSlidePageFragment.create(i);
    }

    @Override
    public int getCount() {
        return ScreenSlideActivity.NUM_PAGES;
    }
}
