package com.taetae98.iip.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.taetae98.iip.R;
import com.taetae98.iip.activity.ExerciseInformationActivity;
import com.taetae98.iip.base.BaseAdapter;
import com.taetae98.iip.base.BaseHolder;
import com.taetae98.iip.dto.Exercise;

public class ExerciseAdapter extends BaseAdapter<Exercise> {
    private static final DiffUtil.ItemCallback<Exercise> itemCallback = new DiffUtil.ItemCallback<Exercise>() {
        @Override
        public boolean areItemsTheSame(@NonNull Exercise oldItem, @NonNull Exercise newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Exercise oldItem, @NonNull Exercise newItem) {
            return true;
        }
    };

    public ExerciseAdapter() {
        super(itemCallback);
        setHasStableIds(true);
    }

    @NonNull
    @Override
    public BaseHolder<Exercise> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ExerciseHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        viewType, parent, false
                )
        );
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.holder_exercise;
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    static class ExerciseHolder extends BaseHolder<Exercise> {
        private final TextView nameTextView;
        public ExerciseHolder(View view) {
            super(view);
            view.setOnClickListener(v -> {
                getContext().startActivity(
                        new Intent(getContext(), ExerciseInformationActivity.class)
                                .putExtra("exercise", element)
                );
            });
            nameTextView = view.findViewById(R.id.exercise_name_text_view);
        }

        @Override
        public void bind(Exercise element) {
            super.bind(element);
            nameTextView.setText(element.getName());
        }
    }
}