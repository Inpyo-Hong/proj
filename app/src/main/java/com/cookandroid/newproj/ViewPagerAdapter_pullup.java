package com.cookandroid.newproj;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter_pullup extends FragmentPagerAdapter {
    public ViewPagerAdapter_pullup(@NonNull FragmentManager fm) {
        super(fm);
    }

    //프레그먼트 교체를 보여주는 처리 구현
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return Pullup_Frag1.newinstance();
            case 1:
                return Pullup_Frag2.newinstance();
            case 2:
                return Pullup_Frag3.newinstance();
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
