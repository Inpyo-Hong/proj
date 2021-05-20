package com.cookandroid.newproj;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

public class Pushup_Frag2 extends Fragment {
    private View view;

    public static Pushup_Frag2 newinstance(){
        Pushup_Frag2 pushup_frag2 = new Pushup_Frag2();
        return pushup_frag2;
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.pushup_frag_2, container, false);

        return view;
    }
}
