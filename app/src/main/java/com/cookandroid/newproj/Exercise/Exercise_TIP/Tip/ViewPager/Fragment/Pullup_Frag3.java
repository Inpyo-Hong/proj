package com.cookandroid.newproj.Exercise.Exercise_TIP.Tip.ViewPager.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cookandroid.newproj.R;

import org.jetbrains.annotations.NotNull;

public class Pullup_Frag3 extends Fragment {
    private View view;

    public static Pullup_Frag3 newinstance(){
        Pullup_Frag3 pullup_frag3 = new Pullup_Frag3();
        return pullup_frag3;
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.pullup_frag_3, container, false);

        return view;
    }
}
