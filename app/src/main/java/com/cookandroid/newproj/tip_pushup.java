package com.cookandroid.newproj;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class tip_pushup extends AppCompatActivity {
    private FragmentPagerAdapter fragmentPagerAdapter;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_pushup);

        viewPager = findViewById(R.id.viewPager2);
        fragmentPagerAdapter = new ViewPagerAdapter_pushup(getSupportFragmentManager());

        TabLayout tabLayout = findViewById(R.id.tabLayout2);
        viewPager.setAdapter(fragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
