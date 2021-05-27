package com.project.iip.activity.Exercise_TIP.Tip.ViewPager.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.project.iip.R;

import org.jetbrains.annotations.NotNull;

public class Squat_Frag2 extends Fragment {
    private View view;

    public static Squat_Frag2 newinstance(){
        Squat_Frag2 squat_frag2 = new Squat_Frag2();
        return squat_frag2;
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.squat_frag_2, container, false);

        return view;
    }
}
