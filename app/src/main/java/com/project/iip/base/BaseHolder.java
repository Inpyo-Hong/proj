package com.project.iip.base;

import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseHolder<E> extends RecyclerView.ViewHolder {
    public BaseHolder(View view) {
        super(view);
    }

    public E element;

    public Context getContext() {
        return itemView.getContext();
    }

    public void bind(E element) {
        this.element = element;
    }
}
