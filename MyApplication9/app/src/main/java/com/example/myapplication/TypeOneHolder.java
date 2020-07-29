package com.example.myapplication;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class TypeOneHolder extends TypeAbstarctViewHolder<ActivityOneClass> {
    public  ImageView avaterOne;
    public  ImageView avaterTwo;
    public  ImageView avaterThree;
    public  ImageView dislike;
    public  TextView title_One;
    public  ImageView like;

    public  View viewOne;

    public TypeOneHolder(View itemView) {
        super(itemView);

        viewOne=itemView;
        title_One = (TextView) itemView.findViewById(R.id.title_One);
        avaterOne = (ImageView) itemView.findViewById(R.id.avaterOne);
        avaterTwo = (ImageView) itemView.findViewById(R.id.avaterTwo);
        avaterThree = (ImageView) itemView.findViewById(R.id.avaterThree);
        dislike = (ImageView) itemView.findViewById(R.id.dislike);
        like=(ImageView) itemView.findViewById(R.id.like);
    }

    //为ViewHolder绑定数据
    @Override
    public void bindHolder(ActivityOneClass item) {
        title_One.setText(item.getTitle());
        dislike.setImageResource(R.mipmap.dislike);
        like.setImageResource(R.drawable.love_normal);
        avaterOne.setImageResource(item.getImageId());
        avaterTwo.setImageResource(item.getImageId());
        avaterThree.setImageResource(item.getImageId());


    }

}
