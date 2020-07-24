package com.example.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

//<ItemTwo>泛型的具体使用
public class TypeTwoHolder extends TypeAbstarctViewHolder<ItemTwo> {

    private TextView title;

    public TypeTwoHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.content);
    }

    @Override
    public void bindHolder(ItemTwo item) {
           title.setText(item.title);
    }
}
