package com.project.iip.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.project.iip.R;
import com.project.iip.activity.Camera.CameraActivity;
import com.project.iip.base.BaseAdapter;
import com.project.iip.base.BaseHolder;
import com.project.iip.dto.Schedule;
import com.project.iip.dto.ScheduleWithExercise;

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

    @Override
    public void onBindViewHolder(@NonNull BaseHolder<ScheduleWithExercise> holder, int position) {
        ScheduleWithExercise scheduleWithExercise = getItem(position);
        scheduleWithExercise.getSchedule().setSet(position + 1);
        holder.bind(scheduleWithExercise);
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

    public class ScheduleWithExerciseHolder extends BaseHolder<ScheduleWithExercise> {
        private Schedule E = null;
        private final TextView nameTextView;
        private final TextView setTextView;
        private final TextView repTextView;
        private final Button btnPosenet;
        private final boolean Done = false;

        public ScheduleWithExerciseHolder(View view) {
            super(view);

            nameTextView = view.findViewById(R.id.name_text_view);
            setTextView = view.findViewById(R.id.set_text_view);
            repTextView = view.findViewById(R.id.rep_text_view);
            btnPosenet = view.findViewById(R.id.btn_posenet);
            btnPosenet.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), CameraActivity.class);
                    intent.putExtra("E", E);
                    v.getContext().startActivity(intent);
                }
            });
        }

        @Override
        public void bind(ScheduleWithExercise element) {
            super.bind(element);
            E = element.getSchedule();
            nameTextView.setText(element.getExercise().getName());
            setTextView.setText(String.valueOf(element.getSchedule().getSet()));
            repTextView.setText(String.valueOf(element.getSchedule().getRep()));
            btnPosenet.setEnabled(!element.getSchedule().getDone());
        }
    }
}
