package com.project.iip.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.project.iip.R;
import com.project.iip.base.BaseAdapter;
import com.project.iip.base.BaseHolder;
import com.project.iip.dto.Exercise;

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

    private OnExerciseClick onExerciseClick;

    public OnExerciseClick getOnExerciseClick() {
        return onExerciseClick;
    }

    public void setOnExerciseClick(OnExerciseClick onExerciseClick) {
        this.onExerciseClick = onExerciseClick;
    }

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

    public class ExerciseHolder extends BaseHolder<Exercise> {
        private final TextView nameTextView;
        public ExerciseHolder(View view) {
            super(view);
            view.setOnClickListener(v -> {
                if (onExerciseClick != null) {
                    onExerciseClick.onClick(element);
                }
            });
            nameTextView = view.findViewById(R.id.exercise_name_text_view);
        }

        @Override
        public void bind(Exercise element) {
            super.bind(element);
            nameTextView.setText(element.getName());
        }
    }

    public interface OnExerciseClick {
        public void onClick(Exercise exercise);
    }
}
