package com.project.iip.base;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public abstract class BaseAdapter<E> extends ListAdapter<E, BaseHolder<E>> {
    protected BaseAdapter(DiffUtil.ItemCallback<E> diffCallback) {
        super(diffCallback);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseHolder<E> holder, int position) {
        holder.bind(getItem(position));
    }
}
