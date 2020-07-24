package com.example.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

public class TypeThreeHolder extends TypeAbstarctViewHolder<ItemThree> {
    private VideoView video;
    private TextView title;


    public TypeThreeHolder(View itemView) {
        super(itemView);
        video=(VideoView) itemView.findViewById(R.id.video);
        title = (TextView) itemView.findViewById(R.id.name);

    }

    @Override
    public void bindHolder(ItemThree item) {

        title.setText(item.title);

    }
}
