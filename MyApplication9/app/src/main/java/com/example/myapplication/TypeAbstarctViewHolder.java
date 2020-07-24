package com.example.myapplication;


import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

//<T>使用了泛型
public abstract class TypeAbstarctViewHolder<T> extends RecyclerView.ViewHolder {
    public TypeAbstarctViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindHolder(T item);
}
