package com.taetae98.iip.activity.Exercise_TIP.Tip.ViewPager.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.taetae98.iip.R;
import org.jetbrains.annotations.NotNull;

public class Pushup_Frag1 extends Fragment {
    private View view;

    public static Pushup_Frag1 newinstance(){
        Pushup_Frag1 pushup_frag1 = new Pushup_Frag1();
        return pushup_frag1;
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.pushup_frag_1, container, false);

        return view;
    }
}
