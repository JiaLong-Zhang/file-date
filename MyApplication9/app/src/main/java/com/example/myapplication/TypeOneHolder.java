package com.example.myapplication;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class TypeOneHolder extends TypeAbstarctViewHolder<ItemOne> {
    private ImageView avaterOne;
    private ImageView avaterThree;
    private ImageView avaterTwo;
    private TextView title;

    public TypeOneHolder(View itemView) {
        super(itemView);

        avaterOne = (ImageView) itemView.findViewById(R.id.avaterOne);
        avaterTwo = (ImageView) itemView.findViewById(R.id.avaterTwo);
        avaterThree = (ImageView) itemView.findViewById(R.id.avaterThree);
        title = (TextView) itemView.findViewById(R.id.title);
    }

    //为ViewHolder绑定数据
    @Override
    public void bindHolder(ItemOne item) {
        title.setText(item.title);

    }

}
