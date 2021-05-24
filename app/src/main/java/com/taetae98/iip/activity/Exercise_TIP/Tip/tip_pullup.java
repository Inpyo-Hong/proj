package com.taetae98.iip.activity.Exercise_TIP.Tip;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.taetae98.iip.activity.Exercise_TIP.Tip.ViewPager.ViewPagerAdapter_pullup;
import com.taetae98.iip.R;
import com.google.android.material.tabs.TabLayout;

public class tip_pullup extends AppCompatActivity {
    private FragmentPagerAdapter fragmentPagerAdapter;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_pullup);

        viewPager = findViewById(R.id.viewPager3);
        fragmentPagerAdapter = new ViewPagerAdapter_pullup(getSupportFragmentManager());

        TabLayout tabLayout = findViewById(R.id.tabLayout3);
        viewPager.setAdapter(fragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}