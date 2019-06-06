package com.example.catfacts;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
private final List<Fragment> listfragment=new ArrayList<>();
private final List<String> listTitles= new ArrayList<>();




    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return listfragment.get(position);
    }

    @Override
    public int getCount() {
        return listTitles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listTitles.get(position);
    }

    public void  AddFragment(Fragment fragment, String title){
        listTitles.add(title);
        listfragment.add(fragment);
    }



}
