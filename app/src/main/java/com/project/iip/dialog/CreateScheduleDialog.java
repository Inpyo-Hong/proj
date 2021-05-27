package com.project.iip.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.textfield.TextInputLayout;
import com.project.iip.R;
import com.project.iip.dto.Exercise;
import com.project.iip.singleton.AppDatabase;

public class CreateScheduleDialog extends Dialog {
    private long exerciseId;
    private OnConfirmCallback callback;


    public OnConfirmCallback getCallback() {
        return callback;
    }

    public void setCallback(OnConfirmCallback callback) {
        this.callback = callback;
    }

    public CreateScheduleDialog(@NonNull Context context) {
        super(context);
    }

    public CreateScheduleDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected CreateScheduleDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_create_schedule);

        onCreateExerciseTextInputLayout();
        onCreateConfirmButton();
    }

    private void onCreateExerciseTextInputLayout() {
        AppDatabase.getInstance(getContext()).exercise().select().observeForever(list -> {
            TextInputLayout inputLayout = findViewById(R.id.exercise_text_input_layout);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView)inputLayout.getEditText();

            autoCompleteTextView.setAdapter(
                    new ArrayAdapter(
                            getContext(),
                            android.R.layout.simple_spinner_dropdown_item,
                            list.stream().map(Exercise::getName).toArray()
                    )
            );
            autoCompleteTextView.setOnItemClickListener((parent, view, position, id) -> {
                exerciseId = list.get(position).getId();
                Log.d("PASS", "SELECT " + list.get(position).getName() + " ID : " + exerciseId);
            });
        });
    }

    private void onCreateConfirmButton() {
        Button confirmButton = findViewById(R.id.confirm_button);
        confirmButton.setOnClickListener(view -> {
            if (callback != null) {
                int set = Integer.parseInt(((TextInputLayout)findViewById(R.id.set_text_input_layout)).getEditText().getText().toString());
                int rep = Integer.parseInt(((TextInputLayout)findViewById(R.id.rep_text_input_layout)).getEditText().getText().toString());

                callback.onConfirm(exerciseId, set, rep);
            }

            dismiss();
        });
    }

    public interface OnConfirmCallback {
        void onConfirm(long exerciseId, int set, int rep);
    }
}
