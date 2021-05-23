package com.taetae98.iip.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.taetae98.iip.R;
import com.taetae98.iip.base.BaseAdapter;
import com.taetae98.iip.base.BaseHolder;
import com.taetae98.iip.dto.ScheduleWithExercise;

public class ScheduleWithExerciseAdapter extends BaseAdapter<ScheduleWithExercise> {
    private static final DiffUtil.ItemCallback<ScheduleWithExercise> itemCallback = new DiffUtil.ItemCallback<ScheduleWithExercise>() {
        @Override
        public boolean areItemsTheSame(@NonNull ScheduleWithExercise oldItem, @NonNull ScheduleWithExercise newItem) {
            return oldItem.getSchedule().getId() == newItem.getSchedule().getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull ScheduleWithExercise oldItem, @NonNull ScheduleWithExercise newItem) {
            return true;
        }
    };

    public ScheduleWithExerciseAdapter() {
        super(itemCallback);
        setHasStableIds(true);
    }

    @NonNull
    @Override
    public BaseHolder<ScheduleWithExercise> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ScheduleWithExerciseHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        viewType, parent, false
                )
        );
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getSchedule().getId();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.holder_schedule_with_exercise;
    }

    static class ScheduleWithExerciseHolder extends BaseHolder<ScheduleWithExercise> {
        private final TextView nameTextView;
        private final TextView setTextView;
        private final TextView repTextView;

        public ScheduleWithExerciseHolder(View view) {
            super(view);

            nameTextView = view.findViewById(R.id.name_text_view);
            setTextView = view.findViewById(R.id.set_text_view);
            repTextView = view.findViewById(R.id.rep_text_view);
        }

        @Override
        public void bind(ScheduleWithExercise element) {
            super.bind(element);
            nameTextView.setText(element.getExercise().getName());
            setTextView.setText(String.valueOf(element.getSchedule().getSet()));
            repTextView.setText(String.valueOf(element.getSchedule().getRep()));
        }
    }
}
