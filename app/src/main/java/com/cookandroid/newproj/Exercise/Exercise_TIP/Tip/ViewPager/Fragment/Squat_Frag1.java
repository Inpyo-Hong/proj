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

public class Squat_Frag1 extends Fragment {
    private View view;

    public static Squat_Frag1 newinstance(){
        Squat_Frag1 squat_frag1 = new Squat_Frag1();
        return squat_frag1;
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.squat_frag_1, container, false);

        return view;
    }
}
