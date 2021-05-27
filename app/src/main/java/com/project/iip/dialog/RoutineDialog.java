package com.project.iip.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.project.iip.R;
import com.project.iip.adapter.ScheduleWithExerciseAdapter;
import com.project.iip.dto.ScheduleWithExercise;
import com.project.iip.singleton.AppDatabase;

import java.util.List;

public class RoutineDialog extends Dialog {
    private ScheduleWithExerciseAdapter scheduleWithExerciseAdapter = new ScheduleWithExerciseAdapter();
    private List<ScheduleWithExercise> list;

    public RoutineDialog(@NonNull Context context) {
        super(context);
    }

    public RoutineDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected RoutineDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_routine);

        onCreateRecyclerView();
    }

    private void onCreateRecyclerView() {
        scheduleWithExerciseAdapter.submitList(list);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(scheduleWithExerciseAdapter);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(
                0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT
        ) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                if (viewHolder instanceof ScheduleWithExerciseAdapter.ScheduleWithExerciseHolder) {
                    ScheduleWithExercise scheduleWithExercise = ((ScheduleWithExerciseAdapter.ScheduleWithExerciseHolder) viewHolder).element;
                    int position = recyclerView.getChildAdapterPosition(viewHolder.itemView);
                    AppDatabase.getInstance(getContext()).schedule().delete(scheduleWithExercise.getSchedule());
                    Log.d("PASS", list.toString());
                    list.remove(position);
                    Log.d("PASS", list.toString());

                    scheduleWithExerciseAdapter = new ScheduleWithExerciseAdapter();
                    scheduleWithExerciseAdapter.submitList(list);
                    recyclerView.setAdapter(scheduleWithExerciseAdapter);
                }
            }
        }).attachToRecyclerView(recyclerView);
    }

    public List<ScheduleWithExercise> getList() {
        return list;
    }

    public void setList(List<ScheduleWithExercise> list) {
        this.list = list;
    }
}
