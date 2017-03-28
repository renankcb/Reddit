package com.winnin.reddit.ui.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.winnin.reddit.ui.PagerEnum;

/**
 * Created by RenanKirk on 25/03/2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private PagerEnum[] fragmentList;

    private final Context context;

    public ViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        fragmentList = PagerEnum.values();
    }

    @Override
    public Fragment getItem(int position) {
        try {
            return (Fragment)fragmentList[position].getFragmentClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return new Fragment();
    }

    @Override
    public int getCount() {
        return fragmentList.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return context.getString(fragmentList[position].getTitle());
    }
}
