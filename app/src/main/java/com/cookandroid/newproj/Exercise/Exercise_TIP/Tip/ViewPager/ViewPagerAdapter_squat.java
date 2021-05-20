package com.cookandroid.newproj.Exercise.Exercise_TIP.Tip.ViewPager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.cookandroid.newproj.Exercise.Exercise_TIP.Tip.ViewPager.Fragment.Squat_Frag1;
import com.cookandroid.newproj.Exercise.Exercise_TIP.Tip.ViewPager.Fragment.Squat_Frag2;
import com.cookandroid.newproj.Exercise.Exercise_TIP.Tip.ViewPager.Fragment.Squat_Frag3;

public class ViewPagerAdapter_squat extends FragmentPagerAdapter {
    public ViewPagerAdapter_squat(@NonNull FragmentManager fm) {
        super(fm);
    }

    //프레그먼트 교체를 보여주는 처리 구현
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return Squat_Frag1.newinstance();
            case 1:
                return Squat_Frag2.newinstance();
            case 2:
                return Squat_Frag3.newinstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    //탭레이아웃 상단에 글씨
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
            case 0:
                return "1";
            case 1:
                return "2";
            case 2:
                return "3";
            default:
                return null;
        }
    }
}
