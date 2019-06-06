package com.example.catfacts;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



public class MainActivity extends AppCompatActivity {

    private TabLayout tablayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        tablayout = (TabLayout) findViewById(R.id.tablayout_id);
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new FragmentMainList(), "Facts");
        adapter.AddFragment(new FragmentFav(), "Favorite");
        adapter.AddFragment(new FragmentDetail(), "Detail");
        viewPager.setAdapter(adapter);

        tablayout.setupWithViewPager(viewPager);
        tablayout.getTabAt(0).setIcon(R.drawable.ic_list_black_24dp);
        tablayout.getTabAt(1).setIcon(R.drawable.ic_bookmark_black_24dp);
        tablayout.getTabAt(2).setIcon(R.drawable.ic_info_black_24dp);

        //remove shadow from the action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);

    }


}
