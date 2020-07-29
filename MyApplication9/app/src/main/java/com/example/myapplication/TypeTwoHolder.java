package com.example.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

//<ItemTwo>泛型的具体使用
public class TypeTwoHolder extends TypeAbstarctViewHolder<ActivityTwoClass> {

    public  View viewTwo;
    public  TextView title_two;
    public  ImageView dislike;
    public  ImageView  like;

    public TypeTwoHolder(View itemView) {
        super(itemView);

        viewTwo=itemView;
        dislike=(ImageView) itemView.findViewById(R.id.dislike) ;
        like=(ImageView) itemView.findViewById(R.id.like) ;
        title_two = (TextView) itemView.findViewById(R.id.title_Two);
    }

    @Override
    public void bindHolder(ActivityTwoClass item) {

       title_two.setText(item.getTitle());
       dislike.setImageResource(R.mipmap.dislike);
       like.setImageResource(R.drawable.love_normal);
    }
}
