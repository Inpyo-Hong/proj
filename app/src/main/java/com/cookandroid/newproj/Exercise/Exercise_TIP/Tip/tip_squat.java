package com.cookandroid.newproj.Exercise.Exercise_TIP.Tip;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.cookandroid.newproj.Exercise.Exercise_TIP.Tip.ViewPager.ViewPagerAdapter_squat;
import com.cookandroid.newproj.R;
import com.google.android.material.tabs.TabLayout;

public class tip_squat extends AppCompatActivity {

    private FragmentPagerAdapter fragmentPagerAdapter;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_squat);

        viewPager = findViewById(R.id.viewPager1);
        fragmentPagerAdapter = new ViewPagerAdapter_squat(getSupportFragmentManager());

        TabLayout tabLayout = findViewById(R.id.tabLayout1);
        viewPager.setAdapter(fragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
